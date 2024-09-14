package software.sava.anchor.programs.drift;

import software.sava.anchor.programs.drift.anchor.DriftProgram;
import software.sava.anchor.programs.drift.anchor.types.OrderParams;
import software.sava.anchor.programs.drift.anchor.types.User;
import software.sava.core.accounts.PublicKey;
import software.sava.core.accounts.SolanaAccounts;
import software.sava.core.tx.Instruction;
import software.sava.rpc.json.http.client.SolanaRpcClient;
import software.sava.rpc.json.http.response.AccountInfo;
import software.sava.solana.programs.clients.NativeProgramAccountClient;

import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;

import static software.sava.anchor.programs.drift.anchor.types.MarketType.Perp;
import static software.sava.anchor.programs.drift.anchor.types.MarketType.Spot;

final class DriftProgramClientImpl implements DriftProgramClient {

  private final SolanaAccounts solanaAccounts;
  private final DriftAccounts accounts;
  private final PublicKey authority;
  private final PublicKey user;

  DriftProgramClientImpl(final NativeProgramAccountClient nativeProgramAccountClient,
                         final DriftAccounts accounts) {
    this.solanaAccounts = nativeProgramAccountClient.solanaAccounts();
    this.accounts = accounts;
    this.authority = nativeProgramAccountClient.ownerPublicKey();
    this.user = DriftPDAs.deriveMainUserAccount(accounts, authority).publicKey();
  }

  @Override
  public SolanaAccounts solanaAccounts() {
    return solanaAccounts;
  }

  @Override
  public DriftAccounts accounts() {
    return accounts;
  }

  @Override
  public DriftExtraAccounts extraAccounts() {
    return DriftExtraAccounts.createExtraAccounts(accounts);
  }

  @Override
  public PerpMarketConfig perpMarket(final DriftProduct product) {
    return accounts.perpMarketConfig(product);
  }

  @Override
  public PublicKey authority() {
    return authority;
  }

  @Override
  public CompletableFuture<AccountInfo<User>> fetchUser(final SolanaRpcClient rpcClient) {
    return fetchUser(rpcClient, user);
  }

  @Override
  public CompletableFuture<List<AccountInfo<User>>> fetchUsersByAuthority(final SolanaRpcClient rpcClient) {
    return fetchUsersByAuthority(rpcClient, authority);
  }

  @Override
  public CompletableFuture<List<AccountInfo<User>>> fetchUsersByAuthority(final SolanaRpcClient rpcClient,
                                                                          final PublicKey authority) {
    return rpcClient.getProgramAccounts(
        accounts.driftProgram(),
        List.of(
            User.SIZE_FILTER,
            User.createAuthorityFilter(authority)
        ),
        User.FACTORY
    );
  }

  @Override
  public Instruction placePerpOrder(final OrderParams orderParams) {
    return placePerpOrder(orderParams, authority, user);
  }

  @Override
  public Instruction placePerpOrder(final OrderParams orderParams,
                                    final PublicKey authority,
                                    final PublicKey user) {
    return DriftProgram.placePerpOrder(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        orderParams
    );
  }

  @Override
  public Instruction placeOrders(final OrderParams[] orderParams) {
    return placeOrders(orderParams, authority, user);
  }

  @Override
  public Instruction placeOrders(final OrderParams[] orderParams,
                                 final PublicKey authority,
                                 final PublicKey user) {
    return DriftProgram.placeOrders(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        orderParams
    );
  }

  @Override
  public Instruction cancelOrder(final int orderId) {
    return cancelOrder(authority, user, orderId);
  }

  @Override
  public Instruction cancelOrder(final PublicKey authority,
                                 final PublicKey user,
                                 final int orderId) {
    return DriftProgram.cancelOrder(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        OptionalInt.of(orderId)
    );
  }

  @Override
  public Instruction cancelOrders(final int[] orderIds) {
    return cancelOrders(authority, user, orderIds);
  }

  @Override
  public Instruction cancelOrders(final PublicKey authority,
                                  final PublicKey user,
                                  final int[] orderIds) {
    return DriftProgram.cancelOrdersByIds(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        orderIds
    );
  }

  @Override
  public Instruction cancelOrderByUserId(final int orderId) {
    return cancelOrderByUserId(authority, user, orderId);
  }

  @Override
  public Instruction cancelOrderByUserId(final PublicKey authority,
                                         final PublicKey user,
                                         final int orderId) {
    return DriftProgram.cancelOrderByUserId(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        orderId
    );
  }

  @Override
  public Instruction cancelAllOrders() {
    return cancelAllOrders(authority, user);
  }

  @Override
  public Instruction cancelAllOrders(final PublicKey authority,
                                     final PublicKey user) {
    return DriftProgram.cancelOrders(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        null,
        OptionalInt.empty(),
        null
    );
  }

  @Override
  public Instruction cancelAllSpotOrders() {
    return cancelAllSpotOrders(authority, user);
  }

  @Override
  public Instruction cancelAllSpotOrders(final PublicKey authority, final PublicKey user) {
    return DriftProgram.cancelOrders(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        Spot,
        OptionalInt.empty(),
        null
    );
  }

  @Override
  public Instruction cancelAllPerpOrders() {
    return cancelAllPerpOrders(authority, user);
  }

  @Override
  public Instruction cancelAllPerpOrders(final PublicKey authority, final PublicKey user) {
    return DriftProgram.cancelOrders(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        Perp,
        OptionalInt.empty(),
        null
    );
  }

  @Override
  public Instruction cancelAllOrders(final MarketConfig marketConfig) {
    return cancelAllOrders(authority, user, marketConfig);
  }

  @Override
  public Instruction cancelAllOrders(final PublicKey authority,
                                     final PublicKey user,
                                     final MarketConfig marketConfig) {
    return DriftProgram.cancelOrders(
        accounts.invokedDriftProgram(),
        accounts.stateKey(),
        user,
        authority,
        marketConfig instanceof PerpMarketConfig ? Perp : Spot,
        OptionalInt.of(marketConfig.marketIndex()),
        null
    );
  }
}

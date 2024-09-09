package software.sava.anchor.programs.drift.anchor.types;

import java.util.function.BiFunction;

import software.sava.core.accounts.PublicKey;
import software.sava.core.borsh.Borsh;
import software.sava.core.programs.Discriminator;
import software.sava.core.rpc.Filter;

import static software.sava.anchor.AnchorUtil.parseDiscriminator;
import static software.sava.core.accounts.PublicKey.readPubKey;
import static software.sava.core.encoding.ByteUtil.getInt16LE;
import static software.sava.core.encoding.ByteUtil.getInt32LE;
import static software.sava.core.encoding.ByteUtil.getInt64LE;
import static software.sava.core.encoding.ByteUtil.putInt16LE;
import static software.sava.core.encoding.ByteUtil.putInt32LE;
import static software.sava.core.encoding.ByteUtil.putInt64LE;

public record User(PublicKey _address,
                   Discriminator discriminator,
                   // The owner/authority of the account
                   PublicKey authority,
                   // An addresses that can control the account on the authority's behalf. Has limited power, cant withdraw
                   PublicKey delegate,
                   // Encoded display name e.g. "toly"
                   int[] name,
                   // The user's spot positions
                   SpotPosition[] spotPositions,
                   // The user's perp positions
                   PerpPosition[] perpPositions,
                   // The user's orders
                   Order[] orders,
                   // The last time the user added perp lp positions
                   long lastAddPerpLpSharesTs,
                   // The total values of deposits the user has made
                   // precision: QUOTE_PRECISION
                   long totalDeposits,
                   // The total values of withdrawals the user has made
                   // precision: QUOTE_PRECISION
                   long totalWithdraws,
                   // The total socialized loss the users has incurred upon the protocol
                   // precision: QUOTE_PRECISION
                   long totalSocialLoss,
                   // Fees (taker fees, maker rebate, referrer reward, filler reward) and pnl for perps
                   // precision: QUOTE_PRECISION
                   long settledPerpPnl,
                   // Fees (taker fees, maker rebate, filler reward) for spot
                   // precision: QUOTE_PRECISION
                   long cumulativeSpotFees,
                   // Cumulative funding paid/received for perps
                   // precision: QUOTE_PRECISION
                   long cumulativePerpFunding,
                   // The amount of margin freed during liquidation. Used to force the liquidation to occur over a period of time
                   // Defaults to zero when not being liquidated
                   // precision: QUOTE_PRECISION
                   long liquidationMarginFreed,
                   // The last slot a user was active. Used to determine if a user is idle
                   long lastActiveSlot,
                   // Every user order has an order id. This is the next order id to be used
                   int nextOrderId,
                   // Custom max initial margin ratio for the user
                   int maxMarginRatio,
                   // The next liquidation id to be used for user
                   int nextLiquidationId,
                   // The sub account id for this user
                   int subAccountId,
                   // Whether the user is active, being liquidated or bankrupt
                   int status,
                   // Whether the user has enabled margin trading
                   boolean isMarginTradingEnabled,
                   // User is idle if they haven't interacted with the protocol in 1 week and they have no orders, perp positions or borrows
                   // Off-chain keeper bots can ignore users that are idle
                   boolean idle,
                   // number of open orders
                   int openOrders,
                   // Whether or not user has open order
                   boolean hasOpenOrder,
                   // number of open orders with auction
                   int openAuctions,
                   // Whether or not user has open order with auction
                   boolean hasOpenAuction,
                   int[] padding1,
                   int lastFuelBonusUpdateTs,
                   int[] padding) implements Borsh {

  public static final int BYTES = 4760;
  public static final Filter SIZE_FILTER = Filter.createDataSizeFilter(BYTES);

  public static final int AUTHORITY_OFFSET = 8;
  public static final int DELEGATE_OFFSET = 40;
  public static final int NAME_OFFSET = 72;
  public static final int SPOT_POSITIONS_OFFSET = 104;
  public static final int PERP_POSITIONS_OFFSET = 488;
  public static final int ORDERS_OFFSET = 1320;
  public static final int LAST_ADD_PERP_LP_SHARES_TS_OFFSET = 4648;
  public static final int TOTAL_DEPOSITS_OFFSET = 4656;
  public static final int TOTAL_WITHDRAWS_OFFSET = 4664;
  public static final int TOTAL_SOCIAL_LOSS_OFFSET = 4672;
  public static final int SETTLED_PERP_PNL_OFFSET = 4680;
  public static final int CUMULATIVE_SPOT_FEES_OFFSET = 4688;
  public static final int CUMULATIVE_PERP_FUNDING_OFFSET = 4696;
  public static final int LIQUIDATION_MARGIN_FREED_OFFSET = 4704;
  public static final int LAST_ACTIVE_SLOT_OFFSET = 4712;
  public static final int NEXT_ORDER_ID_OFFSET = 4720;
  public static final int MAX_MARGIN_RATIO_OFFSET = 4724;
  public static final int NEXT_LIQUIDATION_ID_OFFSET = 4728;
  public static final int SUB_ACCOUNT_ID_OFFSET = 4730;
  public static final int STATUS_OFFSET = 4732;
  public static final int IS_MARGIN_TRADING_ENABLED_OFFSET = 4733;
  public static final int IDLE_OFFSET = 4734;
  public static final int OPEN_ORDERS_OFFSET = 4735;
  public static final int HAS_OPEN_ORDER_OFFSET = 4736;
  public static final int OPEN_AUCTIONS_OFFSET = 4737;
  public static final int HAS_OPEN_AUCTION_OFFSET = 4738;
  public static final int PADDING1_OFFSET = 4739;
  public static final int LAST_FUEL_BONUS_UPDATE_TS_OFFSET = 4744;
  public static final int PADDING_OFFSET = 4748;

  public static Filter createAuthorityFilter(final PublicKey authority) {
    return Filter.createMemCompFilter(AUTHORITY_OFFSET, authority);
  }

  public static Filter createDelegateFilter(final PublicKey delegate) {
    return Filter.createMemCompFilter(DELEGATE_OFFSET, delegate);
  }

  public static Filter createLastAddPerpLpSharesTsFilter(final long lastAddPerpLpSharesTs) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, lastAddPerpLpSharesTs);
    return Filter.createMemCompFilter(LAST_ADD_PERP_LP_SHARES_TS_OFFSET, _data);
  }

  public static Filter createTotalDepositsFilter(final long totalDeposits) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, totalDeposits);
    return Filter.createMemCompFilter(TOTAL_DEPOSITS_OFFSET, _data);
  }

  public static Filter createTotalWithdrawsFilter(final long totalWithdraws) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, totalWithdraws);
    return Filter.createMemCompFilter(TOTAL_WITHDRAWS_OFFSET, _data);
  }

  public static Filter createTotalSocialLossFilter(final long totalSocialLoss) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, totalSocialLoss);
    return Filter.createMemCompFilter(TOTAL_SOCIAL_LOSS_OFFSET, _data);
  }

  public static Filter createSettledPerpPnlFilter(final long settledPerpPnl) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, settledPerpPnl);
    return Filter.createMemCompFilter(SETTLED_PERP_PNL_OFFSET, _data);
  }

  public static Filter createCumulativeSpotFeesFilter(final long cumulativeSpotFees) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, cumulativeSpotFees);
    return Filter.createMemCompFilter(CUMULATIVE_SPOT_FEES_OFFSET, _data);
  }

  public static Filter createCumulativePerpFundingFilter(final long cumulativePerpFunding) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, cumulativePerpFunding);
    return Filter.createMemCompFilter(CUMULATIVE_PERP_FUNDING_OFFSET, _data);
  }

  public static Filter createLiquidationMarginFreedFilter(final long liquidationMarginFreed) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, liquidationMarginFreed);
    return Filter.createMemCompFilter(LIQUIDATION_MARGIN_FREED_OFFSET, _data);
  }

  public static Filter createLastActiveSlotFilter(final long lastActiveSlot) {
    final byte[] _data = new byte[8];
    putInt64LE(_data, 0, lastActiveSlot);
    return Filter.createMemCompFilter(LAST_ACTIVE_SLOT_OFFSET, _data);
  }

  public static Filter createNextOrderIdFilter(final int nextOrderId) {
    final byte[] _data = new byte[4];
    putInt32LE(_data, 0, nextOrderId);
    return Filter.createMemCompFilter(NEXT_ORDER_ID_OFFSET, _data);
  }

  public static Filter createMaxMarginRatioFilter(final int maxMarginRatio) {
    final byte[] _data = new byte[4];
    putInt32LE(_data, 0, maxMarginRatio);
    return Filter.createMemCompFilter(MAX_MARGIN_RATIO_OFFSET, _data);
  }

  public static Filter createNextLiquidationIdFilter(final int nextLiquidationId) {
    final byte[] _data = new byte[2];
    putInt16LE(_data, 0, nextLiquidationId);
    return Filter.createMemCompFilter(NEXT_LIQUIDATION_ID_OFFSET, _data);
  }

  public static Filter createSubAccountIdFilter(final int subAccountId) {
    final byte[] _data = new byte[2];
    putInt16LE(_data, 0, subAccountId);
    return Filter.createMemCompFilter(SUB_ACCOUNT_ID_OFFSET, _data);
  }

  public static Filter createStatusFilter(final int status) {
    return Filter.createMemCompFilter(STATUS_OFFSET, new byte[]{(byte) status});
  }

  public static Filter createIsMarginTradingEnabledFilter(final boolean isMarginTradingEnabled) {
    return Filter.createMemCompFilter(IS_MARGIN_TRADING_ENABLED_OFFSET, new byte[]{(byte) (isMarginTradingEnabled ? 1 : 0)});
  }

  public static Filter createIdleFilter(final boolean idle) {
    return Filter.createMemCompFilter(IDLE_OFFSET, new byte[]{(byte) (idle ? 1 : 0)});
  }

  public static Filter createOpenOrdersFilter(final int openOrders) {
    return Filter.createMemCompFilter(OPEN_ORDERS_OFFSET, new byte[]{(byte) openOrders});
  }

  public static Filter createHasOpenOrderFilter(final boolean hasOpenOrder) {
    return Filter.createMemCompFilter(HAS_OPEN_ORDER_OFFSET, new byte[]{(byte) (hasOpenOrder ? 1 : 0)});
  }

  public static Filter createOpenAuctionsFilter(final int openAuctions) {
    return Filter.createMemCompFilter(OPEN_AUCTIONS_OFFSET, new byte[]{(byte) openAuctions});
  }

  public static Filter createHasOpenAuctionFilter(final boolean hasOpenAuction) {
    return Filter.createMemCompFilter(HAS_OPEN_AUCTION_OFFSET, new byte[]{(byte) (hasOpenAuction ? 1 : 0)});
  }

  public static Filter createLastFuelBonusUpdateTsFilter(final int lastFuelBonusUpdateTs) {
    final byte[] _data = new byte[4];
    putInt32LE(_data, 0, lastFuelBonusUpdateTs);
    return Filter.createMemCompFilter(LAST_FUEL_BONUS_UPDATE_TS_OFFSET, _data);
  }

  public static User read(final byte[] _data, final int offset) {
    return read(null, _data, offset);
  }

  public static User read(final PublicKey _address, final byte[] _data) {
    return read(_address, _data, 0);
  }

  public static final BiFunction<PublicKey, byte[], User> FACTORY = User::read;

  public static User read(final PublicKey _address, final byte[] _data, final int offset) {
    if (_data == null || _data.length == 0) {
      return null;
    }
    final var discriminator = parseDiscriminator(_data, offset);
    int i = offset + discriminator.length();
    final var authority = readPubKey(_data, i);
    i += 32;
    final var delegate = readPubKey(_data, i);
    i += 32;
    final var name = Borsh.readArray(new int[32], _data, i);
    i += Borsh.fixedLen(name);
    final var spotPositions = Borsh.readArray(new SpotPosition[8], SpotPosition::read, _data, i);
    i += Borsh.fixedLen(spotPositions);
    final var perpPositions = Borsh.readArray(new PerpPosition[8], PerpPosition::read, _data, i);
    i += Borsh.fixedLen(perpPositions);
    final var orders = Borsh.readArray(new Order[32], Order::read, _data, i);
    i += Borsh.fixedLen(orders);
    final var lastAddPerpLpSharesTs = getInt64LE(_data, i);
    i += 8;
    final var totalDeposits = getInt64LE(_data, i);
    i += 8;
    final var totalWithdraws = getInt64LE(_data, i);
    i += 8;
    final var totalSocialLoss = getInt64LE(_data, i);
    i += 8;
    final var settledPerpPnl = getInt64LE(_data, i);
    i += 8;
    final var cumulativeSpotFees = getInt64LE(_data, i);
    i += 8;
    final var cumulativePerpFunding = getInt64LE(_data, i);
    i += 8;
    final var liquidationMarginFreed = getInt64LE(_data, i);
    i += 8;
    final var lastActiveSlot = getInt64LE(_data, i);
    i += 8;
    final var nextOrderId = getInt32LE(_data, i);
    i += 4;
    final var maxMarginRatio = getInt32LE(_data, i);
    i += 4;
    final var nextLiquidationId = getInt16LE(_data, i);
    i += 2;
    final var subAccountId = getInt16LE(_data, i);
    i += 2;
    final var status = _data[i] & 0xFF;
    ++i;
    final var isMarginTradingEnabled = _data[i] == 1;
    ++i;
    final var idle = _data[i] == 1;
    ++i;
    final var openOrders = _data[i] & 0xFF;
    ++i;
    final var hasOpenOrder = _data[i] == 1;
    ++i;
    final var openAuctions = _data[i] & 0xFF;
    ++i;
    final var hasOpenAuction = _data[i] == 1;
    ++i;
    final var padding1 = Borsh.readArray(new int[5], _data, i);
    i += Borsh.fixedLen(padding1);
    final var lastFuelBonusUpdateTs = getInt32LE(_data, i);
    i += 4;
    final var padding = Borsh.readArray(new int[12], _data, i);
    return new User(_address,
                    discriminator,
                    authority,
                    delegate,
                    name,
                    spotPositions,
                    perpPositions,
                    orders,
                    lastAddPerpLpSharesTs,
                    totalDeposits,
                    totalWithdraws,
                    totalSocialLoss,
                    settledPerpPnl,
                    cumulativeSpotFees,
                    cumulativePerpFunding,
                    liquidationMarginFreed,
                    lastActiveSlot,
                    nextOrderId,
                    maxMarginRatio,
                    nextLiquidationId,
                    subAccountId,
                    status,
                    isMarginTradingEnabled,
                    idle,
                    openOrders,
                    hasOpenOrder,
                    openAuctions,
                    hasOpenAuction,
                    padding1,
                    lastFuelBonusUpdateTs,
                    padding);
  }

  @Override
  public int write(final byte[] _data, final int offset) {
    int i = offset + discriminator.write(_data, offset);
    authority.write(_data, i);
    i += 32;
    delegate.write(_data, i);
    i += 32;
    i += Borsh.fixedWrite(name, _data, i);
    i += Borsh.fixedWrite(spotPositions, _data, i);
    i += Borsh.fixedWrite(perpPositions, _data, i);
    i += Borsh.fixedWrite(orders, _data, i);
    putInt64LE(_data, i, lastAddPerpLpSharesTs);
    i += 8;
    putInt64LE(_data, i, totalDeposits);
    i += 8;
    putInt64LE(_data, i, totalWithdraws);
    i += 8;
    putInt64LE(_data, i, totalSocialLoss);
    i += 8;
    putInt64LE(_data, i, settledPerpPnl);
    i += 8;
    putInt64LE(_data, i, cumulativeSpotFees);
    i += 8;
    putInt64LE(_data, i, cumulativePerpFunding);
    i += 8;
    putInt64LE(_data, i, liquidationMarginFreed);
    i += 8;
    putInt64LE(_data, i, lastActiveSlot);
    i += 8;
    putInt32LE(_data, i, nextOrderId);
    i += 4;
    putInt32LE(_data, i, maxMarginRatio);
    i += 4;
    putInt16LE(_data, i, nextLiquidationId);
    i += 2;
    putInt16LE(_data, i, subAccountId);
    i += 2;
    _data[i] = (byte) status;
    ++i;
    _data[i] = (byte) (isMarginTradingEnabled ? 1 : 0);
    ++i;
    _data[i] = (byte) (idle ? 1 : 0);
    ++i;
    _data[i] = (byte) openOrders;
    ++i;
    _data[i] = (byte) (hasOpenOrder ? 1 : 0);
    ++i;
    _data[i] = (byte) openAuctions;
    ++i;
    _data[i] = (byte) (hasOpenAuction ? 1 : 0);
    ++i;
    i += Borsh.fixedWrite(padding1, _data, i);
    putInt32LE(_data, i, lastFuelBonusUpdateTs);
    i += 4;
    i += Borsh.fixedWrite(padding, _data, i);
    return i - offset;
  }

  @Override
  public int l() {
    return BYTES;
  }
}

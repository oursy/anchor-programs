package software.sava.anchor.programs.glam.anchor.types;

import software.sava.core.borsh.Borsh;

public enum InvestorError implements Borsh.Enum {

  FundNotActive,
  InvalidShareClass,
  InvalidAssetSubscribe,
  InvalidPricingOracle,
  InvalidAssetsRedeem,
  InvalidTreasuryAccount;

  public static InvestorError read(final byte[] _data, final int offset) {
    return Borsh.read(InvestorError.values(), _data, offset);
  }
}
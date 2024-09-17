package software.sava.anchor.programs.kamino.lend.anchor.types;

import software.sava.core.borsh.Borsh;

import static software.sava.core.encoding.ByteUtil.getInt16LE;
import static software.sava.core.encoding.ByteUtil.getInt64LE;
import static software.sava.core.encoding.ByteUtil.putInt16LE;
import static software.sava.core.encoding.ByteUtil.putInt64LE;

// Reserve configuration values
public record ReserveConfig(// Status of the reserve Active/Obsolete/Hidden
                            int status,
                            // Asset tier -> 0 - regular (collateral & debt), 1 - isolated collateral, 2 - isolated debt
                            int assetTier,
                            // Flat rate that goes to the host
                            int hostFixedInterestRateBps,
                            // [DEPRECATED] Boost for side (debt or collateral)
                            byte[] reserved2,
                            // [DEPRECATED] Reward points multiplier per obligation type
                            byte[] reserved3,
                            // Protocol take rate is the amount borrowed interest protocol receives, as a percentage
                            int protocolTakeRatePct,
                            // Cut of the liquidation bonus that the protocol receives, as a percentage
                            int protocolLiquidationFeePct,
                            // Target ratio of the value of borrows to deposits, as a percentage
                            // 0 if use as collateral is disabled
                            int loanToValuePct,
                            // Loan to value ratio at which an obligation can be liquidated, as percentage
                            int liquidationThresholdPct,
                            // Minimum bonus a liquidator receives when repaying part of an unhealthy obligation, as bps
                            int minLiquidationBonusBps,
                            // Maximum bonus a liquidator receives when repaying part of an unhealthy obligation, as bps
                            int maxLiquidationBonusBps,
                            // Bad debt liquidation bonus for an undercollateralized obligation, as bps
                            int badDebtLiquidationBonusBps,
                            // Time in seconds that must pass before redemptions are enabled after the deposit limit is crossed
                            long deleveragingMarginCallPeriodSecs,
                            // The rate at which the deleveraging threshold decreases in slots per bps
                            // e.g. 1 bps per hour would be 7200 slots per bps (assuming 2 slots per second)
                            long deleveragingThresholdSlotsPerBps,
                            // Program owner fees assessed, separate from gains due to interest accrual
                            ReserveFees fees,
                            // Borrow rate curve based on utilization
                            BorrowRateCurve borrowRateCurve,
                            // Borrow factor in percentage - used for risk adjustment
                            long borrowFactorPct,
                            // Maximum deposit limit of liquidity in native units, u64::MAX for inf
                            long depositLimit,
                            // Maximum amount borrowed, u64::MAX for inf, 0 to disable borrows (protected deposits)
                            long borrowLimit,
                            // Token id from TokenInfos struct
                            TokenInfo tokenInfo,
                            // Deposit withdrawl caps - deposit & redeem
                            WithdrawalCaps depositWithdrawalCap,
                            // Debt withdrawl caps - borrow & repay
                            WithdrawalCaps debtWithdrawalCap,
                            byte[] elevationGroups,
                            int disableUsageAsCollOutsideEmode,
                            int utilizationLimitBlockBorrowingAbove,
                            byte[] reserved1,
                            // Maximum amount liquidity of this reserve borrowed outside all elevation groups
                            // - u64::MAX for inf
                            // - 0 to disable borrows outside elevation groups
                            long borrowLimitOutsideElevationGroup,
                            // Defines the maximum amount (in lamports of elevation group debt asset)
                            // that can be borrowed when this reserve is used as collateral.
                            // - u64::MAX for inf
                            // - 0 to disable borrows in this elevation group (expected value for the debt asset)
                            long[] borrowLimitAgainstThisCollateralInElevationGroup) implements Borsh {

  public static final int BYTES = 912;

  public static ReserveConfig read(final byte[] _data, final int offset) {
    if (_data == null || _data.length == 0) {
      return null;
    }
    int i = offset;
    final var status = _data[i] & 0xFF;
    ++i;
    final var assetTier = _data[i] & 0xFF;
    ++i;
    final var hostFixedInterestRateBps = getInt16LE(_data, i);
    i += 2;
    final var reserved2 = new byte[2];
    i += Borsh.readArray(reserved2, _data, i);
    final var reserved3 = new byte[8];
    i += Borsh.readArray(reserved3, _data, i);
    final var protocolTakeRatePct = _data[i] & 0xFF;
    ++i;
    final var protocolLiquidationFeePct = _data[i] & 0xFF;
    ++i;
    final var loanToValuePct = _data[i] & 0xFF;
    ++i;
    final var liquidationThresholdPct = _data[i] & 0xFF;
    ++i;
    final var minLiquidationBonusBps = getInt16LE(_data, i);
    i += 2;
    final var maxLiquidationBonusBps = getInt16LE(_data, i);
    i += 2;
    final var badDebtLiquidationBonusBps = getInt16LE(_data, i);
    i += 2;
    final var deleveragingMarginCallPeriodSecs = getInt64LE(_data, i);
    i += 8;
    final var deleveragingThresholdSlotsPerBps = getInt64LE(_data, i);
    i += 8;
    final var fees = ReserveFees.read(_data, i);
    i += Borsh.len(fees);
    final var borrowRateCurve = BorrowRateCurve.read(_data, i);
    i += Borsh.len(borrowRateCurve);
    final var borrowFactorPct = getInt64LE(_data, i);
    i += 8;
    final var depositLimit = getInt64LE(_data, i);
    i += 8;
    final var borrowLimit = getInt64LE(_data, i);
    i += 8;
    final var tokenInfo = TokenInfo.read(_data, i);
    i += Borsh.len(tokenInfo);
    final var depositWithdrawalCap = WithdrawalCaps.read(_data, i);
    i += Borsh.len(depositWithdrawalCap);
    final var debtWithdrawalCap = WithdrawalCaps.read(_data, i);
    i += Borsh.len(debtWithdrawalCap);
    final var elevationGroups = new byte[20];
    i += Borsh.readArray(elevationGroups, _data, i);
    final var disableUsageAsCollOutsideEmode = _data[i] & 0xFF;
    ++i;
    final var utilizationLimitBlockBorrowingAbove = _data[i] & 0xFF;
    ++i;
    final var reserved1 = new byte[2];
    i += Borsh.readArray(reserved1, _data, i);
    final var borrowLimitOutsideElevationGroup = getInt64LE(_data, i);
    i += 8;
    final var borrowLimitAgainstThisCollateralInElevationGroup = new long[32];
    Borsh.readArray(borrowLimitAgainstThisCollateralInElevationGroup, _data, i);
    return new ReserveConfig(status,
                             assetTier,
                             hostFixedInterestRateBps,
                             reserved2,
                             reserved3,
                             protocolTakeRatePct,
                             protocolLiquidationFeePct,
                             loanToValuePct,
                             liquidationThresholdPct,
                             minLiquidationBonusBps,
                             maxLiquidationBonusBps,
                             badDebtLiquidationBonusBps,
                             deleveragingMarginCallPeriodSecs,
                             deleveragingThresholdSlotsPerBps,
                             fees,
                             borrowRateCurve,
                             borrowFactorPct,
                             depositLimit,
                             borrowLimit,
                             tokenInfo,
                             depositWithdrawalCap,
                             debtWithdrawalCap,
                             elevationGroups,
                             disableUsageAsCollOutsideEmode,
                             utilizationLimitBlockBorrowingAbove,
                             reserved1,
                             borrowLimitOutsideElevationGroup,
                             borrowLimitAgainstThisCollateralInElevationGroup);
  }

  @Override
  public int write(final byte[] _data, final int offset) {
    int i = offset;
    _data[i] = (byte) status;
    ++i;
    _data[i] = (byte) assetTier;
    ++i;
    putInt16LE(_data, i, hostFixedInterestRateBps);
    i += 2;
    i += Borsh.writeArray(reserved2, _data, i);
    i += Borsh.writeArray(reserved3, _data, i);
    _data[i] = (byte) protocolTakeRatePct;
    ++i;
    _data[i] = (byte) protocolLiquidationFeePct;
    ++i;
    _data[i] = (byte) loanToValuePct;
    ++i;
    _data[i] = (byte) liquidationThresholdPct;
    ++i;
    putInt16LE(_data, i, minLiquidationBonusBps);
    i += 2;
    putInt16LE(_data, i, maxLiquidationBonusBps);
    i += 2;
    putInt16LE(_data, i, badDebtLiquidationBonusBps);
    i += 2;
    putInt64LE(_data, i, deleveragingMarginCallPeriodSecs);
    i += 8;
    putInt64LE(_data, i, deleveragingThresholdSlotsPerBps);
    i += 8;
    i += Borsh.write(fees, _data, i);
    i += Borsh.write(borrowRateCurve, _data, i);
    putInt64LE(_data, i, borrowFactorPct);
    i += 8;
    putInt64LE(_data, i, depositLimit);
    i += 8;
    putInt64LE(_data, i, borrowLimit);
    i += 8;
    i += Borsh.write(tokenInfo, _data, i);
    i += Borsh.write(depositWithdrawalCap, _data, i);
    i += Borsh.write(debtWithdrawalCap, _data, i);
    i += Borsh.writeArray(elevationGroups, _data, i);
    _data[i] = (byte) disableUsageAsCollOutsideEmode;
    ++i;
    _data[i] = (byte) utilizationLimitBlockBorrowingAbove;
    ++i;
    i += Borsh.writeArray(reserved1, _data, i);
    putInt64LE(_data, i, borrowLimitOutsideElevationGroup);
    i += 8;
    i += Borsh.writeArray(borrowLimitAgainstThisCollateralInElevationGroup, _data, i);
    return i - offset;
  }

  @Override
  public int l() {
    return BYTES;
  }
}

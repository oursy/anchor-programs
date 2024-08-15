package software.sava.anchor.programs.marinade.anchor.types;

import software.sava.core.accounts.PublicKey;
import software.sava.core.borsh.Borsh;

import static software.sava.core.accounts.PublicKey.readPubKey;

public record ResumeEvent(PublicKey state) implements Borsh {

  public static final int BYTES = 32;

  public static ResumeEvent read(final byte[] _data, final int offset) {
    final var state = readPubKey(_data, offset);
    return new ResumeEvent(state);
  }

  @Override
  public int write(final byte[] _data, final int offset) {
    int i = offset;
    state.write(_data, i);
    i += 32;
    return i - offset;
  }

  @Override
  public int l() {
    return BYTES;
  }
}

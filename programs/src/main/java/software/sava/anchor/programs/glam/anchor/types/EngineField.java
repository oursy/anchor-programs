package software.sava.anchor.programs.glam.anchor.types;

import software.sava.core.borsh.Borsh;

public record EngineField(EngineFieldName name, EngineFieldValue value) implements Borsh {

  public static final int BYTES = 2;

  public static EngineField read(final byte[] _data, final int offset) {
    int i = offset;
    final var name = EngineFieldName.read(_data, i);
    i += Borsh.len(name);
    final var value = EngineFieldValue.read(_data, i);
    return new EngineField(name, value);
  }

  @Override
  public int write(final byte[] _data, final int offset) {
    int i = offset;
    i += Borsh.write(name, _data, i);
    i += Borsh.write(value, _data, i);
    return i - offset;
  }

  @Override
  public int l() {
    return BYTES;
  }
}

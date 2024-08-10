package software.sava.anchor.programs.glam;

import software.sava.core.accounts.PublicKey;
import software.sava.core.accounts.meta.AccountMeta;

public record GlamAccountsRecord(PublicKey program, AccountMeta invokedProgram) implements GlamAccounts {

}

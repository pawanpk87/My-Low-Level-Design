package org.buildcode;

public class Account {
    private final String accountId;
    private final String email;
    private final String password;

    public Account(String accountId, String email, String password) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
    }

    public void resetPassword() {

    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
}
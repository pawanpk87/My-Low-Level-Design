package org.buildcode.model;

public class Account {
    private String id;
    private String email;
    private String password;

    public boolean resetPassword(String password) {
        // reset password
        return true;
    }

    public boolean authenticate(String password) {
        // authenticate
        return true;
    }
}
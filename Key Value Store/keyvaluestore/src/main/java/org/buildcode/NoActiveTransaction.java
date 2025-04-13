package org.buildcode;

public class NoActiveTransaction extends RuntimeException {
    public NoActiveTransaction(String message) {
        super(message);
    }
}

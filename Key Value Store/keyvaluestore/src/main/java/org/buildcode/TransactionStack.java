package org.buildcode;

import java.util.Stack;

public class TransactionStack<K, V> {
    private final Stack<Transaction> transactions = new Stack<>();

    public void pushTransaction(Transaction transaction) {
        transactions.push(transaction);
    }

    public Transaction topTransaction() {
        if(transactions.isEmpty()) {
            throw new NoActiveTransaction("No Active transaction!");
        }
        return transactions.peek();
    }

    public Transaction popTransaction() {
        if(transactions.isEmpty()) {
            throw new NoActiveTransaction("No Active transaction!");
        }
        return transactions.pop();
    }

    public boolean isEmpty() {
        return transactions.isEmpty();
    }
 }
package org.buildcode;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private final List<TransactionOperation> transactionOperations = new ArrayList<TransactionOperation>();

    public void addTransactionOperation(TransactionOperation transactionOperation) {
        transactionOperations.add(transactionOperation);
    }

    public List<TransactionOperation> getTransactionOperations() {
        return transactionOperations;
    }
}
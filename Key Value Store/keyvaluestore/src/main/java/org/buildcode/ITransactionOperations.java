package org.buildcode;

public interface ITransactionOperations {
    void begin();
    void commit();
    void rollback();
}
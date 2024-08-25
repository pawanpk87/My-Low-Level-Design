package org.buildcode;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore <K, V> implements IKeyValueStore<K, V> {
    private static KeyValueStore INSTANCE = null;

    private final ConcurrentHashMap<K,V> store;
    private final ThreadLocal<TransactionStack<K,V>> transactions;

    private KeyValueStore() {
        store = new ConcurrentHashMap<>();
        transactions = new ThreadLocal<>();
        setupTransactionStack();
    }

    private void setupTransactionStack() {
        transactions.set(new TransactionStack<>());
    }

    public static KeyValueStore getInstance() {
        if(INSTANCE == null) {
            synchronized (KeyValueStore.class) {
                if(INSTANCE == null) {
                    INSTANCE = new KeyValueStore();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    final public void put(K key, V value) {
        if(transactions.get().isEmpty()) {
            store.put(key, value);
        } else {
            addToActiveTransaction(Type.PUT, key, value);
        }
    }

    @Override
    final public V get(K key) {
        V value = null;

        if(transactions.get().isEmpty()) {
            value = store.get(key);
        } else {
            value = getValueFromTransaction(key);
        }

        if(value == null) {
            throw new KeyNoFoundException("Key not found!");
        }

        return value;
    }

    @Override
    final public void remove(K key) {
        if(transactions.get().isEmpty()) {
            V deletedValue = store.remove(key);
            if(deletedValue == null) {
                throw new KeyNoFoundException("Key not found!");
            }
        } else {
            addToActiveTransaction(Type.REMOVE, key, null);
        }
    }

    @Override
    final public Set<K> keys() {
        return store.keySet();
    }

    @Override
    public void begin() {
        TransactionStack transactionStack = getTransactionStack();
        transactionStack.pushTransaction(new Transaction());
    }

    @Override
    public void commit() {
        if(transactions.get().isEmpty()) {
            System.out.println("Nothing to commit");
            return;
        }

        TransactionStack transactionStack = getTransactionStack();
        Transaction activeTransaction = transactionStack.popTransaction();

        for(TransactionOperation<K, V> transactionOperation : activeTransaction.getTransactionOperations()) {
            if(transactionOperation.type().equals(Type.PUT)) {
                put(transactionOperation.key(), transactionOperation.value());
            } else if(transactionOperation.type().equals(Type.REMOVE)) {
                remove(transactionOperation.key());
            } else {
                throw new RuntimeException("Invalid Operation type!");
            }
        }
    }

    @Override
    public void rollback() {
        if(transactions.get().isEmpty()) {
            System.out.println("Nothing to rollback");
            return;
        }
        TransactionStack transactionStack = getTransactionStack();
        transactionStack.popTransaction();
    }

    private TransactionStack getTransactionStack() {
        return transactions.get();
    }

    private void addToActiveTransaction(Type type, K key, V value) {
        TransactionStack transactionStack = getTransactionStack();
        Transaction activeTransaction = transactionStack.topTransaction();
        activeTransaction.addTransactionOperation(new TransactionOperation(type, key, value));
    }

    private V getValueFromTransaction(K key) {
        TransactionStack transactionStack = getTransactionStack();
        Transaction activeTransaction = transactionStack.popTransaction();

        for(TransactionOperation<K, V> transactionOperation : activeTransaction.getTransactionOperations()) {
            if(transactionOperation.key().equals(key)) {
                return transactionOperation.value();
            }
        }

        return null;
    }
}
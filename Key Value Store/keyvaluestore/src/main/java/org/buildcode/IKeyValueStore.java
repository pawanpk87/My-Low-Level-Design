package org.buildcode;

import java.util.Set;

public interface IKeyValueStore <K, V> extends ITransactionOperations {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    Set<K> keys();
}
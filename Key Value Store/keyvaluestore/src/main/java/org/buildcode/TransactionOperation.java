package org.buildcode;

public record TransactionOperation<K, V> (Type type, K key, V value) {
}
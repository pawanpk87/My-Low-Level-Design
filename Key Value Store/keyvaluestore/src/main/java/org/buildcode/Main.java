package org.buildcode;


public class Main {
    public static void main(String[] args) {
        /*
        * Resources
        * https://leetcode.com/discuss/interview-question/279913/bloomberg-onsite-key-value-store-with-transactions
        * https://www.freecodecamp.org/news/design-a-key-value-store-in-go/
        * */

        KeyValueStore<String, String> keyValueStore = KeyValueStore.getInstance();

        System.out.println("Running Test 1: Basic Put and Get Operations");
        keyValueStore.put("a", "123");
        keyValueStore.put("b", "345");

        assert "123".equals(keyValueStore.get("a")) : "Test 1 Failed: Expected value '123'";
        assert "345".equals(keyValueStore.get("b")) : "Test 1 Failed: Expected value '345'";

        System.out.println("Test 1 Passed");

        System.out.println("Running Test 2: Basic Transactions");
        keyValueStore.put("a", "123");
        keyValueStore.put("b", "345");

        keyValueStore.begin();
        keyValueStore.put("a", "345");

        keyValueStore.begin();
        keyValueStore.put("a", "777");
        System.out.println("Expected Output for Test 2: 777");
        System.out.println("Actual Output for Test 2: " + keyValueStore.get("a"));
        keyValueStore.commit();

        keyValueStore.remove("a");
        keyValueStore.commit();

        try {
            System.out.println("Expected Output for Test 2: Key not found");
            System.out.println("Actual Output for Test 2: " + keyValueStore.get("a"));
        } catch (KeyNoFoundException e) {
            System.out.println("Key not found as expected");
        }
        System.out.println();

        // Test 3: Transaction Rollback
        System.out.println("Running Test 3: Transaction Rollback");
        keyValueStore.put("a", "123");

        keyValueStore.begin();
        keyValueStore.put("a", "345");

        keyValueStore.rollback();

        System.out.println("Expected Output for Test 3: 123");
        System.out.println("Actual Output for Test 3: " + keyValueStore.get("a"));
        System.out.println();

        System.out.println("Running Test 4: Transaction Commit After Rollback");
        keyValueStore.put("a", "123");

        keyValueStore.begin();
        keyValueStore.put("a", "345");
        keyValueStore.rollback();

        keyValueStore.begin();
        keyValueStore.put("a", "777");
        keyValueStore.commit();

        System.out.println("Expected Output for Test 4: 777");
        System.out.println("Actual Output for Test 4: " + keyValueStore.get("a"));
        System.out.println();

        System.out.println("Running Test 5: Edge Cases");
        keyValueStore.rollback();
        keyValueStore.commit();

        keyValueStore.begin();
        keyValueStore.put("a", "123");
        keyValueStore.commit();

        System.out.println("Expected Output for Test 5: 123");
        System.out.println("Actual Output for Test 5: " + keyValueStore.get("a"));
        System.out.println();
    }
}
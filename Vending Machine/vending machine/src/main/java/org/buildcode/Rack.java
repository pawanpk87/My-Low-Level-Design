package org.buildcode;

import java.util.List;

public class Rack {
    private int rackNumber;
    private final List<Integer> productIds;

    public Rack(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public boolean isEmpty(){
        return productIds.isEmpty();
    }
}

package org.buildcode;

import org.buildcode.model.Product;

import java.util.List;

public class Inventory {
    private int noOfProducts;
    private final List<Product> products;

    public Inventory(List<Product> products){
        this.products = products;
    }

    public void addProduct(int productId, int rackId) {

    }

    public void removeProduct(int productId, int rackId) {

    }
}
package com.codecool.krk.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new LinkedList<Product>();
    }

    public void addProduct(Product product) {

        this.products.add(product);
    }

    public int size() {
        return this.products.size();
    }

    public Map<Product, Integer> asMap() {
        Map<Product, Integer> amountOfProducts = new HashMap<>();

        for (Product item: products) {
            amountOfProducts.putIfAbsent(item, 0);
            amountOfProducts.put(item, amountOfProducts.get(item) + 1);
        }

        return amountOfProducts;
    }
}

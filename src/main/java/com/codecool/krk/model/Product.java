package com.codecool.krk.model;

import java.util.Objects;

public class Product {

    private int barcode;
    private String name;

    public Product(int barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return barcode == product.barcode &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(barcode, name);
    }
}

package com.codecool.krk.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;

    @BeforeEach
    void setup() {
        this.cart = new Cart();
    }

    @Test
    void testAddThreeProducts() {
        this.cart.addProduct(new Product(123, "Piwo"));
        this.cart.addProduct(new Product(456, "Papier toaletowy"));
        this.cart.addProduct(new Product(789, "Bułka"));

        assertEquals(3, this.cart.size());
    }
}
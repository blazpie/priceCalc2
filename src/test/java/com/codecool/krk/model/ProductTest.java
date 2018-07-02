package com.codecool.krk.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product sampleProduct;

    @BeforeEach
    void createProduct() {
        sampleProduct = new Product(123456, "Piwo");
    }

    @Test
    void createProductTest() {

        assertEquals("Piwo", sampleProduct.getName());
    }



}
package com.codecool.krk.service;

import com.codecool.krk.model.Cart;
import com.codecool.krk.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BillMakerTest {

    private BillMaker billMaker;
    private Cart cart;

    private List<Product> prepareProducts() {

        List<Product> products = new LinkedList<>();
        products.add(new Product(1, "Jajka"));
        products.add(new Product(2, "Piwo"));
        products.add(new Product(3, "Parówki"));
        products.add(new Product(4, "Bułka"));

        return products;
    }
//
//    private Cart prepareCart() {
//        Cart testCart = new Cart();
//
//        for (Product product : prepareProducts()) {
//            testCart.addProduct(product);
//        }
//
//        return testCart;
//    }

    private PriceService preparePriceService() throws NoUnitPriceException {

        PriceService priceService = new PriceService();

        for (Product product : prepareProducts()) {
            priceService.setProductPrice(product, 1, new BigDecimal("2.50"));
            priceService.setProductPrice(product, 2, new BigDecimal("4.50"));
            priceService.setProductPrice(product, 5, new BigDecimal("8.00"));
        }

        return priceService;
    }



    @BeforeEach
    void setup() throws NoUnitPriceException {

        cart = new Cart();
        billMaker = new BillMaker(preparePriceService());

        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(3, "Parówki"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(1, "Jajka"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(2, "Piwo"));
        cart.addProduct(new Product(4, "Bułka"));


    }



    @Test
    void calculateTest() {

        // given

        BigDecimal expected = new BigDecimal("67.50");
        expected = expected.add(new BigDecimal("8.00"));
        expected = expected.add(new BigDecimal("4.50"));
        expected = expected.add(new BigDecimal("2.50"));
        System.out.println(expected + " = " + billMaker.calculate(cart));
        assertEquals(expected, billMaker.calculate(cart));
    }

}
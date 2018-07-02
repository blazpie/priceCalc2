package com.codecool.krk.service;

import com.codecool.krk.model.Cart;
import com.codecool.krk.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BillMaker {

    private PriceService service;

    public BillMaker(PriceService service) {
        this.service = service;
    }

    public BigDecimal calculate(Cart cart) {

        BigDecimal totalPrice = BigDecimal.ZERO;
        Map<Product, Integer> amountOfProducts = cart.asMap();

        for (Map.Entry<Product, Integer> entry : amountOfProducts.entrySet()) {
            totalPrice = totalPrice.add(service.getPrice(entry.getKey(), entry.getValue()));
        }

        return totalPrice;
    }

}

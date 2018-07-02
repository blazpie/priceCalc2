package com.codecool.krk.service;

import com.codecool.krk.model.Product;
import javafx.beans.property.ReadOnlyFloatWrapper;

import java.math.BigDecimal;
import java.util.*;

public class PriceService {
    Map<Product, Map<Integer, BigDecimal>> prices;

    public PriceService() {
        prices = new HashMap<Product, Map<Integer, BigDecimal>>();
    }

    public void setProductPrice(Product product, Integer count, BigDecimal price) throws NoUnitPriceException {

        if (!count.equals(1) && prices.get(product) == null) {
            throw new NoUnitPriceException();
        }
        if (prices.get(product) == null) {
            prices.put(product, new TreeMap<Integer, BigDecimal>((k1, k2) ->  k2 - k1));
        }
        prices.get(product).put(count, price);
    }

    public BigDecimal getPrice(Product product, Integer count) {
        Map<Integer, BigDecimal> productPrices = this.prices.get(product);
        BigDecimal price  = BigDecimal.ZERO;

        Iterator<Map.Entry<Integer, BigDecimal>> iter = productPrices.entrySet().iterator();

        while (count > 0) {
            Map.Entry<Integer, BigDecimal> record = iter.next();
            BigDecimal bucketCount = BigDecimal.valueOf(Math.floorDiv(count, record.getKey()));
            BigDecimal bucketPrice = record.getValue();
            price = price.add(bucketPrice.multiply(bucketCount));
            count = count - bucketCount.intValue() * record.getKey();
        }

        return price;

    }
}

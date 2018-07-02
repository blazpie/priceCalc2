package com.codecool.krk.service;

import com.codecool.krk.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PriceServiceTest {

    PriceService priceService;

    @BeforeEach
    void createPriceService() {
        priceService = new PriceService();
    }

    @Test
    void setPricesListTest() throws NoUnitPriceException {
        // given
        Product product = new Product(1234, "Piwo");
        Integer count = 1;
        BigDecimal price = new BigDecimal("2.50");
        // when
        priceService.setProductPrice(product, count, price);
        // then
        assertEquals(price, priceService.prices.get(product).get(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void getPriceTest(int count) throws NoUnitPriceException {
        //given
        Product product = new Product(1234, "Piwo");
        BigDecimal price = new BigDecimal("2.50").multiply(BigDecimal.valueOf(count));
        priceService.setProductPrice(product, 1, price);
        priceService.setProductPrice(product, count, price);
        //when
        BigDecimal resultValue = priceService.getPrice(product, count);
        //then
        assertEquals(price, resultValue);

    }

    @Test
    void sortingPriceMapTest() throws NoUnitPriceException {
        //given
        Product product = new Product(1234, "Piwo");
        BigDecimal price = new BigDecimal("2.50");
        List<Integer> counts = Arrays.asList(new Integer[]{1, 2, 3, 5});


        for (Integer count : counts) {
            priceService.setProductPrice(product, count, price);
        }
        Collections.reverse(counts);


        List<Integer> expected = new ArrayList<>();
        priceService.prices.get(product).keySet().forEach((elem) -> expected.add(elem));

        assertIterableEquals(counts, expected);

    }

    @Test
    void getPricePromotionTest() throws NoUnitPriceException {
        //given
        Product product = new Product(1234, "Piwo");
        BigDecimal price = new BigDecimal("2.50");
        BigDecimal promotionPrice = new BigDecimal("7.50");
        Integer count = 1;
        Integer promotionCount = 4;
        priceService.setProductPrice(product, count, price);
        priceService.setProductPrice(product, promotionCount, promotionPrice);
        //when
        BigDecimal resultValue = priceService.getPrice(product, promotionCount);
        //then
        assertEquals(promotionPrice, resultValue);
    }




}
package com.example.concurrent.service;

import com.example.concurrent.entity.Stock;
import com.example.concurrent.repository.StockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockServiceTest {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockService stockService;

    @BeforeEach
    public void before() {
        stockRepository.save(new Stock(1L, 100L));
    }

    @AfterEach
    public void after() {
        stockRepository.deleteAll();
    }

    @Test
    public void 재고감소() {
        stockService.decreaseStock(1L, 1L);

        // 100 - 1 = 99
        Stock stock = stockRepository.findById(1L).orElseThrow();
        Assertions.assertEquals(99L, stock.getQuantity());
    }

}
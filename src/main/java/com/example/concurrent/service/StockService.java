package com.example.concurrent.service;

import com.example.concurrent.entity.Stock;
import com.example.concurrent.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void decreaseStock(Long id, Long quantity) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("재고가 존재하지 않습니다."));
        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}

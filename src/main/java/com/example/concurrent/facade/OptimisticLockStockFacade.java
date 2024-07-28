package com.example.concurrent.facade;

import com.example.concurrent.service.StockService;
import org.springframework.stereotype.Component;

@Component
public class OptimisticLockStockFacade {

    private final StockService stockService;

    public OptimisticLockStockFacade(StockService stockService) {
        this.stockService = stockService;
    }

    public void decreaseStock(Long id, Long quantity) throws InterruptedException {
        while (true) {
            try {
                stockService.decreaseStock(id, quantity);

                // 정상적으로 업데이트가 되면 break문으로 빠져나옴.
                break;
            } catch (RuntimeException e) {
                // 재시도
                Thread.sleep(500);
            }
        }
    }
}

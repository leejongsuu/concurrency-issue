package com.example.concurrent.repository;

import com.example.concurrent.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}

package com.example.websocketproject.model.repository;

import com.example.websocketproject.model.entity.CryptoCurrency;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CryptoCurrencyJdbcRepository{
    List<CryptoCurrency> findAll();

    Optional<CryptoCurrency> findById(String id);

    CryptoCurrency save(CryptoCurrency currency);

    List<CryptoCurrency> saveAll(List<CryptoCurrency> currencies);
}

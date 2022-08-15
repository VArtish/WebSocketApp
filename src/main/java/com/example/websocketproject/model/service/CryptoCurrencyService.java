package com.example.websocketproject.model.service;

import com.example.websocketproject.model.entity.CryptoCurrency;

import java.util.List;
import java.util.Optional;

public interface CryptoCurrencyService {
    void updateCurrency();

    List<CryptoCurrency> getAll();

    Optional<CryptoCurrency> getCurrencyById(String id);
}

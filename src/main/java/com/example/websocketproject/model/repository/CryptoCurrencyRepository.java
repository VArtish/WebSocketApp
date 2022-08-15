package com.example.websocketproject.model.repository;

import com.example.websocketproject.model.entity.CryptoCurrency;
import org.springframework.data.repository.CrudRepository;

public interface CryptoCurrencyRepository extends CrudRepository<CryptoCurrency, String> {
}

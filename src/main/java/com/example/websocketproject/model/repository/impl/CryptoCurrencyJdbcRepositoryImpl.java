package com.example.websocketproject.model.repository.impl;

import com.example.websocketproject.model.entity.CryptoCurrency;
import com.example.websocketproject.model.mapper.CryptoCurrencyRowMapper;
import com.example.websocketproject.model.repository.CryptoCurrencyJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CryptoCurrencyJdbcRepositoryImpl implements CryptoCurrencyJdbcRepository {
    private static final String SQL_SELECT_ALL = "SELECT* FROM crypto_currencies";
    private static final String SQL_SELECT_BY_ID = "SELECT* FROM crypto_currencies WHERE crypto_currency_id = ?";
    private static final String SQL_UPDATE_CRYPTO_CURRENCY = "UPDATE crypto_currencies SET crypto_currency_name = (?), crypto_currency_price = (?) WHERE crypto_currency_id = ?";
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public CryptoCurrencyJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CryptoCurrency> findAll() {
        List<CryptoCurrency> currencies = jdbcTemplate.query(SQL_SELECT_ALL, CryptoCurrencyRowMapper::map);
        return currencies;
    }

    @Override
    public Optional<CryptoCurrency> findById(String id) {
        List<CryptoCurrency> currencies = jdbcTemplate.query(SQL_SELECT_BY_ID, CryptoCurrencyRowMapper::map, id);
        return currencies.isEmpty() ? Optional.empty() : Optional.of(currencies.get(0));
    }

    @Override
    public CryptoCurrency save(CryptoCurrency currency) {
        jdbcTemplate.update(SQL_UPDATE_CRYPTO_CURRENCY,
                currency.getName(), currency.getPrice(), currency.getCryptoCurrencyId());
        return currency;
    }

    @Override
    public List<CryptoCurrency> saveAll(List<CryptoCurrency> currencies) {
        for (CryptoCurrency currency : currencies) {
            jdbcTemplate.update(SQL_UPDATE_CRYPTO_CURRENCY,
                    currency.getName(), currency.getPrice(), currency.getCryptoCurrencyId());
        }

        return currencies;
    }
}

package com.example.websocketproject.model.mapper;

import com.example.websocketproject.model.entity.CryptoCurrency;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CryptoCurrencyRowMapper {
    private static final String CRYPTO_CURRENCY_ID = "crypto_currency_id";
    private static final String CRYPTO_CURRENCY_NAME = "crypto_currency_name";
    private static final String CRYPTO_CURRENCY_PRICE = "crypto_currency_price";

    private CryptoCurrencyRowMapper() {
    }

    public static CryptoCurrency map(ResultSet resultSet, int rowNum) throws SQLException {
        CryptoCurrency currency = new CryptoCurrency();
        currency.setPrice(resultSet.getDouble(CRYPTO_CURRENCY_PRICE));
        currency.setName(resultSet.getString(CRYPTO_CURRENCY_NAME));
        currency.setCryptoCurrencyId(resultSet.getString(CRYPTO_CURRENCY_ID));

        return currency;
    }
}

package com.example.websocketproject.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crypto_currencies")
@Schema(description = "Essence of cryptocurrency")
public class CryptoCurrency {
    @Id
    @Column(name = "crypto_currency_id")
    @Schema(description = "Key of crypto currency", accessMode = Schema.AccessMode.READ_ONLY)
    private String cryptoCurrencyId;
    @Column(name = "crypto_currency_name")
    @Schema(description = "Name of crypto currency")
    private String name;
    @Column(name = "crypto_currency_price")
    @Schema(description = "Price of crypto currency")
    private double price;
}

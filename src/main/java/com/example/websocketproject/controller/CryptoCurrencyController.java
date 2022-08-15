package com.example.websocketproject.controller;

import com.example.websocketproject.model.entity.CryptoCurrency;
import com.example.websocketproject.model.service.CryptoCurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Tag(name="CryptoCurrencyController", description="Controller to work with crypto currency")
@RestController
@RequestMapping("/api/cryptoCurrency")
public class CryptoCurrencyController {
    private final CryptoCurrencyService currencyService;

    @Autowired
    public CryptoCurrencyController(CryptoCurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Get all crypto currencies", description = "Allows you to get a list of all cryptocurrencies")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the users")})
    @GetMapping
    public List<CryptoCurrency> currencyList() {
        return currencyService.getAll();
    }

    @Operation(summary = "Get crypto currency by id", description = "Allows you to get crypto currency by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the user")})
    @GetMapping("/{cryptoCurrencyId}")
    public CryptoCurrency currency(@PathVariable @Parameter(description = "Crypto currency id") String cryptoCurrencyId) {
        Optional<CryptoCurrency> currencyOptional = currencyService.getCurrencyById(cryptoCurrencyId);
        return currencyOptional.isPresent() ? currencyOptional.get() : null;
    }
}

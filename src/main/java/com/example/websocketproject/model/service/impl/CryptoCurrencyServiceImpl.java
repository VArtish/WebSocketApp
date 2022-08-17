package com.example.websocketproject.model.service.impl;

import com.example.websocketproject.model.entity.CryptoCurrency;
import com.example.websocketproject.model.mapper.CryptoCurrencyJsonMapper;
import com.example.websocketproject.model.repository.CryptoCurrencyJdbcRepository;
import com.example.websocketproject.model.repository.CryptoCurrencyRepository;
import com.example.websocketproject.model.service.CryptoCurrencyService;
import com.example.websocketproject.model.service.RestTemplateService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {
    private final CryptoCurrencyJdbcRepository currencyRepository;
    private final RestTemplateService restTemplateService;
    private final SimpMessagingTemplate messagingTemplate;
    private static final String PART_URN = "/v1/tickers";
    private static final Logger LOGGER = LogManager.getLogger(CryptoCurrencyServiceImpl.class);

    @Autowired
    public CryptoCurrencyServiceImpl(RestTemplateService restTemplateService, SimpMessagingTemplate messagingTemplate, CryptoCurrencyJdbcRepository currencyRepository) {
        this.restTemplateService = restTemplateService;
        this.messagingTemplate = messagingTemplate;
        this.currencyRepository = currencyRepository;
    }


    @Override
    @Scheduled(fixedDelay=10000)
    public void updateCurrency() {
        LOGGER.log(Level.INFO, "Update currency!");
        String json = restTemplateService.sendRequest(PART_URN);
        List<CryptoCurrency> cryptoCurrencyList = CryptoCurrencyJsonMapper.map(json);
        currencyRepository.saveAll(cryptoCurrencyList);
        messagingTemplate.convertAndSend("/currency/list", cryptoCurrencyList);
    }

    public List<CryptoCurrency> getAll() {
        return (List<CryptoCurrency>) currencyRepository.findAll();
    }

    @Override
    public Optional<CryptoCurrency> getCurrencyById(String id) {
        return currencyRepository.findById(id);
    }


}

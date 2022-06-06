package com.alfa.gifusd.service;


import com.alfa.gifusd.client.ExchangesClient;
import com.alfa.gifusd.model.ExchangeRates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ExchangeRatesServiceImpTest {

    @MockBean
    private ExchangesClient exchangesClient;

    private ExchangeRates currentRates;
    private ExchangeRates yesterdayRates;

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @Value("${exchange-rat.rich}")
    private String RICH;
    @Value("${exchange-rat.broke}")
    private String BROKE;
    @Value("${exchange-rat.something}")
    private String NOCHANGES;


    @BeforeEach
    public void init() {
        currentRates = new ExchangeRates();
        Map<String, Double> currentRatesMap = new HashMap<>();
        currentRatesMap.put("AAB", 3.673);
        currentRatesMap.put("BBA", 88.0);
        currentRatesMap.put("ABD", 1.950229);
        currentRates.setRates(currentRatesMap);

        yesterdayRates = new ExchangeRates();
        Map<String, Double> yesterdayRatesMap = new HashMap<>();
        yesterdayRatesMap.put("AAB", 3.673);
        yesterdayRatesMap.put("BBA", 87.0);
        yesterdayRatesMap.put("ABD", 3.950229);
        yesterdayRates.setRates(yesterdayRatesMap);
    }

    @Test
    public void noChanges() {
        when(exchangesClient.getLatestRates(anyString())).thenReturn(currentRates);
        when(exchangesClient.getHistoricalRates(anyString(), anyString())).thenReturn(yesterdayRates);
        String result = exchangeRatesService.getGifStatus("AAB");
        Assertions.assertEquals(NOCHANGES, result);
    }

    @Test
    public void positiveChanges() {
        when(exchangesClient.getLatestRates(anyString())).thenReturn(currentRates);
        when(exchangesClient.getHistoricalRates(anyString(),anyString())).thenReturn(yesterdayRates);
        String result = exchangeRatesService.getGifStatus("BBA");
        Assertions.assertEquals(RICH, result);
    }

    @Test
    public void negativeChanges() {
        when(exchangesClient.getLatestRates(anyString())).thenReturn(currentRates);
        when(exchangesClient.getHistoricalRates(anyString(),anyString())).thenReturn(yesterdayRates);
        String result = exchangeRatesService.getGifStatus("ABD");
        Assertions.assertEquals(BROKE, result);
    }
}

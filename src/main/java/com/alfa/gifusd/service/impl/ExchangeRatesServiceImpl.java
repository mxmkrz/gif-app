package com.alfa.gifusd.service.impl;

import com.alfa.gifusd.client.ExchangesClient;
import com.alfa.gifusd.service.ExchangeRatesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {
    @Value("${exchange-rate.url.api_id}")
    private String appId;
    @Value("${exchange-rat.rich}")
    private String RICH;
    @Value("${exchange-rat.broke}")
    private String BROKE;
    @Value("${exchange-rat.something}")
    private String NOCHANGES;

    private final ExchangesClient exchangesClient;


    @Autowired
    public ExchangeRatesServiceImpl(ExchangesClient exchangesClient) {
        this.exchangesClient = exchangesClient;
    }


    @Override
    public List<String> getCodes() {
        return new ArrayList<>(exchangesClient.getLatestRates(appId).getRates().keySet());
    }

    @Override
    public String getGifStatus(String code) {
        int value = calculateDifferenceExchange(code);
        String result = "";
        switch (value) {
            case -1:{
                result = BROKE;
                break;
            }
            case 1 : {
                result = RICH;
                break;
            }
            case 0 : {
                result = NOCHANGES;
                break;
            }
        }
        log.info(result);
        return result;
    }

    private int calculateDifferenceExchange(String code) {
        return Double.compare(getCurrentRates(code), getPriviesRates(code));
    }

    private Double getCurrentRates(String code) {
        return exchangesClient.getLatestRates(appId).getRates().get(code);
    }


    private Double getPriviesRates(String code) {
        LocalDate today = LocalDate.of(
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH) + 1,
                Calendar.getInstance().get(Calendar.DATE));
        LocalDate yesterday = today.minusDays(1);

        return exchangesClient.getHistoricalRates(yesterday.toString(), appId).getRates().get(code);
    }

}

package com.alfa.gifusd.controller;

import com.alfa.gifusd.service.ExchangeRatesService;
import com.alfa.gifusd.service.impl.ExchangeRatesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExchangeController {

    private final ExchangeRatesService exchangeRatesService;


    @Autowired
    public ExchangeController(ExchangeRatesServiceImpl exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping("/codes")
    public List<String> getCodes() {
        return exchangeRatesService.getCodes();
    }

}

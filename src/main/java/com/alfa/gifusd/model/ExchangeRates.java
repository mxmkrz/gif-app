package com.alfa.gifusd.model;


import lombok.Data;

import java.util.Map;

@Data
public class ExchangeRates {
    private String disclaimer;
    private String license;
    private Integer timestamp;
    private String base;
    private Map<String, Double> rates;
}

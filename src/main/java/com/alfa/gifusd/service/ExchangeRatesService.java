package com.alfa.gifusd.service;

import java.util.List;

public interface ExchangeRatesService {
    List<String> getCodes();
    String getGifStatus(String code);
}

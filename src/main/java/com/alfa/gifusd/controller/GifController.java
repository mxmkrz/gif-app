package com.alfa.gifusd.controller;

import com.alfa.gifusd.service.ExchangeRatesService;
import com.alfa.gifusd.service.GifService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GifController {

    private final ExchangeRatesService exchangeRatesService;
    private final Gson gson;
    private final GifService gifService;

    @Autowired
    public GifController(ExchangeRatesService exchangeRatesService, Gson gson, GifService gifService) {
        this.exchangeRatesService = exchangeRatesService;
        this.gson = gson;
        this.gifService = gifService;
    }


    @GetMapping("/gif/{currency}")
    public String getGifReference(@PathVariable String currency) {
        String tag = exchangeRatesService.getGifStatus(currency);
        ResponseEntity<String> responseEntity = gifService.getGif(tag);
        JsonObject json = gson.fromJson(responseEntity.getBody(), JsonObject.class);
        return json.getAsJsonObject("data").
                getAsJsonObject("images").
                getAsJsonObject("original").
                getAsJsonPrimitive("url").
                getAsString();

    }
}

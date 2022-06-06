package com.alfa.gifusd.client;

import com.alfa.gifusd.model.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ExchangeClient", url = "https://openexchangerates.org/api/")
public interface ExchangesClient {


    @GetMapping("/latest.json")
    ExchangeRates getLatestRates(@RequestParam("app_id") String appId);

    @GetMapping("/historical/{date}.json")
    ExchangeRates getHistoricalRates(@PathVariable String date,
                                     @RequestParam("app_id") String appId);

}

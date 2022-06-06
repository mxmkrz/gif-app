package com.alfa.gifusd.service.impl;

import com.alfa.gifusd.client.GifClient;
import com.alfa.gifusd.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GifServiceImpl implements GifService {
    @Value("${giphy.api.key}")
    private String apiKey;
    private final GifClient gifClient;

    @Autowired
    public GifServiceImpl(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @Override
    public ResponseEntity<String> getGif(String tag) {
        return gifClient.getRandomGif(apiKey, tag);
    }
}

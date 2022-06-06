package com.alfa.gifusd.service;

import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<String> getGif(String tag);
}

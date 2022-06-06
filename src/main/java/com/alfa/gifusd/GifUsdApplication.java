package com.alfa.gifusd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GifUsdApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifUsdApplication.class, args);
	}

}

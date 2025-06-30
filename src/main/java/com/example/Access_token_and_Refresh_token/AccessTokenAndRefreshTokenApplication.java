package com.example.Access_token_and_Refresh_token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class AccessTokenAndRefreshTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessTokenAndRefreshTokenApplication.class, args);
	}

}

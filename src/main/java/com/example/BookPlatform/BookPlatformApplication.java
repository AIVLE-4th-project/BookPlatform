package com.example.BookPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BookPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookPlatformApplication.class, args);
	}

}

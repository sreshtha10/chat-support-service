package com.sreshtha.chat_support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class ChatSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatSupportApplication.class, args);
	}

}
package com.example.oauth_client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
class MessageClient {

	private final RestClient http;

	MessageClient(RestClient.Builder http) {
		this.http = http.build();
	}

	Message getMessage(String token) {

		return this.http //
			.get()//
			.uri("http://localhost:8081/message") //
			.headers(h -> h.setBearerAuth(token))
			.retrieve() //
			.body(Message.class);
	}

}

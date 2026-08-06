package com.example.oauth_client.restclient;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import static org.springframework.security.oauth2.client.web.ClientAttributes.clientRegistrationId;

@Component("restclientMessageClient")
class MessageClient {

    private final RestClient http;

    MessageClient(
            OAuth2AuthorizedClientManager am, // <.>
                  RestClient.Builder http) {
        this.http = http
                .requestInterceptor(new OAuth2ClientHttpRequestInterceptor(am)) // <.>
                .build();
    }

    Message getMessage() {
        return this.http //
                .get()//
                .uri("http://localhost:8081/message") //
                .attributes(clientRegistrationId("spring"))// <.>
                .retrieve() //
                .body(Message.class);
    }

}

package com.example.oauth_client.interfaces;

import org.springframework.security.oauth2.client.annotation.ClientRegistrationId;
import org.springframework.web.service.annotation.GetExchange;

@ClientRegistrationId("spring") // <.>
interface MessageClient {

    // <.>
    @GetExchange("http://localhost:8081/message")
    Message getMessage();

}

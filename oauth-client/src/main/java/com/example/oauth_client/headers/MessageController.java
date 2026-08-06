package com.example.oauth_client.headers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller ("headersMessageController")
@ResponseBody
class MessageController {

    private final MessageClient client;

    MessageController(@Qualifier("headersMessageClient") MessageClient client) {
        this.client = client;
    }

    @GetMapping("/headers")
    Message getMessage(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client) {
        var token = client.getAccessToken().getTokenValue();
        return this.client.getMessage(token);
    }

}

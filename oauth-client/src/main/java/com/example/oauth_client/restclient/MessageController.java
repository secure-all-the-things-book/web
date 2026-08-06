package com.example.oauth_client.restclient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("restclientMessageController")
@ResponseBody
class MessageController {

	private final MessageClient client;

	MessageController(@Qualifier("restclientMessageClient") MessageClient client) {
		this.client = client;
	}

	@GetMapping("/restclient")
	Message getMessage() {
		return this.client.getMessage();
	}

}

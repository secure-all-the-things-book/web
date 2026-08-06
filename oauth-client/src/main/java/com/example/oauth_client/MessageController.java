package com.example.oauth_client;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
class MessageController {

	private final MessageClient client;

	public MessageController(MessageClient client) {
		this.client = client;
	}

	@GetMapping("/")
	Message getMessage(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client) {
		var token = client.getAccessToken().getTokenValue();
		return this.client.getMessage(token);
	}

}

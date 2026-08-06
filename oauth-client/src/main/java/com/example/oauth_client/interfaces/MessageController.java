package com.example.oauth_client.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
class MessageController {

	private final MessageClient client;

	MessageController(MessageClient client) {
		this.client = client;
	}

	@GetMapping("/interfaces")
	Message getMessage() {
		return this.client.getMessage();
	}

}

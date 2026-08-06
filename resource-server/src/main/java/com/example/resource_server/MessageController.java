package com.example.resource_server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Map;

@Controller
@ResponseBody
class MessageController {

	@GetMapping("/message")
	Map<String, String> message(Principal principal) {
		return Map.of("message", "Hello " + principal.getName());
	}

}

package com.example.oauth_client.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.support.OAuth2RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(MessageClient.class) // <.>
class MessageClientConfiguration {

	@Bean
	OAuth2RestClientHttpServiceGroupConfigurer auth2RestClientHttpServiceGroupConfigurer(
			OAuth2AuthorizedClientManager aacm) { // <.>
		return OAuth2RestClientHttpServiceGroupConfigurer.from(aacm);
	}

}

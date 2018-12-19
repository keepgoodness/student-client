package com.yordan.student_client.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jordan
 */
@Component
public class BeanConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

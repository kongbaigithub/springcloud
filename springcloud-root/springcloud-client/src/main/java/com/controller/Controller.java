package com.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class Controller {

	@Bean
	@LoadBalanced//负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		RestTemplate restTemplate = getRestTemplate();
		String body = restTemplate.getForEntity("http://sayHello/hello/Eureka/", String.class).getBody();
		return "in Caller, "+body;
	}
}

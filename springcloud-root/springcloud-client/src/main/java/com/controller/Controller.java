package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
	//RestTemplate类型的对象本身不具备调用远程服务的能力，也就是说，引入该注解的目的存粹是为了让代码跑通
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		loadBalancerClient.choose("sayHello");
		RestTemplate restTemplate = getRestTemplate();
		String body = restTemplate.getForEntity("http://sayHello/hello/Eureka/", String.class).getBody();
		return "in Caller, "+body;
	}
}

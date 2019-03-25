package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired//描述Eureka客户端信息的类
	private DiscoveryClient eurekaClient; 
	
	@RequestMapping(value="/hello/{username}",method=RequestMethod.GET)
	public String hello(@PathVariable("username") String username) {
		ServiceInstance inst = eurekaClient.getLocalServiceInstance();
		//输出服务相关的信息
		System.out.println("host is:"+inst.getHost());
		System.out.println("port is:"+inst.getPort());
		System.out.println("ServiceId is:"+inst.getServiceId());
		System.out.println("url path is:"+inst.getUri().getPath());
		
		return "this is service2 ,hello "+username;
	}
}

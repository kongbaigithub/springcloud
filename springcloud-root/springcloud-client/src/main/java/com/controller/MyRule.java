package com.controller;

import java.util.List;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class MyRule implements IRule {
	
	private ILoadBalancer lb;

	@Override
	public Server choose(Object key) {
		int num = (int)(Math.random()*3);
		System.out.println("choose the number is "+num);
		List<Server> servers = lb.getAllServers();
		return servers.get(num);
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		this.lb = lb;
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		return lb;
	}

}

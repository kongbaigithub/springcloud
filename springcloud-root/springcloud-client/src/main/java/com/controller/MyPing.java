package com.controller;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyPing implements IPing {

	@Override
	public boolean isAlive(Server server) {
		
		double d = Math.random();
		if(d > 0.6) {
			System.out.println("Current Server is available, Name：" + server.getHost() + ", Port is:" + server.getHostPort());
			return true;
		}else {
			System.out.println("Current Server is not available, Name：" + server.getHost() + ", Port is:" + server.getHostPort());
			return false;
		}
	}

}

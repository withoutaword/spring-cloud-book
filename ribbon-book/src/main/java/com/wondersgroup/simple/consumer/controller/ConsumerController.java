package com.wondersgroup.simple.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wondersgroup.simple.consumer.entity.User;

@RestController
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/consumer/{id}")
	public User findById(@PathVariable Long id){
		
		return restTemplate.getForObject("http://provide/provice/"+id, User.class);
		
	}
	
	@GetMapping("/test")
	public String test(){
		ServiceInstance choose = loadBalancerClient.choose("provide");
		System.out.println("provode:uri:"+choose.getUri()+",port"+choose.getPort());
		ServiceInstance choose2 = loadBalancerClient.choose("provide1");
		System.out.println("provode2:uri:"+choose2.getUri()+",port"+choose2.getPort());
		return "provode";
		
	}
	
}

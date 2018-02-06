package com.wondersgroup.simple.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.wondersgroup.simple.consumer.entity.User;

@RestController
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;

	@GetMapping("/consumer/{id}")
	public User findById(@PathVariable Long id){
		InstanceInfo url = eurekaClient.getNextServerFromEureka("PROVIDE", false);
		return restTemplate.getForObject(url.getHomePageUrl()+"provice/"+id, User.class);
		
	}
	@GetMapping("/url")
	public String url(){
		InstanceInfo url = eurekaClient.getNextServerFromEureka("PROVIDE", false);
		return url.getHomePageUrl();
		
	}
	
}

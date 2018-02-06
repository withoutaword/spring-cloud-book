package com.wondersgroup.simple.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wondersgroup.simple.consumer.client.UserFeignClient;
import com.wondersgroup.simple.consumer.entity.User;

@RestController
public class ConsumerController {
	
	@Autowired
	UserFeignClient userFeignClient;
	
	@GetMapping("/consumer/{id}")
	public User findById(@PathVariable Long id){
		
		return userFeignClient.findById(id);
		
	}
	
	@GetMapping("/test")
	public User getUser( User user){
		
		return userFeignClient.getUser(user);
		
	}
	
}

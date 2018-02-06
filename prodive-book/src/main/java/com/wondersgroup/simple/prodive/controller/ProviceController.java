package com.wondersgroup.simple.prodive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.wondersgroup.simple.prodive.dao.ProviceDao;
import com.wondersgroup.simple.prodive.entity.User;

@RestController
public class ProviceController {

	@Autowired
	private ProviceDao proviceDao;
	
	@Autowired
	private EurekaClient eurekaClient; 
	
	@Autowired
	private DiscoveryClient discoveryClient;
	/**
	 * @return 只显示ip和端口号(需要输入项目名称)
	 */
	@GetMapping("/eureka-eureka")
	public String serviceUrl() {
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("provide", false);
	    return instance.getHomePageUrl();
	}
	/**
	 * @return 显示详细信息
	 */
	@GetMapping("/eureka-discovery")
	public ServiceInstance discovery() {
	    ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
	    String description = discoveryClient.description();
	    return localServiceInstance;
	}
	/**
	 * @return 显示详细信息
	 */
	@GetMapping("/eureka-description")
	public String description() {
	    String description = discoveryClient.description();
	    return description;
	}
	
	
	
	@GetMapping("/provice/{id}")
	public User findById(@PathVariable Long id){
		return proviceDao.findOne(id);
	}
	
	@GetMapping("/getUser")
	public User getUser( User user){
		return user;
	}
	
	
}

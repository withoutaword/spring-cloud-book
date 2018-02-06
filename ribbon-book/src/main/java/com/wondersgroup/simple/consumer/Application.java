package com.wondersgroup.simple.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.wondersgroup.simple.consumer.config.ExcludeFromConfiguraton;
import com.wondersgroup.simple.consumer.config.TestConfiguration;

@SpringBootApplication
@RibbonClient(name = "provide", configuration = TestConfiguration.class)
@ComponentScan(excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=ExcludeFromConfiguraton.class)})
public class Application {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	};

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

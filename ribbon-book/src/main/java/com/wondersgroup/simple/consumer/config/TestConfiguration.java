package com.wondersgroup.simple.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromConfiguraton
public class TestConfiguration {
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();//随机策略
	}
}

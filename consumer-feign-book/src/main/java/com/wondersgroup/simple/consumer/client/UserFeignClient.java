package com.wondersgroup.simple.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersgroup.simple.consumer.entity.User;

/**注意：
 * @RequestMapping(value="/provice/{id}",method=RequestMethod.GET)
 * 1. value 为提供者的请求资源路径
 * 2. feign不支持getmapping，postmapping等
 * 3. @PathVariable需要添加参数
 * @author Administrator
 *
 */
@FeignClient("provide") // 括号中的名字为服务端的名字
public interface UserFeignClient {
	@RequestMapping(value="/provice/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public User getUser(@RequestBody User user);

}

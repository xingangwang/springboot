/**
 * @Title: CasClient.java
 * @Package com.atme8.activity.service.client
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月14日 下午6:27:37
 * @version V1.0
 */

package com.atme8.activity.service.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atme8.activity.domain.entity.User;



/**
 * @ClassName: CasClient
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月14日 下午6:27:37
 *
 *
 */
@FeignClient("casRestServer")
public interface CasClient {

	@RequestMapping(value = "/api/v1/users", method = RequestMethod.POST)
	String regIntoCas(@RequestParam(value = "channel.channelId", required = true) String channelid,
					  @RequestParam(value = "phone", required = false) String phone,
					  @RequestParam(value = "realname", required = true) String realname,
					  @RequestParam(value = "password", required = true) String password,
					  @RequestParam("access_token") String access_token);
	
	/**
	 * getUser(这里用一句话描述这个方法的作用)
	 *
	 * @Title: getUser
	 * @Description: 
	 * @param opneid
	 * @param access_token
	 * @return  User   
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月30日 下午4:43:02
	 * 
	 */
	@RequestMapping(value = "/api/v1/users/{openid}", method = RequestMethod.GET)
	User getUser(@PathVariable("openid") String opneid, @RequestParam("access_token") String access_token);

	/**
	 * updatePhone(更新用户在cas的phone)
	 *
	 * @Title: updatePhone
	 * @Description: 
	 * @param value  void   
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月29日 下午8:34:46
	 * 
	 */
	@RequestMapping(value="/api/v1/users/{openId}",
			method=RequestMethod.PUT)
	void updateAccount(@PathVariable("openId") String openId,
					   @RequestParam(value = "isReplace", defaultValue = "false") boolean replace,
					   @RequestParam(value = "access_token") String token,
					   @RequestParam(value = "account") String account);
	
	
}

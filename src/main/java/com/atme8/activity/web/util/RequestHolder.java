/**
 * @Title: RequestHolder.java
 * @Package com.atme8.activity.common.util
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月9日 下午3:37:13
 * @version V1.0
 */

package com.atme8.activity.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;



/**
 * @ClassName: RequestHolder
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月9日 下午3:37:13
 *
 */

public class RequestHolder {
	public static HttpServletRequest getRequest(){
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return req;
    }

    public static HttpServletResponse getResponse(){
        HttpServletResponse resp = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
        return resp;
    }

    public static HttpSession getSession(){
		return getSession(true);
    }

    public static HttpSession getSession(boolean create){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(create);
    }
}

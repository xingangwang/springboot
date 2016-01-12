/**
 * @Title: SystemListener.java
 * @Package com.atme8.activity.web
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月8日 下午8:27:24
 * @version V1.0
 */

package com.atme8.activity.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @ClassName: SessionInitListener
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月8日 下午8:27:24
 *
 */
//@Component
public class SessionListener implements HttpSessionListener{

	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);
	
	public static final String CAS_CHECEKED_FLAG = "cas_checked_flag";
	
	public static final String CAS_CHECKED_VALUE = "1";
	
	/*
	 * <p>Title: sessionCreated</p>
	 * <p>Description: </p>
	 * @param se
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("Init session listener running ...");
		se.getSession().setAttribute(CAS_CHECEKED_FLAG, CAS_CHECKED_VALUE);
	}

	/*
	 * <p>Title: sessionDestroyed</p>
	 * <p>Description: </p>
	 * @param se
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// do nothing
		
		
	}



}

/**
 * @Title: SystemInitalizationException.java
 * @Package com.atme8.activity.web.exception
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月11日 下午4:07:26
 * @version V1.0
 */

package com.atme8.activity.web.exception;



/**
 * @ClassName: SystemInitalizationException
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月11日 下午4:07:26
 *
 */

public class SystemInitalizationException extends RuntimeException{
	
	/**
	 * @Fields serialVersionUID : （用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = -6247930578808240660L;

	public SystemInitalizationException() {
		super();
	}

	public SystemInitalizationException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemInitalizationException(String message) {
		super(message);
	}

	public SystemInitalizationException(Throwable cause) {
		super(cause);
	}
	
}

package com.atme8.activity.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class PublicWxService {

	private long ticketExpiresTime = 0L;
	
	private long accesstokenExpiresTime = 0L;
	
	private String ticket;
	
	private String accesstoken;
	
	private static String corpid = "wx462779a964aa9f50";
	
	private static String corpsecret = "79e846ffcde017f10c169d7e4c0d3039";
	
	private static Logger _LOGGER = LoggerFactory.getLogger(PublicWxService.class);

	//获取ticket
	public String getJsapiTicket(String accesstoken) throws Exception {
	    return getJsapiTicket(false,accesstoken);
	  }

	public String getJsapiTicket(boolean forceRefresh,String accesstoken) throws Exception {
	    //用来决定是否刷新
		if (forceRefresh) {
			expireJsapiTicket();
	    }
		//获取
		if (isJsapiTicketExpired()) {
			long dateNow = System.currentTimeMillis()/1000;
			ticketExpiresTime = 0L;
			ticketExpiresTime = dateNow + 6000L;
			HttpClient httpclient = new HttpClient();
			GetMethod getMethod = new GetMethod("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accesstoken+"&type=jsapi");
			HttpMethodParams params = getMethod.getParams();
			params.setContentCharset("UTF-8");
			httpclient.executeMethod(getMethod);
			String str = getMethod.getResponseBodyAsString();
	        JSONObject jasonObject = JSONObject.parseObject(str);
	        int errcode = (int) jasonObject.get("errcode");
	        _LOGGER.info("ticket_errcode:{}", errcode);
	        if(0==errcode){
	        	ticket = (String) jasonObject.get("ticket");
	        	return ticket;
	        }else{
	        	throw new Exception("获取JsapiTicket异常，请联系管理员");
	        }
			
		}
		_LOGGER.info("微信ticket:{}", ticket);
	    return ticket;
	    //config.getJsapiTicket();
	}
	
	private boolean isJsapiTicketExpired() {
	    return System.currentTimeMillis()/1000 > ticketExpiresTime;
	}
	
	public void expireJsapiTicket() {
		ticketExpiresTime = 0;
	}
	
	//获取accesstoken
	public String getAccesstoken() throws Exception {
	    return getAccesstoken(false);
	}

	public String getAccesstoken(boolean forceRefresh) throws Exception {
	    //用来决定是否刷新
		if (forceRefresh) {
			expireAccesstoken();
	    }
		//获取
		if (isAccesstokenExpired()) {
			long dateNow = System.currentTimeMillis()/1000;
			accesstokenExpiresTime = 0L;
			accesstokenExpiresTime = dateNow + 6000L;
			HttpClient httpclient = new HttpClient();
			GetMethod getMethod = new GetMethod("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+corpid+"&secret="+corpsecret);
			HttpMethodParams params = getMethod.getParams();
			params.setContentCharset("UTF-8");
			httpclient.executeMethod(getMethod);
			String str = getMethod.getResponseBodyAsString();
			JSONObject jasonObject = JSONObject.parseObject(str);
	        try {
	        	int errcode = (int) jasonObject.get("errcode" );
	        	_LOGGER.info("accesstoken_errcode:{}", errcode);
	        	if(40013==errcode){
		        	throw new Exception("获取accesstoken异常，请联系管理员");
		        }
			} catch (Exception e) {
				 accesstoken = (String) jasonObject.get("access_token");
	 	         return accesstoken;
			}
		}
		_LOGGER.info("微信accesstoken:{}", accesstoken);
	    return accesstoken;
	    //config.getJsapiTicket();
	}
	
	private boolean isAccesstokenExpired() {
	    return System.currentTimeMillis()/1000 > accesstokenExpiresTime;
	}
	
	public void expireAccesstoken() {
		accesstokenExpiresTime = 0;
	}
	
	
}

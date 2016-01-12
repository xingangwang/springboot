package com.atme8.activity.common.util;

import javax.servlet.http.HttpServletRequest;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atme8.activity.web.util.RequestHolder;
import org.springframework.util.Assert;

public class WxSignUtil {

    private static Logger _LOGGER = LoggerFactory.getLogger(WxSignUtil.class);

    private static WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;

    private static WxMpService wxMpService;

    static {
        init();
    }

    public static synchronized void init() {
        if (wxMpInMemoryConfigStorage == null) {
            wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
            wxMpInMemoryConfigStorage.setAppId("wx462779a964aa9f50"); // 设置微信公众号的appid
            wxMpInMemoryConfigStorage.setSecret("79e846ffcde017f10c169d7e4c0d3039"); // 设置微信公众号的app corpSecret
            wxMpService = new WxMpServiceImpl();
            wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        }
    }

    public static WxJsapiSignature sign() {
        //拼接签名
        String url = "";
        //判断参数传递，否则连续分享无效
        HttpServletRequest request = RequestHolder.getRequest();
        if (StringUtils.isBlank(request.getQueryString())) {
            url = "http://" + request.getServerName() + request.getRequestURI();
        } else {
            url = "http://" + request.getServerName() + request.getRequestURI() + "?" + request.getQueryString();
        }
        WxJsapiSignature signature = null;
        try {
            signature = wxMpService.createJsapiSignature(url);
        } catch (WxErrorException e) {
            _LOGGER.error("获取微信JSAPI签名时发生异常。", e);
        }
        return signature;
    }
}

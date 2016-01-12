package com.atme8.activity.core.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/1/5.
 */
public final class CommonUtils {
    private static final Logger _LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    public static boolean isAjaxRequest(HttpServletRequest request) {
        Assert.notNull(request, "request cann't be null");
        String XRequestedWith = request.getHeader("X-Requested-With");
        return StringUtils.isNotEmpty(XRequestedWith) && "XMLHttpRequest".equals(XRequestedWith);
    }

}

package com.atme8.activity.config;

import com.atme8.activity.core.util.CommonUtils;
import org.jasig.cas.client.authentication.AuthenticationRedirectStrategy;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/1/5.
 */
public class AjaxAuthenticationRedirectStrategy implements AuthenticationRedirectStrategy {
    @Override
    public void redirect(HttpServletRequest request, HttpServletResponse response, String potentialRedirectUrl) throws IOException {
        if (CommonUtils.isAjaxRequest(request)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        } else {
            response.sendRedirect(potentialRedirectUrl);
        }
    }
}

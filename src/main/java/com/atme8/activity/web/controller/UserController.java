/**
 * @Title: UserController.java
 * @Package com.atme8.activity.web.controller
 * @Description: Copyright: Copyright (c) 2015
 * Company: 真知行信息技术（大连）有限公司
 * @author JeremyWang
 * @date 2015年9月3日 下午11:36:50
 * @version V1.0
 */

package com.atme8.activity.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.atme8.activity.common.util.WxSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atme8.activity.common.util.DateFormatUtils;
import com.atme8.activity.common.util.StringUtil;
import com.atme8.activity.common.util.SystemSettingUtils;
import com.atme8.activity.domain.entity.User;
import com.atme8.activity.service.UserService;
import com.atme8.activity.service.client.CasClient;
import com.atme8.activity.web.util.SessionUtil;
import com.atme8.activity.web.vo.ObjectResult;
import com.atme8.apiSDK.CaptchaSender;
import com.atme8.apiSDK.token.TokenGenerator;
import com.atme8.apiSDK.util.SDKInit;


/**
 * @ClassName: UserController
 * @Description:
 * @author JeremyWang
 * @date 2015年9月3日 下午11:36:50
 *
 */
@Controller
public class UserController extends AbstractController {

    @SuppressWarnings("unused")
    private static final Logger _LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CasClient client;

    @Autowired
    private UserService userService;

    /**
     * checkCaptcha(校验验证码)
     *
     * @Title: checkCaptcha
     * @Description:
     * @param captcha
     * @param session
     * @return Object
     * @throws
     * @author JeremyWang
     * @date 2015年9月29日 上午10:15:03
     *
     */
    @RequestMapping("/checkCaptcha")
    @ResponseBody
    public Object checkCaptcha(String captcha, String phone, HttpSession session) {
        ObjectResult result = new ObjectResult();
        String captcha_saved = (String) session.getAttribute("captcha");
        String phone_saved = (String) session.getAttribute("phone");

        if(captcha != null && phone != null && captcha.equals(captcha_saved) && phone.equals(phone_saved)){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public ObjectResult register(User user, String password) {
        ObjectResult result = new ObjectResult();
        SystemSettingUtils sysSettingUtil = SystemSettingUtils.getInstance();
        if (!SDKInit.isInited()) {
            SDKInit.init(sysSettingUtil.getCasPartnerId(), sysSettingUtil.getCasSecretKey(), sysSettingUtil.getCasServerUrl());
        }
        String access_token = TokenGenerator.userGen(null, null);
        try {
            String casOpenId = client.regIntoCas(sysSettingUtil.getCasChanelId(), user.getPhone(), user.getRealname(), password, access_token);
            user.setNickname(user.getRealname());
            user.setCasOpenId(casOpenId);
            user.setIsValid(true);
            user.setCreateDate(DateFormatUtils.getSystemDate());
            userService.insert(user);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * login(登录)
     *
     * @Title: login
     * @Description:
     * @return Object
     * @throws
     * @author JeremyWang
     * @date 2015年9月29日 上午10:16:49
     *
     */
    @RequestMapping("/getLoginUser")
    @ResponseBody
    public Object login() {
        _LOGGER.info(SessionUtil.getUser().toString());
        return SessionUtil.getUser();
    }

    @RequestMapping("/register")
    public String regIndex() {
        return "/user/register";
    }

    @RequestMapping("/login")
    public String logIndex(@ModelAttribute("service") String redirectUrlAfterLogin) {
        return "/user/login";
    }

    @RequestMapping("/captcha")
    @ResponseBody
    public String captchaSend(String tel, ModelMap model, HttpSession session) {
        //打入时间戳，保证发送不会特别频繁
        if (session.getAttribute("captchatime") == null) {
            session.setAttribute("captchatime", System.currentTimeMillis());
        } else {
            Long last = (Long) session.getAttribute("captchatime");
            Long now = System.currentTimeMillis();
            if (now - last > 60 * 1000) {
                session.removeAttribute("captchatime");
            } else {
                return "请不要频繁发送";
            }
        }
        if (tel == null || "".equals(tel)) {
            return "电话不能为空";
        }
        String captcha = StringUtil.randomNumberString(4);
        session.setAttribute("captcha", captcha);
        session.setAttribute("phone", tel);
        if (!SDKInit.isInited()) {
            SDKInit.init(SystemSettingUtils.getInstance().getCasPartnerId(),
                    SystemSettingUtils.getInstance().getCasSecretKey(),
                    SystemSettingUtils.getInstance().getCasServerUrl());
        }
        try {
            CaptchaSender.send(tel, captcha);
        } catch (Exception e) {
            e.printStackTrace();
            return "短信发送异常，请重试";
        }
        return "success";
    }
}

package com.atme8.activity.domain.entity.extension;

import com.alibaba.fastjson.JSON;
import com.atme8.activity.domain.entity.User;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by Administrator on 2015/12/23.
 */
public class UserExt extends User{

    public static final String[] CAS_AVATAR_KEYS = {"wechat",
            "qq",
            "sina_weibo",
//            "default"
    };

    public UserExt() {
    }

    //display picture
    public String getDp() {
        if(StringUtils.isEmpty(super.getAvatar())) return "";
        Map<String, String> avatar = (Map<String, String>) JSON.parse(super.getAvatar());
        for (String key : CAS_AVATAR_KEYS) {
            if(StringUtils.isEmpty(avatar.get(key)))
                continue;
            return avatar.get(key);
        }
        return "/img/header.png";
    }

}

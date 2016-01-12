/**
 * @Title: DateUtil.java
 * @Package com.atme8.activity.common.util
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月21日 下午2:42:02
 * @version V1.0
 */

package com.atme8.activity.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * @ClassName: DateUtil
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月21日 下午2:42:02
 *
 */

public class DateFormatUtils {
	
	public static final String FULL_DASH_FORMAT = "yyyy-MM-dd hh:mm:ss";
	
	public static Date parseISO_DATETIME_FORMAT(String source) {
		try {
			return new SimpleDateFormat(FULL_DASH_FORMAT).parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getSystemDate() {
		return new Date();
	}
	
	/**
	 * 秒转时分秒
	 * @param second
	 * @return
	 */
	public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0){
            return "00:00:00";
        }else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;  
            }
        }
        timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
    
}



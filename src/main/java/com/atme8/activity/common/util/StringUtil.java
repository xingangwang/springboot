package com.atme8.activity.common.util;

public class StringUtil {
	/**
	 * 生成四位随机数
	 * @param size 位数
	 * @return
	 * 
	 * @author dean
	 */
	public static String randomNumberString(int size) {
		StringBuffer randomNumberString = new StringBuffer();
		randomNumberString.append((int) (Math.random() * 9 + 1));
		for (int i = 1; i < size; i++) {
			randomNumberString.append((int) (Math.random() * 9));
		}
		return randomNumberString.toString();
	}
}

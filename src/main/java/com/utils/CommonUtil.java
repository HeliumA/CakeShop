package com.utils;

import java.util.Random;

public class CommonUtil {
	/**
     * 生成指定长度的随机字符串
     */
	
    public static String getRandomString(Integer num) {
    	
    	//首先定义了一个包含所有可能字符的字符串base
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        
        //使用java.util.Random类生成一个随机数
        Random random = new Random();
        
        //将该随机数映射到base字符串中的一个字符，并将其添加到一个StringBuffer对象中
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

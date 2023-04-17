
package com.utils;

import org.apache.commons.lang3.StringUtils;

import com.entity.EIException;

/**
 * SQL过滤工具类
 * 防止SQL注入攻击
 */

public class SQLFilter {

    /**
     * SQL注入过滤
     * str待验证的字符串
     */
	
    public static String sqlInject(String str){
    	
    	//判断输入字符串是否为空或空格
        if(StringUtils.isBlank(str)){
            return null;
        }
        /**
         * 去掉'|"|;|\字符
         * 使用 Apache Commons Lang 工具类的 StringUtils.replace() 方法
         * 替换字符串中的单引号、双引号、分号和反斜杠为空字符串
         */
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //将字符串转换成小写
        str = str.toLowerCase();

        //SQL关键字 非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        /**
         * 判断输入字符串中是否包含非法字符
         * 使用 for-each 循环遍历关键词数组
         * 如果输入字符串中包含了某个关键词，就抛出 EIException 异常，提示用户输入了非法字符
         */
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new EIException("输入中包含非法字符");
            }
        }

        return str;
    }
}

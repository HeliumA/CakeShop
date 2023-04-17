package com.utils;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * 提供了一个静态方法
 * 输入要加密的字符串
 * 输出MD5加密后的字符串
 * 对字符串进行MD5加密
 * 加密后的结果可以用来验证数据的完整性和真实性
 */
public class MD5Util {
    
	/**
	 * 
	 */

	public static String md5(String text) {

		String md5str = DigestUtil.md5Hex(text);
		return md5str;
	}

}

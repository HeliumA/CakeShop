package com.utils;

/**
 * 
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 继承了HashMap<String, Object>类
 * 表示R是一个具有键值对功能的数据集合
 */
public class R extends HashMap<String, Object> {
	
	/**
	 * 序列化机制版本号
	 */
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
	}
	
	public static R error() {
		return error(500, "未知异常");
	}
	
	public static R error(String msg) {
		return error(500, msg);
	}
	
	/**
	 * 表示发生了异常
	 * 传递了异常代码code和异常信息msg作为键值对
	 */
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	
	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	/**
	 * 包含键值对由参数map传递的所有键值对
	 */
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	/**
	 * 可以添加单个键值对到R对象中
	 * 并返回R对象自身的引用，方便链式操作
	 */
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}

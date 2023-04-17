
package com.entity;

/**
 * 定义了一个自定义异常类 EIException
 * 继承了 RuntimeException 类
 * 可以在程序运行时抛出异常并提供自定义的异常信息和异常代码
 */

public class EIException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;//异常信息
    private int code = 500;//异常代码默认为500
    
    public EIException(String msg) {
    	/**
    	 * 用给定的异常信息构造异常对象
    	 * 并将异常信息存储到 msg 变量中
    	 */
		super(msg);
		this.msg = msg;
	}
	
	public EIException(String msg, Throwable e) {
    	/**
    	 * 用给定的异常信息和原始异常对象构造异常对象
    	 * 并将异常信息存储到 msg 变量中
    	 */
		super(msg, e);
		this.msg = msg;
	}
	
	public EIException(String msg, int code) {
    	/**
    	 * 用给定的异常信息和异常代码构造异常对象
    	 * 并将异常信息存储到 msg 变量中，将异常代码存储到 code 变量中
    	 */
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public EIException(String msg, int code, Throwable e) {
    	/**
    	 * 用给定的异常信息、异常代码和原始异常对象构造异常对象
    	 * 并将异常信息存储到 msg 变量中，将异常代码存储到 code 变量中
    	 */
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
    	/**
    	 * 返回异常信息
    	 */
		return msg;
	}

	public void setMsg(String msg) {
    	/**
    	 * 设置异常信息
    	 */
		this.msg = msg;
	}

	public int getCode() {
    	/**
    	 * 返回异常代码
    	 */
		return code;
	}

	public void setCode(int code) {
    	/**
    	 * 返回异常代码
    	 */
		this.code = code;
	}
	
	
}

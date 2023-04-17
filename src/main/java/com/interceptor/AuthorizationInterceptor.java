package com.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;

import com.annotation.IgnoreAuth;
import com.entity.EIException;
import com.entity.TokenEntity;
import com.service.TokenService;
import com.utils.R;

/**
 * 实现了Spring框架的HandlerInterceptor接口
 * 用于拦截Web请求并进行权限(Token)验证
 */

@Component
/**
 * 使用Spring的依赖注入功能
 * 将该类声明为一个组件
 * 可以在其他Java类中引用该类的实例
 */

public class AuthorizationInterceptor implements HandlerInterceptor {
	/**
	 * 实现了HandlerInterceptor接口
	 * 并覆盖了其中的preHandle方法
	 */
	
    public static final String LOGIN_TOKEN_KEY = "Token";

    @Autowired
    private TokenService tokenService;
    
	@Override
	/**
	 * 在处理Web请求之前被调用，用于进行权限(Token)验证
	 */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/**
		 * HttpServletRequest request：表示当前的HTTP请求
		 * HttpServletResponse response：表示当前的HTTP响应
		 * Object handler：表示当前请求的处理器，通常是一个Controller方法
		 */
		//支持跨域请求
		
		
		/**
		 * response.setHeader()：设置响应头信息，包括允许跨域请求的相关设置
		 */
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,request-source,Token, Origin,imgType, Content-Type, cache-control,postman-token,Cookie, Accept,authorization");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	// 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        
        
		/**
		 * 判断当前请求是否为OPTIONS请求，如果是，则直接返回正常状态
		 */    
	if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
        	response.setStatus(HttpStatus.OK.value());
            return false;
        }
        
	/**
	 * 定义一个IgnoreAuth类型的变量annotation，并将其初始化为null
	 */   
        IgnoreAuth annotation;
        
    	/**
    	 * 判断当前请求的处理器是否是一个HandlerMethod类型的实例
    	 * 如果当前请求的处理器是HandlerMethod类型的实例
    	 * 则获取该处理器方法上的IgnoreAuth注解
    	 */   
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

    	/**
    	 * 从HTTP请求头中获取名为Token的参数值
    	 * 并将其赋值给token变量
    	 */   
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        
        /**
         * 如果处理器方法上存在IgnoreAuth注解
         * 则直接放过请求
         */
        if(annotation!=null) {
        	return true;
        }
        
        
    	/**
    	 * 定义一个TokenEntity类型的变量tokenEntity，并将其初始化为null
    	 */   
        TokenEntity tokenEntity = null;
        
    	/**
    	 * 如果token不为空
    	 * 则调用tokenService的getTokenEntity方法获取对应的TokenEntity对象
    	 */   
        if(StringUtils.isNotBlank(token)) {
        	tokenEntity = tokenService.getTokenEntity(token);
        }
        
    	/**
    	 * 如果成功获取到TokenEntity对象
    	 * 则将该对象的相关信息存储到HTTP会话中，并放过请求
    	 */  
        if(tokenEntity != null) {
        	request.getSession().setAttribute("userId", tokenEntity.getUserid());
        	request.getSession().setAttribute("role", tokenEntity.getRole());
        	request.getSession().setAttribute("tableName", tokenEntity.getTablename());
        	request.getSession().setAttribute("username", tokenEntity.getUsername());
        	return true;
        }
        
    	/**
    	 * 定义一个PrintWriter类型的变量writer，并将其初始化为null
    	 */  
		PrintWriter writer = null;
		
    	/**
    	 * 设置HTTP响应的编码和内容类型
    	 */  
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			
	    	/**
	    	 * 获取响应输出流，并将其赋值给writer变量
	    	 */ 
		    writer = response.getWriter();
		    
	    	/**
	    	 * 将错误信息以JSON格式输出到响应中
	    	 */ 
		    writer.print(JSONObject.toJSONString(R.error(401, "请先登录")));
		
		
		} finally {
	    	/**
	    	 * 释放资源，关闭输出流
	    	 */ 
		    if(writer != null){
		        writer.close();
		    }
		}
    	/**
    	 * 表示请求未被放过，需要终止当前的HTTP请求
    	 */ 
		return false;
    }
}

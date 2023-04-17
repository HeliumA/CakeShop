
package com.utils;
/**
 * 
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * Spring Context 工具类
 * 获取、判断和操作 Spring 容器中 Bean 的方法
 */

@Component
public class SpringContextUtils implements ApplicationContextAware {
	public static ApplicationContext applicationContext; 
	 
	/**
	 * ApplicationContext 对象传入到静态变量applicationContext 中
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
	}

	/**
	 * 获取指定名称的Bean
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * 带参数类型的重载
	 * 用于获取指定名称和类型的Bean
	 */
	public static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	/**
	 * 判断指定名称的Bean是否存在spring容器中
	 */
	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	/**
	 * 判断指定的Bean是否为单例模式
	 */
	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}

	/**
	 * 获取指定名称的Bean的类型
	 */
	public static Class<? extends Object> getType(String name) {
		return applicationContext.getType(name);
	}

}
package com.service;

import java.util.List;
import java.util.Map;

/**
 * 扩展了MyBatis-Plus的IService接口
 */
public interface CommonService {
	
	/**
	 * 接受一个 Map 类型的参数
	 * 返回一个 String 类型的列表(List)
	 * 该方法的作用是获取选项
	 */
	List<String> getOption(Map<String, Object> params);
	
	/**
	 * 接受一个 Map 类型的参数
	 * 返回一个 Map 类型的对象
	 * 该方法的作用是根据选项获取关注项
	 */
	Map<String, Object> getFollowByOption(Map<String, Object> params);
	
	/**
	 * 接受一个 Map 类型的参数
	 * 返回 void。该方法的作用是保存数据
	 */
	void sh(Map<String, Object> params);
	
	/**
	 * 接受一个 Map 类型的参数
	 * 返回一个整数(int)
	 * 该方法的作用是获取提醒数量
	 */
	int remindCount(Map<String, Object> params);
	
	/**
	 * 接受一个 Map 类型的参数
	 * 返回一个 Map 类型的对象
	 * 该方法的作用是选择日历
	 */
	Map<String, Object> selectCal(Map<String, Object> params);
	
	/**
	 * 接受一个 Map 类型的参数，
	 * 返回一个 Map 类型的列表(List)
	 * 该方法的作用是选择分组
	 */
	List<Map<String, Object>> selectGroup(Map<String, Object> params);
	
	/**
	 * 接受一个 Map 类型的参数
	 * 返回一个 Map 类型的列表(List)
	 * 该方法的作用是选择值
	 */
	List<Map<String, Object>> selectValue(Map<String, Object> params);
}

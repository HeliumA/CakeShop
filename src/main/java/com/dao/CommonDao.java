
package com.dao;

import java.util.List;
import java.util.Map;

/**
 * 通用接口
 * 定义了用于从数据库中访问数据的多个方法
 * 该接口没有实现，但提供了必须由实现该接口的任何类实现的方法签名
 */


public interface CommonDao{
	
	//	//接受一个包含参数的 Map 对象，并返回一个字符串列表
	List<String> getOption(Map<String, Object> params);

	//接受一个包含参数的 Map 对象，并返回一个 Map 对象
	Map<String, Object> getFollowByOption(Map<String, Object> params);
	
	//接受一个包含参数的 Map 对象，并返回一个字符串列表
	List<String> getFollowByOption2(Map<String, Object> params);
	
	//接受一个包含参数的 Map 对象，并返回 void
	void sh(Map<String, Object> params);
	
	//接受一个包含参数的 Map 对象，并返回一个整数
	int remindCount(Map<String, Object> params);
	
	//接受一个包含参数的 Map 对象，并返回一个 Map 对象
	Map<String, Object> selectCal(Map<String, Object> params);
	
	//接受一个包含参数的 Map 对象，并返回一个 Map 对象列表
	List<Map<String, Object>> selectGroup(Map<String, Object> params);
	
	//接受一个包含参数的 Map 对象，并返回一个 Map 对象列表
	List<Map<String, Object>> selectValue(Map<String, Object> params);
}


package com.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommonDao;
import com.service.CommonService;


/**
 * 提供一些公共服务
 * 获取选项、根据选项查询跟进信息、审核
 * 用于封装数据库操作，并暴露一些常用的查询和统计方法供其他类调用
 * 提醒数量统计、选择日历、选择分组、选择值
 */

@Service("commonService")

/**
 * 系统客户
 */

/**
 * 系统客户
 */
public class CommonServiceImpl implements CommonService {
	
	/**
	 * 数据访问对象，用于与数据库进行交互
	 * 使用@Autowired注解注入
	 * 表示该实例由Spring容器创建并注入到该类中
	 */
	@Autowired
	private CommonDao commonDao;

	/**
	 * 获取选项的实现
	 * 接受一个Map<String, Object>类型的参数params
	 */
	@Override
	public List<String> getOption(Map<String, Object> params) {
		return commonDao.getOption(params);
	}
	
	/**
	 * 根据选项查询跟进信息的实现
	 * 接受一个Map<String, Object>类型的参数params
	 */
	@Override
	public Map<String, Object> getFollowByOption(Map<String, Object> params) {
		return commonDao.getFollowByOption(params);
	}
	
	@Override
	public void sh(Map<String, Object> params) {
		commonDao.sh(params); 
	}

	@Override
	public int remindCount(Map<String, Object> params) {
		return commonDao.remindCount(params);
	}

	@Override
	public Map<String, Object> selectCal(Map<String, Object> params) {
		return commonDao.selectCal(params);
	}
	
	@Override
	public List<Map<String, Object>> selectGroup(Map<String, Object> params) {
		return commonDao.selectGroup(params);
	}
	
	@Override
	public List<Map<String, Object>> selectValue(Map<String, Object> params) {
		return commonDao.selectValue(params);
	}

}

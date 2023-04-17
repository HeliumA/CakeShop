
package com.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ConfigEntity;
import com.utils.PageUtils;


/**
 * 定义了一个接口 "ConfigService"
 * 该接口继承自 "IService" 接口
 * 同时指定了泛型参数为 "ConfigEntity" 类型
 * 表示 "ConfigService" 接口提供了对 "ConfigEntity" 类型对象的服务
 */

/**
 * 定义了一个接口 "ConfigService"
 */
public interface ConfigService extends IService<ConfigEntity> {
	/**
	 * 接收一个 "Map<String, Object> params" 参数
	 * 返回一个 "PageUtils" 对象
	 */
	PageUtils queryPage(Map<String, Object> params);
}

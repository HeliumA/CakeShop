
package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.ConfigEntity;

/**
 * 配置
 */
public interface ConfigDao extends BaseMapper<ConfigEntity> {
	//是一个使用MyBatis-Plus框架提供的基本数据访问方法的Mapper接口
	//未定义任何方法，因为它继承了 BaseMapper 接口，该接口提供了一些基本的CRUD（创建、读取、更新和删除）操作，这些操作可以直接使用
	//可以用于访问和操作与 ConfigEntity 相关的数据库表
}

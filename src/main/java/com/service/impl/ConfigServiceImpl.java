
package com.service.impl;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ConfigDao;
import com.entity.ConfigEntity;
import com.entity.UserEntity;
import com.service.ConfigService;
import com.utils.PageUtils;
import com.utils.Query;

/**
 * 继承了MyBatis-Plus框架提供的ServiceImpl类
 * 并实现了ConfigService接口
 * 其中ConfigService接口是一个定义了一些数据访问的方法的接口
 */

/**
 * 系统客户
 */


/**
 * Spring Bean
 * Spring会在启动时自动创建该类的一个实例并将其加入Spring容器中进行管理
 */
@Service("configService")

/**
 * ConfigDao是一个数据访问对象接口，它定义了一些数据访问的方法
 * 而ConfigEntity是一个实体类，用于与数据库表进行映射
 */
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {

	/**
	 *查询数据并返回分页结果
	 *该方法接收一个Map类型的参数params，这个参数中存储了查询条件和分页信息
	 *首先通过new Query<ConfigEntity>(params).getPage()方法创建了一个Page对象
	 *用于存储分页信息，Query是一个自定义的查询工具类
	 *然后，调用了selectPage方法从数据访问对象ConfigDao中查询数据
	 *并使用EntityWrapper<ConfigEntity>对象封装查询条件
	 *最后，将查询结果封装为PageUtils对象，并返回
	 */
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
	
		Page<ConfigEntity> page = this.selectPage(
                new Query<ConfigEntity>(params).getPage(),
                new EntityWrapper<ConfigEntity>()
        );
        return new PageUtils(page);
        
		/**
		 * PageUtils是一个自定义的分页工具类
		 * 它用于将MyBatis-Plus中的Page对象转换为自定义的分页对象
		 * 并封装分页信息和查询结果
		 * Query是一个自定义的查询工具类
		 * 它用于从Map类型的参数params中获取查询条件和分页信息
		 * 并生成一个Page对象
		 */
	}
}

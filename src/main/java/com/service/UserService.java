
package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.UserEntity;
import com.utils.PageUtils;


/**
 * 系统客户
 * 继承了IService<UserEntity>接口
 * 说明UserService是UserEntity实体的服务接口
 */

public interface UserService extends IService<UserEntity> {
	
	/**
	 * 接受一个类型为Map<String, Object>的参数params
	 * 并返回类型为PageUtils的对象
	 * 作用是根据传入的参数params查询数据并分页展示
	 */
 	PageUtils queryPage(Map<String, Object> params);
    
 	/**
 	 * 接受一个类型为Wrapper<UserEntity>的参数wrapper
 	 * 并返回类型为List<UserEntity>的对象
 	 * 根据传入的条件wrapper查询数据并返回符合条件的实体列表
 	 */
   	List<UserEntity> selectListView(Wrapper<UserEntity> wrapper);
   	
   	/**
   	 * 接受两个参数，一个是类型为Map<String, Object>的参数params
   	 * 另一个是类型为Wrapper<UserEntity>的参数wrapper
   	 * 并返回类型为PageUtils的对象
   	 * 根据传入的参数params和条件wrapper查询数据并分页展示
   	 * 结合了前两个方法的功能，同时支持参数查询和条件查询
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<UserEntity> wrapper);
	   	
}

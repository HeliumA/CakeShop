
package com.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.TokenEntity;
import com.utils.PageUtils;


/**
 * token
 * 继承了IService接口
 * 并实现了IService接口中的泛型类TokenEntity
 */

public interface TokenService extends IService<TokenEntity> {
	
	/**
	 * 查询分页数据
	 * 传入一个Map对象params
	 * 返回一个PageUtils对象
	 */
 	PageUtils queryPage(Map<String, Object> params);
    
 	/**
 	 * 查询TokenEntity列表数据
 	 * 传入一个Wrapper对象wrapper
 	 * 返回一个List<TokenEntity>对象
 	 */
   	List<TokenEntity> selectListView(Wrapper<TokenEntity> wrapper);
   	
   	/**
   	 * 查询分页数据
   	 * 传入一个Map对象params和一个Wrapper对象wrapper
   	 * 返回一个PageUtils对象
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TokenEntity> wrapper);
	
   	/**
   	 * 生成token字符串
   	 * 传入userid、username、tableName和role四个参数
   	 * 返回一个String类型的token
   	 */
   	String generateToken(Long userid,String username,String tableName, String role);
   	
   	/**
   	 * 根据token字符串获取TokenEntity对象
   	 * 传入一个String类型的token
   	 * 返回一个TokenEntity对象
   	 */
   	TokenEntity getTokenEntity(String token);
}

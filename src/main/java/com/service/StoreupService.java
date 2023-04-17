package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.StoreupEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.StoreupVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.StoreupView;


/**
 * 收藏表
 * 继承了IService接口，并指定泛型类型为StoreupEntity
 */

public interface StoreupService extends IService<StoreupEntity> {

	/**
	 * 接收一个Map类型的参数params
	 * 返回一个PageUtils对象
	 * 查询收藏表并返回分页数据
	 */
    PageUtils queryPage(Map<String, Object> params);
    
	/**
	 * 接收一个Wrapper类型的参数wrapper
	 * 返回一个StoreupVO类型的List
	 * 根据条件查询收藏表并返回符合条件的StoreupVO对象列表
	 */
   	List<StoreupVO> selectListVO(Wrapper<StoreupEntity> wrapper);
   	
	/**
	 * 接收一个Wrapper类型的参数wrapper
	 * 返回一个StoreupVO类型的对象
	 * 根据条件查询收藏表并返回符合条件的StoreupVO对象
	 */
   	StoreupVO selectVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
   	
	/**
	 * 这个方法接收一个Wrapper类型的参数wrapper
	 * 返回一个StoreupView类型的List
	 * 根据条件查询收藏表并返回符合条件的StoreupView对象列表
	 */
   	List<StoreupView> selectListView(Wrapper<StoreupEntity> wrapper);
   	
	/**
	 * 接收一个Wrapper类型的参数wrapper
	 * 返回一个StoreupView类型的对象
	 * 根据条件查询收藏表并返回符合条件的StoreupView对象
	 */
   	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);
   	
	/**
	 * 接收两个参数
	 * 一个是Map类型的参数params，另一个是Wrapper类型的参数wrapper
	 * 返回一个PageUtils对象
	 * 根据条件查询收藏表并返回符合条件的分页数据
	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<StoreupEntity> wrapper);
   	
}


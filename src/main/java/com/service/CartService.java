package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CartEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CartVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CartView;


/**
 * 扩展了MyBatis-Plus的IService接口
 * 并提供了多种查询购物车信息的方法
 */


public interface CartService extends IService<CartEntity> {

	/**
	 * 分页查询购物车数据
	 * 接受一个Map类型的参数params
	 * 返回一个PageUtils对象，用于分页显示查询结果
	 */
    PageUtils queryPage(Map<String, Object> params);
    
	/**
	 * 查询购物车信息列表
	 * 接受一个Wrapper<CartEntity>类型的参数wrapper
	 * 返回一个List<CartVO>类型的地址信息列表
	 */
   	List<CartVO> selectListVO(Wrapper<CartEntity> wrapper);
   	
	/**
	 * 查询单个购物车信息
	 * 接受一个Wrapper<CartEntity>类型的参数wrapper
	 * 返回一个CartVO类型的地址信息
	 */
   	CartVO selectVO(@Param("ew") Wrapper<CartEntity> wrapper);
   	
	/**
	 * 查询购物车信息视图列表
	 * 接受一个Wrapper<CartEntity>类型的参数wrapper
	 * 返回一个List<CartView>类型的地址信息视图列表
	 */
   	List<CartView> selectListView(Wrapper<CartEntity> wrapper);
   	
	/**
	 * 查询单个购物车信息视图
	 * 接受一个Wrapper<CartEntity>类型的参数wrapper
	 * 返回一个CartView类型的地址信息视图
	 */
   	CartView selectView(@Param("ew") Wrapper<CartEntity> wrapper);
   	
	/**
	 * 查询分页数据
	 * 接受两个参数，一个是Map类型的参数params
	 * 一个是Wrapper<CartEntity>类型的参数wrapper
	 * 返回一个PageUtils对象，用于分页显示查询结果
	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CartEntity> wrapper);
   	
}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AddressEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AddressVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AddressView;


/**
 * 扩展了MyBatis-Plus的IService接口
 * 并提供了多种查询地址信息的方法
 */

public interface AddressService extends IService<AddressEntity> {

	/**
	 * 查询分页数据
	 * 接受一个Map类型的参数params
	 * 返回一个PageUtils对象，用于分页显示查询结果
	 */
    PageUtils queryPage(Map<String, Object> params);
    
	/**
	 * 查询地址信息列表
	 * 接受一个Wrapper<AddressEntity>类型的参数wrapper
	 * 返回一个List<AddressVO>类型的地址信息列表
	 */
   	List<AddressVO> selectListVO(Wrapper<AddressEntity> wrapper);
   	
	/**
	 * 查询单个地址信息
	 * 接受一个Wrapper<AddressEntity>类型的参数wrapper
	 * 返回一个AddressVO类型的地址信息
	 */
   	AddressVO selectVO(@Param("ew") Wrapper<AddressEntity> wrapper);
   	
	/**
	 * 查询地址信息视图列表
	 * 接受一个Wrapper<AddressEntity>类型的参数wrapper
	 * 返回一个List<AddressView>类型的地址信息视图列表
	 */
   	List<AddressView> selectListView(Wrapper<AddressEntity> wrapper);
   	
	/**
	 * 查询单个地址信息视图
	 * 接受一个Wrapper<AddressEntity>类型的参数wrapper
	 * 返回一个AddressView类型的地址信息视图
	 */
   	AddressView selectView(@Param("ew") Wrapper<AddressEntity> wrapper);
   	
	/**
	 * 查询分页数据
	 * 接受两个参数，一个是Map类型的参数params
	 * 一个是Wrapper<AddressEntity>类型的参数wrapper
	 * 返回一个PageUtils对象，用于分页显示查询结果
	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AddressEntity> wrapper);
   	
}


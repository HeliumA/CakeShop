package com.dao;

import com.entity.CartEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CartVO;
import com.entity.view.CartView;


/**
 * 购物车表
 */

public interface CartDao extends BaseMapper<CartEntity> {
	//继承了 BaseMapper<CartEntity> 接口，该接口提供了对 CartEntity 类型的基本数据库操作（如增删改查）
	//BaseMapper 接口提供了一些基本的 CRUD 操作，而 CartDao 接口则在此基础上扩展了一些查询方法

	
	//接受一个 Wrapper<CartEntity> 对象作为参数，用于构建查询条件
	List<CartVO> selectListVO(@Param("ew") Wrapper<CartEntity> wrapper);
	
	CartVO selectVO(@Param("ew") Wrapper<CartEntity> wrapper);
	
	List<CartView> selectListView(@Param("ew") Wrapper<CartEntity> wrapper);
	//使用了 MyBatis-Plus 提供的分页功能，它接受一个 Pagination 对象和一个 Wrapper<CartEntity> 对象作为参数
	//可以将查询结果按照分页要求进行返回
	List<CartView> selectListView(Pagination page,@Param("ew") Wrapper<CartEntity> wrapper);
	
	CartView selectView(@Param("ew") Wrapper<CartEntity> wrapper);
	
}

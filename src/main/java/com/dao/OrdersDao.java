package com.dao;

import com.entity.OrdersEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.OrdersVO;
import com.entity.view.OrdersView;


/**
 * 订单
 * 定义了对名为OrdersEntity的实体类对应的表进行CRUD操作的方法
 * 继承BaseMapper接口
 */
public interface OrdersDao extends BaseMapper<OrdersEntity> {
	
	//根据查询条件Wrapper<OrdersEntity>查询订单列表，返回List<OrdersVO>类型结果集
	List<OrdersVO> selectListVO(@Param("ew") Wrapper<OrdersEntity> wrapper);
	
	//根据查询条件Wrapper<OrdersEntity>查询一条订单记录，返回OrdersVO类型结果
	OrdersVO selectVO(@Param("ew") Wrapper<OrdersEntity> wrapper);
	
	//根据查询条件Wrapper<OrdersEntity>查询订单记录视图列表，返回List<OrdersView>类型结果集
	List<OrdersView> selectListView(@Param("ew") Wrapper<OrdersEntity> wrapper);

	//分页查询订单记录视图列表，返回List<OrdersView>类型结果集
	List<OrdersView> selectListView(Pagination page,@Param("ew") Wrapper<OrdersEntity> wrapper);
	
	//根据查询条件Wrapper<OrdersEntity>查询一条订单记录视图，返回OrdersView类型结果
	OrdersView selectView(@Param("ew") Wrapper<OrdersEntity> wrapper);
	
}

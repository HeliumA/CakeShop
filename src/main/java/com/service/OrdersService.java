package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.OrdersEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.OrdersVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.OrdersView;


/**
 * 订单
 */

public interface OrdersService extends IService<OrdersEntity> {

	/**
	 * 用于分页查询数据库中的数据
	 * 其中params参数是查询条件
	 * 包含了需要查询的数据条数、查询的页数、查询的排序方式
	 */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 用于查询符合条件的数据
     * 返回一个OrdersVO类型的数据列表
     */
   	List<OrdersVO> selectListVO(Wrapper<OrdersEntity> wrapper);
   	
   	/**
   	 * 用于查询符合条件的单个数据
   	 * 并返回OrdersVO类型的数据
   	 */
   	OrdersVO selectVO(@Param("ew") Wrapper<OrdersEntity> wrapper);
   	
   	/**
   	 * 用于查询符合条件的数据
   	 * 返回一个OrdersView类型的数据列表
   	 */
   	List<OrdersView> selectListView(Wrapper<OrdersEntity> wrapper);
   	
   	/**
   	 * 用于查询符合条件的单个数据
   	 * 并返回OrdersView类型的数据
   	 */
   	OrdersView selectView(@Param("ew") Wrapper<OrdersEntity> wrapper);
   	
   	/**
   	 * 包含了条件构造器wrapper
   	 * 用于在查询条件中加入更多的条件
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<OrdersEntity> wrapper);
   	
}


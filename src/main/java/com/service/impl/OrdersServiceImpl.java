package com.service.impl;
/**
 * 
 */
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.OrdersDao;
import com.entity.OrdersEntity;
import com.service.OrdersService;
import com.entity.vo.OrdersVO;
import com.entity.view.OrdersView;

/**
 * 继承了ServiceImpl<OrdersDao, OrdersEntity>类
 * 泛型中的OrdersDao表示数据访问层接口，OrdersEntity表示实体类
 */
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {
	
	/**
	 * 通过调用MyBatis-Plus提供的selectPage方法来实现分页查询
	 * 第一个参数是查询条件
	 * 第二个参数是查询的封装条件（即Wrapper<OrdersEntity>）
	 * 返回值是封装了查询结果的PageUtils对象
	 */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrdersEntity> page = this.selectPage(
                new Query<OrdersEntity>(params).getPage(),
                new EntityWrapper<OrdersEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper) {
		  Page<OrdersView> page =new Query<OrdersView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    
    /**
     * 分别用于查询所有符合条件的实体类
     * 以及查询符合条件的单个实体类
     * 返回值都是实体类的包装类OrdersVO
     */
    @Override
	public List<OrdersVO> selectListVO(Wrapper<OrdersEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public OrdersVO selectVO(Wrapper<OrdersEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	/**
	 * 分别用于查询所有符合条件的视图类、
	 * 以及查询符合条件的单个视图类
	 * 返回值都是视图类的包装类OrdersView
	 */
	@Override
	public List<OrdersView> selectListView(Wrapper<OrdersEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public OrdersView selectView(Wrapper<OrdersEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

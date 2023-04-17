package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CartDao;
import com.entity.CartEntity;
import com.service.CartService;
import com.entity.vo.CartVO;
import com.entity.view.CartView;

/**
 * 实现了一个名为CartService的接口
 * 其中定义了各种与CartEntity实体类相关的方法
 * 包括查询、新增、更新、删除等方法
 * 这些方法是通过ServiceImpl类提供的基本实现完成的
 * @Service注解，用于将该类注册为一个Spring的服务组件
 * 通过MyBatis Plus框架提供的基本方法实现对CartEntity实体类的查询操作
 * 并且定义了一些查询方法以方便进行VO和View的查询和返回。
 */

@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {
	
	/**
	 * 用于根据传入的参数params进行分页查询
	 * 具体实现方式是通过MyBatis Plus框架提供的selectPage方法
	 * 传入一个Query对象，然后使用EntityWrapper作为条件构造器进行查询
	 * 并返回一个PageUtils对象，封装了查询结果和分页信息
	 */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CartEntity> page = this.selectPage(
                new Query<CartEntity>(params).getPage(),
                new EntityWrapper<CartEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CartEntity> wrapper) {
		  Page<CartView> page =new Query<CartView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    
	/**
	 * 定义了一些查询方法以方便进行VO和View的查询和返回
	 */
	
    @Override
	public List<CartVO> selectListVO(Wrapper<CartEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CartVO selectVO(Wrapper<CartEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CartView> selectListView(Wrapper<CartEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CartView selectView(Wrapper<CartEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

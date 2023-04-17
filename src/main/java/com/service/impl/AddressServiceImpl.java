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


import com.dao.AddressDao;
import com.entity.AddressEntity;
import com.service.AddressService;
import com.entity.vo.AddressVO;
import com.entity.view.AddressView;

/**
 * 实现了一个接口AddressService
 * 该类使用了Spring框架中的@Service注解，表示它是一个服务类
 * 并且Spring框架会自动扫描这个注解，将其实例化并交给Spring容器进行管理
 * 在类定义中，指定了该服务类使用的数据访问对象（DAO）类型AddressDao和实体类型AddressEntity
 */

@Service("addressService")

public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {
	
	
    @Override
    
    /**
     * 使用了MyBatis-Plus框架提供的selectPage方法
     * 用于从数据库中分页查询符合条件的AddressEntity对象
     * 这个方法接收一个Map<String, Object>类型的参数params
     * 这个参数包含了查询条件，例如页码、每页数量、排序等
     * 查询条件的封装是通过传入Query对象完成的
     * 该对象是一个工具类，它可以将Map类型的参数转换为一个MyBatis-Plus框架中的Page对象
     * Page对象用于表示分页查询的基本信息。
     */
    
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AddressEntity> page = this.selectPage(
                new Query<AddressEntity>(params).getPage(),
                new EntityWrapper<AddressEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
    
    /**
     * queryPage的重载方法
     * 该方法也使用了MyBatis-Plus框架中的selectPage方法
     * 不同之处在于它接受了一个MyBatis-Plus框架中的Wrapper对象
     * 该对象用于构建查询条件
     * 这个方法通过调用数据访问对象的selectListView方法
     * 从数据库中查询符合条件的AddressView对象
     * 返回一个分页对象PageUtils
     */

	public PageUtils queryPage(Map<String, Object> params, Wrapper<AddressEntity> wrapper) {
		  Page<AddressView> page =new Query<AddressView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    
    
    
    
    /**
     * selectListVO和selectVO通过调用数据访问对象的selectListVO和selectVO方法
     * 从数据库中查询符合条件的AddressVO对象
     * 分别返回一个AddressVO对象列表和单个AddressVO对象     
     */
    @Override
	public List<AddressVO> selectListVO(Wrapper<AddressEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AddressVO selectVO(Wrapper<AddressEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	
    /**
     * selectListView和selectView通过调用数据访问对象的selectListView和selectView方法
     * 从数据库中查询符合条件的AddressView对象
     * 分别返回一个AddressView对象列表和单个AddressView对象    
     */
	@Override
	public List<AddressView> selectListView(Wrapper<AddressEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AddressView selectView(Wrapper<AddressEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

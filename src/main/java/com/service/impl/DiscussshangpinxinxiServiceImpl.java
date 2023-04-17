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


import com.dao.DiscussshangpinxinxiDao;
import com.entity.DiscussshangpinxinxiEntity;
import com.service.DiscussshangpinxinxiService;
import com.entity.vo.DiscussshangpinxinxiVO;
import com.entity.view.DiscussshangpinxinxiView;

/**
 * 服务层的组件，可以被其他组件依赖注入
 * 继承了MyBatis-Plus框架提供的ServiceImpl类
 * ServiceImpl类是一个抽象类
 * 提供了一些常用的增删改查方法的实现
 */
@Service("discussshangpinxinxiService")

/**
 * 重写了ServiceImpl类中的queryPage方法
 * 并添加了一个重载版本
 * 这些方法都是用于查询数据库中的数据
 * 并返回PageUtils或包含DiscussshangpinxinxiVO或DiscussshangpinxinxiView实体的列表或单个实体
 */
public class DiscussshangpinxinxiServiceImpl extends ServiceImpl<DiscussshangpinxinxiDao, DiscussshangpinxinxiEntity> implements DiscussshangpinxinxiService {
	
	/**
	 * 
	 */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshangpinxinxiEntity> page = this.selectPage(
                new Query<DiscussshangpinxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussshangpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
	/**
	 * 使用了一个自定义的视图类DiscussshangpinxinxiView
	 * 并调用了baseMapper的selectListView方法
	 * selectListView方法是一个自定义的MyBatis映射器方法
	 * 用于查询数据库中的数据，并将查询结果封装成一个包含DiscussshangpinxinxiView实体的列表返回
	 */
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshangpinxinxiEntity> wrapper) {
		  Page<DiscussshangpinxinxiView> page =new Query<DiscussshangpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    
	/**
	 * 重写了selectListVO、selectVO、selectListView和selectView方法
	 * 用于查询指定条件下的数据
	 * 并返回一个包含DiscussshangpinxinxiVO或DiscussshangpinxinxiView实体的列表或单个实体
	 * 也使用了Wrapper对象，用于指定查询条件
	 * 调用了baseMapper的自定义映射器方法，用于查询数据库中的数据并返回结果
	 */
    @Override
	public List<DiscussshangpinxinxiVO> selectListVO(Wrapper<DiscussshangpinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshangpinxinxiVO selectVO(Wrapper<DiscussshangpinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshangpinxinxiView> selectListView(Wrapper<DiscussshangpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshangpinxinxiView selectView(Wrapper<DiscussshangpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

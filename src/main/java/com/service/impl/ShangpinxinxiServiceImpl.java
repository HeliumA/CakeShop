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


import com.dao.ShangpinxinxiDao;
import com.entity.ShangpinxinxiEntity;
import com.service.ShangpinxinxiService;
import com.entity.vo.ShangpinxinxiVO;
import com.entity.view.ShangpinxinxiView;

/**
 * 
 */
@Service("shangpinxinxiService")
public class ShangpinxinxiServiceImpl extends ServiceImpl<ShangpinxinxiDao, ShangpinxinxiEntity> implements ShangpinxinxiService {
	
	/**
	 * 查询商品信息列表，使用分页查询，传入参数params包含分页信息
	 */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpinxinxiEntity> page = this.selectPage(
                new Query<ShangpinxinxiEntity>(params).getPage(),
                new EntityWrapper<ShangpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
	/**
	 * 查询商品信息列表
	 * 使用分页查询和Mybatis-Plus的 Wrapper条件查询构造器
	 * 传入参数params包含分页信息，wrapper为条件查询构造器
	 */
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinxinxiEntity> wrapper) {
		  Page<ShangpinxinxiView> page =new Query<ShangpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    /**
     * 查询商品信息列表，返回 ShangpinxinxiVO 类型的列表
     * 使用Mybatis-Plus的 Wrapper条件查询构造器
     * 传入参数 wrapper为条件查询构造器
     */
    @Override
	public List<ShangpinxinxiVO> selectListVO(Wrapper<ShangpinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
    /**
     * 查询单个商品信息，返回 ShangpinxinxiVO 类型的对象
     * 使用Mybatis-Plus的 Wrapper条件查询构造器
     * 传入参数 wrapper为条件查询构造器
     */
	@Override
	public ShangpinxinxiVO selectVO(Wrapper<ShangpinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	/**
	 * 查询商品信息列表，返回 ShangpinxinxiView 类型的列表
	 * 使用Mybatis-Plus的 Wrapper条件查询构造器
	 * 传入参数 wrapper为条件查询构造器
	 */
	@Override
	public List<ShangpinxinxiView> selectListView(Wrapper<ShangpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	/**
	 * 查询单个商品信息
	 * 返回 ShangpinxinxiView 类型的对象
	 * 使用Mybatis-Plus的 Wrapper条件查询构造器
	 * 传入参数 wrapper为条件查询构造器
	 */
	@Override
	public ShangpinxinxiView selectView(Wrapper<ShangpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

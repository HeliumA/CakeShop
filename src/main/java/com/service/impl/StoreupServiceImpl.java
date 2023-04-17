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


import com.dao.StoreupDao;
import com.entity.StoreupEntity;
import com.service.StoreupService;
import com.entity.vo.StoreupVO;
import com.entity.view.StoreupView;

/**
 * 
 */
@Service("storeupService")
public class StoreupServiceImpl extends ServiceImpl<StoreupDao, StoreupEntity> implements StoreupService {
	
	/**
	 * 查询分页数据
	 * 根据传入的 params 参数中的分页信息进行分页
	 * 同时可根据 EntityWrapper 条件构造器中传入的条件进行筛选
	 */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StoreupEntity> page = this.selectPage(
                new Query<StoreupEntity>(params).getPage(),
                new EntityWrapper<StoreupEntity>()
        );
        return new PageUtils(page);
    }
    
    /**
     * 查询分页数据
     * 与上一个 queryPage 方法相比
     * 这个方法使用了一个自定义的包装器 Wrapper
     * 可根据自定义的条件进行筛选
     */
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<StoreupEntity> wrapper) {
		  Page<StoreupView> page =new Query<StoreupView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    /**
     * 查询符合条件的 VO 列表
     * VO 是一种根据业务需要自定义的实体，它通常不是数据库表的映射实体类
     * 而是一些简化了的实体类，如去除一些无关属性、添加了一些关联属性等
     */
    @Override
	public List<StoreupVO> selectListVO(Wrapper<StoreupEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
    /**
     * 查询符合条件的 VO 对象
     * 与上一个方法相比，它只返回一个 VO 对象
     */
	@Override
	public StoreupVO selectVO(Wrapper<StoreupEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	/**
	 * 查询符合条件的视图列表
	 */
	@Override
	public List<StoreupView> selectListView(Wrapper<StoreupEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	/**
	 * 查询符合条件的视图对象
	 * 与上一个方法相比，它只返回一个视图对象
	 */
	@Override
	public StoreupView selectView(Wrapper<StoreupEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

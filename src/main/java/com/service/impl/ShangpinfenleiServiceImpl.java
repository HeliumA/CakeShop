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


import com.dao.ShangpinfenleiDao;
import com.entity.ShangpinfenleiEntity;
import com.service.ShangpinfenleiService;
import com.entity.vo.ShangpinfenleiVO;
import com.entity.view.ShangpinfenleiView;

/**
 * 继承了 ServiceImpl 类，使用 MyBatis-Plus 框架进行数据库操作
 * 提供了对“商品分类”实体类的 CRUD操作
 */
@Service("shangpinfenleiService")
public class ShangpinfenleiServiceImpl extends ServiceImpl<ShangpinfenleiDao, ShangpinfenleiEntity> implements ShangpinfenleiService {
	
	/**
	 * 根据传入的参数 params
	 * 通过 MyBatis-Plus 提供的 selectPage() 方法查询数据库中的商品分类数据
	 * 并将查询结果封装成 PageUtils 对象返回
	 */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpinfenleiEntity> page = this.selectPage(
                new Query<ShangpinfenleiEntity>(params).getPage(),
                new EntityWrapper<ShangpinfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    /**
     * 可传入查询条件 Wrapper
     * 使用 selectListView() 方法查询数据库并返回结果
     */
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinfenleiEntity> wrapper) {
		  Page<ShangpinfenleiView> page =new Query<ShangpinfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    /**
     * 根据传入的查询条件 Wrapper
     * 使用 baseMapper.selectListVO() 方法查询数据库中的商品分类数据
     * 并将结果封装成 List<ShangpinfenleiVO> 对象返回
     */
    @Override
	public List<ShangpinfenleiVO> selectListVO(Wrapper<ShangpinfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
    /**
     * 根据传入的查询条件 Wrapper
     * 使用 baseMapper.selectVO() 方法查询数据库中的商品分类数据
     * 并将结果封装成 ShangpinfenleiVO 对象返回
     */
	@Override
	public ShangpinfenleiVO selectVO(Wrapper<ShangpinfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	/**
	 * 根据传入的查询条件 Wrapper
	 * 使用 baseMapper.selectListView() 方法查询数据库中的商品分类数据
	 * 并将结果封装成 List<ShangpinfenleiView> 对象返回
	 */
	@Override
	public List<ShangpinfenleiView> selectListView(Wrapper<ShangpinfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	/**
	 * 根据传入的查询条件 Wrapper
	 * 使用 baseMapper.selectView() 方法查询数据库中的商品分类数据
	 * 并将结果封装成 ShangpinfenleiView 对象返回
	 */
	@Override
	public ShangpinfenleiView selectView(Wrapper<ShangpinfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

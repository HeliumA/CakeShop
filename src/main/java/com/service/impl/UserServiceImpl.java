
package com.service.impl;

/**
 * 
 */

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.UserService;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * 实现了UserDao与UserEntity之间的ORM映射
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	/**
	 * 基于MyBatis-Plus的selectPage方法和Query类实现的分页查询
	 * Query类是一个辅助类，通过获取传入参数中的页数和每页记录数等信息，生成一个分页对象
	 * 以便于传递给selectPage方法使用
	 * 同时，该方法也通过EntityWrapper类构造了一个查询条件对象
	 * 作为参数传递给selectPage方法
	 */
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
        );
        return new PageUtils(page);
	}

	/**
	 * 通过调用baseMapper的selectListView方法实现对符合条件的实体对象列表的查询
	 * 该方法的参数是一个Wrapper<UserEntity>类型对象
	 * 它是一个查询条件的封装类，可以用来构建更加复杂的查询条件
	 */
	@Override
	public List<UserEntity> selectListView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	/**
	 * 与第一个queryPage方法实现类似
	 * 增加了对Wrapper<UserEntity>类型参数的支持
	 * 这个方法的实现方式与queryPage方法类似
	 * 在调用selectListView方法时传递了一个Wrapper<UserEntity>类型的参数
	 */
	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<UserEntity> wrapper) {
		 Page<UserEntity> page =new Query<UserEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}
}

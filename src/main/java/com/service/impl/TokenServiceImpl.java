
package com.service.impl;

/**
 * 实现了TokenService接口
 * 包含了对TokenEntity对象的增删改查等操作
 */

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.TokenDao;
import com.entity.TokenEntity;
import com.entity.TokenEntity;
import com.service.TokenService;
import com.utils.CommonUtil;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * 当Spring应用程序上下文初始化时
 * 将会创建一个TokenServiceImpl实例并将其注册为Spring Bean，供其他组件使用
 */
@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

	/**
	 * 使用了MyBatis-Plus的selectPage方法从数据库中查询数据
	 * 并将查询结果封装到一个PageUtils对象中返回
	 * 接收一个Map<String, Object>类型的参数
	 * 该参数包含了查询条件和分页信息
	 */
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TokenEntity> page = this.selectPage(
                new Query<TokenEntity>(params).getPage(),
                new EntityWrapper<TokenEntity>()
        );
        return new PageUtils(page);
	}

	/**
	 * 使用了MyBatis-Plus的baseMapper.selectListView方法从数据库中查询数据
	 * 并将查询结果封装到一个List<TokenEntity>对象中返回
	 * 这个方法接收一个Wrapper<TokenEntity>类型的参数
	 * 该参数包含了查询条件
	 */
	@Override
	public List<TokenEntity> selectListView(Wrapper<TokenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	/**
	 * 根据传入的参数生成一个token，并将token保存到数据库中
	 * 接收一个Long类型的userid、一个String类型的username、一个String类型的tableName和一个String类型的role参数
	 */
	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<TokenEntity> wrapper) {
		 Page<TokenEntity> page =new Query<TokenEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}

	/**
	 * 根据传入的token从数据库中查询TokenEntity对象
	 * 如果该对象的过期时间未到，则返回该对象，否则返回null
	 * 接收一个String类型的token参数
	 */
	@Override
	public String generateToken(Long userid,String username, String tableName, String role) {
		TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("userid", userid).eq("role", role));
		String token = CommonUtil.getRandomString(32);
		Calendar cal = Calendar.getInstance();   
    	cal.setTime(new Date());   
    	cal.add(Calendar.HOUR_OF_DAY, 1);
		if(tokenEntity!=null) {
			tokenEntity.setToken(token);
			tokenEntity.setExpiratedtime(cal.getTime());
			this.updateById(tokenEntity);
		} else {
			this.insert(new TokenEntity(userid,username, tableName, role, token, cal.getTime()));
		}
		return token;
	}

	/**
	 * 使用了MyBatis-Plus提供的Mapper和Service接口
	 * 这些接口提供了通用的增删改查操作
	 * 它还使用了Spring Framework提供的@Service注解来将TokenServiceImpl
	 * 标注为一个服务实现类，这样Spring就能够管理它的生命周期
	 * 并在需要时自动注入它所依赖的其他组件
	 */
	@Override
	public TokenEntity getTokenEntity(String token) {
		TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
		if(tokenEntity == null || tokenEntity.getExpiratedtime().getTime()<new Date().getTime()) {
			return null;
		}
		return tokenEntity;
	}
}

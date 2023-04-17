package com.dao;

import com.entity.StoreupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

//MyBatis-Plus框架中提供的Mapper接口包，BaseMapper是MyBatis-Plus框架提供的基本Mapper接口
import com.baomidou.mybatisplus.mapper.Wrapper;

//MyBatis-Plus框架提供的分页插件包，用于分页查询
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

//MyBatis框架提供的用于传递多个参数的注解
import org.apache.ibatis.annotations.Param;

//StoreupEntity表的值对象，数据传递
import com.entity.vo.StoreupVO;

//视图对象，显示
import com.entity.view.StoreupView;

/**
 * 收藏表
 * 定义了操作"StoreupEntity"表的DAO层接口
 * 包含了增删改查等数据库操作方法
 */

public interface StoreupDao extends BaseMapper<StoreupEntity> {
	
	//查询符合条件的所有StoreupEntity记录的值对象列表
	List<StoreupVO> selectListVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	//查询符合条件的一条StoreupEntity记录的值对象
	StoreupVO selectVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	//分页查询符合条件的StoreupEntity记录的视图对象列表
	List<StoreupView> selectListView(@Param("ew") Wrapper<StoreupEntity> wrapper);

	List<StoreupView> selectListView(Pagination page,@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	//查询符合条件的一条StoreupEntity记录的视图对象
	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
}

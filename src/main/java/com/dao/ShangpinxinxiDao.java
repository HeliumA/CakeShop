package com.dao;

import com.entity.ShangpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangpinxinxiVO;
import com.entity.view.ShangpinxinxiView;


/**
 * 蛋糕信息
 * 使用MyBatis-Plus框架的BaseMapper接口提供基本的CRUD操作操作蛋糕信息表
 */

public interface ShangpinxinxiDao extends BaseMapper<ShangpinxinxiEntity> {
	
	//根据条件查询蛋糕信息的列表，返回一个由ShangpinxinxiVO（蛋糕信息值对象）组成的List集合
	List<ShangpinxinxiVO> selectListVO(@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);
	
	//根据条件查询单个蛋糕信息，返回一个ShangpinxinxiVO对象
	ShangpinxinxiVO selectVO(@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);
	
	//根据条件查询蛋糕信息的视图列表，返回一个由ShangpinxinxiView（蛋糕信息视图对象）组成的List集合
	List<ShangpinxinxiView> selectListView(@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);

	//根据条件分页查询蛋糕信息的视图列表，返回一个由ShangpinxinxiView（蛋糕信息视图对象）组成的List集合
	List<ShangpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);
	
	//根据条件查询单个蛋糕信息的视图，返回一个ShangpinxinxiView对象
	ShangpinxinxiView selectView(@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);
	
}

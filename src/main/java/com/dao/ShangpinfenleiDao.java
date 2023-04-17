package com.dao;

import com.entity.ShangpinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangpinfenleiVO;
import com.entity.view.ShangpinfenleiView;


/**
 * 蛋糕分类
 * 定义了操作名为"ShangpinfenleiEntity"的实体类对应的表的方法
 */

public interface ShangpinfenleiDao extends BaseMapper<ShangpinfenleiEntity> {
	
	//根据查询条件Wrapper<ShangpinfenleiEntity>返回ShangpinfenleiVO的列表
	List<ShangpinfenleiVO> selectListVO(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
	
	//根据查询条件Wrapper<ShangpinfenleiEntity>返回单个ShangpinfenleiVO
	ShangpinfenleiVO selectVO(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
	
	//根据查询条件Wrapper<ShangpinfenleiEntity>返回ShangpinfenleiView的列表
	List<ShangpinfenleiView> selectListView(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);

	//根据分页对象Pagination和查询条件Wrapper<ShangpinfenleiEntity>返回ShangpinfenleiView的列表
	List<ShangpinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
	
	//根据查询条件Wrapper<ShangpinfenleiEntity>返回单个ShangpinfenleiView
	ShangpinfenleiView selectView(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
	
}

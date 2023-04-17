package com.dao;

import com.entity.YonghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghuVO;
import com.entity.view.YonghuView;


/**
 * 客户
 * 定义了对于YonghuEntity对象的数据库操作方法
 */

public interface YonghuDao extends BaseMapper<YonghuEntity> {
	
	//根据查询条件Wrapper获取YonghuVO对象列表
	List<YonghuVO> selectListVO(@Param("ew") Wrapper<YonghuEntity> wrapper);
	
	//根据查询条件Wrapper获取单个YonghuVO对象
	YonghuVO selectVO(@Param("ew") Wrapper<YonghuEntity> wrapper);
	
	//根据查询条件Wrapper获取YonghuView对象列表
	List<YonghuView> selectListView(@Param("ew") Wrapper<YonghuEntity> wrapper);

	//根据查询条件Wrapper获取YonghuView对象列表，并进行分页
	List<YonghuView> selectListView(Pagination page,@Param("ew") Wrapper<YonghuEntity> wrapper);
	
	//根据查询条件Wrapper获取单个YonghuView对象
	YonghuView selectView(@Param("ew") Wrapper<YonghuEntity> wrapper);
	
}

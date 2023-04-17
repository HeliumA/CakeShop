package com.dao;

import com.entity.DiscussshangpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshangpinxinxiVO;
import com.entity.view.DiscussshangpinxinxiView;


/**
 * 蛋糕信息评论表
 * 可用于对蛋糕信息评论表进行各种操作，如查询、更新、删除
 * 基于MyBatis-Plus框架提供的基本数据访问方法实现
 * 支持通过 Wrapper 对象进行条件查询，并支持分页查询
 */

public interface DiscussshangpinxinxiDao extends BaseMapper<DiscussshangpinxinxiEntity> {
	
	//根据指定的 Wrapper 条件查询蛋糕信息评论表的视图对象列表 DiscussshangpinxinxiVO
	List<DiscussshangpinxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussshangpinxinxiEntity> wrapper);
	
	//根据指定的 Wrapper 条件查询蛋糕信息评论表的视图对象 DiscussshangpinxinxiVO
	DiscussshangpinxinxiVO selectVO(@Param("ew") Wrapper<DiscussshangpinxinxiEntity> wrapper);
	
	//根据指定的 Wrapper 条件查询蛋糕信息评论表的视图对象列表 DiscussshangpinxinxiView
	List<DiscussshangpinxinxiView> selectListView(@Param("ew") Wrapper<DiscussshangpinxinxiEntity> wrapper);

	//根据指定的 Wrapper 条件和分页对象 Pagination 分页查询蛋糕信息评论表的视图对象列表DiscussshangpinxinxiView
	List<DiscussshangpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshangpinxinxiEntity> wrapper);
	
	//根据指定的 Wrapper 条件查询蛋糕信息评论表的视图对象 DiscussshangpinxinxiView
	DiscussshangpinxinxiView selectView(@Param("ew") Wrapper<DiscussshangpinxinxiEntity> wrapper);
	
}

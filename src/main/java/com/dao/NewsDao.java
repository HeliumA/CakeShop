package com.dao;

import com.entity.NewsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NewsVO;
import com.entity.view.NewsView;


/**
 * 新闻公告
 * 用于操作名为NewsEntity的实体类对应的表
 * 继承了BaseMapper接口，其中已经包含了基本的CRUD（增删改查）方法
 * 提供与NewsEntity表的数据交互
 * 是MyBatis-Plus框架在ORM（对象关系映射）过程中的一种实现方式
 */

public interface NewsDao extends BaseMapper<NewsEntity> {
	
	//查询符合条件的NewsEntity实体类数据，并转换成NewsVO视图类的列表数据
	List<NewsVO> selectListVO(@Param("ew") Wrapper<NewsEntity> wrapper);
	
	//查询符合条件的单条NewsEntity实体类数据，并转换成NewsVO视图类数据
	NewsVO selectVO(@Param("ew") Wrapper<NewsEntity> wrapper);
	
	//查询符合条件的NewsEntity实体类数据，并转换成NewsView视图类的列表数据
	List<NewsView> selectListView(@Param("ew") Wrapper<NewsEntity> wrapper);
	
	//查询符合条件的NewsEntity实体类数据，并转换成NewsView视图类的列表数据，同时进行分页操作
	List<NewsView> selectListView(Pagination page,@Param("ew") Wrapper<NewsEntity> wrapper);
	
	//查询符合条件的单条NewsEntity实体类数据，并转换成NewsView视图类数据
	NewsView selectView(@Param("ew") Wrapper<NewsEntity> wrapper);
	
}

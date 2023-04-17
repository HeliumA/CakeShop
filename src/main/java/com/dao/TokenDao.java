
package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.TokenEntity;

/**
 * token
 * 继承了 BaseMapper<TokenEntity> 接口
 * 用来操作 TokenEntity 实体类的数据访问对象
 */

public interface TokenDao extends BaseMapper<TokenEntity> {
	
	//接收一个 Wrapper<TokenEntity> 参数，返回一个 List<TokenEntity> 类型的对象
	//根据给定的查询条件查询出的 token 列表
	List<TokenEntity> selectListView(@Param("ew") Wrapper<TokenEntity> wrapper);

	//接收一个 Pagination 和 Wrapper<TokenEntity> 参数，返回一个 List<TokenEntity> 类型的对象
	//根据给定的查询条件和分页信息查询出的 token 列表
	List<TokenEntity> selectListView(Pagination page,@Param("ew") Wrapper<TokenEntity> wrapper);
	
}

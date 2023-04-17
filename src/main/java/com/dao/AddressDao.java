package com.dao;

import com.entity.AddressEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AddressVO;
import com.entity.view.AddressView;

/**
 * 地址
 */
public interface AddressDao extends BaseMapper<AddressEntity> {
	//继承了 BaseMapper<AddressEntity> 接口，该接口提供了对 AddressEntity 类型的基本数据库操作（如增删改查）
	//BaseMapper 接口提供了一些基本的 CRUD 操作，而 AddressDao 接口则在此基础上扩展了一些查询方法
	
	List<AddressVO> selectListVO(@Param("ew") Wrapper<AddressEntity> wrapper);
	
	AddressVO selectVO(@Param("ew") Wrapper<AddressEntity> wrapper);
	
	List<AddressView> selectListView(@Param("ew") Wrapper<AddressEntity> wrapper);
	//使用了 MyBatis-Plus 提供的分页功能，它接受一个 Pagination 对象和一个 Wrapper<AddressEntity> 对象作为参数
	//可以将查询结果按照分页要求进行返回
	List<AddressView> selectListView(Pagination page,@Param("ew") Wrapper<AddressEntity> wrapper);
	
	AddressView selectView(@Param("ew") Wrapper<AddressEntity> wrapper);
	
}

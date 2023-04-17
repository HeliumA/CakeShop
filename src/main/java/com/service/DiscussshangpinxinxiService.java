package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshangpinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshangpinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshangpinxinxiView;


/**
 * 蛋糕信息评论表
 * 继承了IService接口
 * 并规定了该服务需要实现的方法
 * 为了实现查询蛋糕信息评论表的各种查询功能而定义
 */

public interface DiscussshangpinxinxiService extends IService<DiscussshangpinxinxiEntity> {

	/**
	 * 查询蛋糕信息评论表的分页数据
	 * 接收一个名为params的Map类型参数
	 */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 查询DiscussshangpinxinxiVO列表
     * 接收一个Wrapper<DiscussshangpinxinxiEntity>类型参数
     */
   	List<DiscussshangpinxinxiVO> selectListVO(Wrapper<DiscussshangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 查询DiscussshangpinxinxiVO列表
   	 * 接收一个Wrapper<DiscussshangpinxinxiEntity>类型参数
   	 */
   	DiscussshangpinxinxiVO selectVO(@Param("ew") Wrapper<DiscussshangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 查询DiscussshangpinxinxiVO列表
   	 * 接收一个Wrapper<DiscussshangpinxinxiEntity>类型参数
   	 */
   	List<DiscussshangpinxinxiView> selectListView(Wrapper<DiscussshangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 查询DiscussshangpinxinxiVO列表
   	 * 接收一个Wrapper<DiscussshangpinxinxiEntity>类型参数
   	 */
   	DiscussshangpinxinxiView selectView(@Param("ew") Wrapper<DiscussshangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 用于查询蛋糕信息评论表的分页数据
   	 * 接收一个名为params的Map类型参数
   	 * 和一个Wrapper<DiscussshangpinxinxiEntity>类型参数
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshangpinxinxiEntity> wrapper);
   	
}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinxinxiView;


/**
 * 蛋糕信息
 */
public interface ShangpinxinxiService extends IService<ShangpinxinxiEntity> {

	/**
	 * 查询蛋糕信息的分页列表
	 * 返回PageUtils对象
	 */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 查询蛋糕信息列表
     * 并将其转换为ShangpinxinxiVO对象的列表
     * 返回List<ShangpinxinxiVO>
     */
   	List<ShangpinxinxiVO> selectListVO(Wrapper<ShangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 查询单个蛋糕信息
   	 * 并将其转换为ShangpinxinxiVO对象
   	 * 返回ShangpinxinxiVO
   	 */
   	ShangpinxinxiVO selectVO(@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 查询蛋糕信息列表
   	 * 并将其转换为ShangpinxinxiView对象的列表
   	 * 返回List<ShangpinxinxiView>
   	 */
   	List<ShangpinxinxiView> selectListView(Wrapper<ShangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 查询单个蛋糕信息
   	 * 并将其转换为ShangpinxinxiView对象
   	 * 返回ShangpinxinxiView
   	 */
   	ShangpinxinxiView selectView(@Param("ew") Wrapper<ShangpinxinxiEntity> wrapper);
   	
   	/**
   	 * 查询蛋糕信息的分页列表
   	 * 并可根据Wrapper<ShangpinxinxiEntity>条件进行筛选
   	 * 返回PageUtils对象
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinxinxiEntity> wrapper);
   	
}


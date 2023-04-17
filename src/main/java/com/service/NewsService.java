package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NewsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NewsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NewsView;


/**
 * 继承了IService接口
 */
public interface NewsService extends IService<NewsEntity> {

	/**
	 * 根据参数params查询分页数据
	 * 并返回一个PageUtils对象
	 */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 根据查询条件wrapper查询符合条件的NewsEntity实体
     * 然后将其转换为NewsVO实体集合返回
     */
   	List<NewsVO> selectListVO(Wrapper<NewsEntity> wrapper);
   	
   	/**
   	 * 根据查询条件wrapper查询符合条件的NewsEntity实体
   	 * 并将其转换为NewsVO对象返回
   	 */
   	NewsVO selectVO(@Param("ew") Wrapper<NewsEntity> wrapper);
   	
   	/**
   	 * 根据查询条件wrapper查询符合条件的NewsEntity实体
   	 * 然后将其转换为NewsView实体集合返回
   	 */
   	List<NewsView> selectListView(Wrapper<NewsEntity> wrapper);
   	
   	/**
   	 * 根据查询条件wrapper查询符合条件的NewsEntity实体
   	 * 并将其转换为NewsView对象返回
   	 */
   	NewsView selectView(@Param("ew") Wrapper<NewsEntity> wrapper);
   	
   	/**
   	 * 根据参数params和查询条件wrapper查询分页数据
   	 * 并返回一个PageUtils对象
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NewsEntity> wrapper);
   	
}


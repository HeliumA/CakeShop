package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpinfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinfenleiView;


/**
 * 对蛋糕分类的服务方法
 * 继承了MyBatisPlus框架中的IService接口
 */

public interface ShangpinfenleiService extends IService<ShangpinfenleiEntity> {

	
	/**
	 * 输入一个`Map<String, Object>`类型的参数`params`
	 * 返回一个`PageUtils`类型的对象
	 * 用于查询蛋糕分类的分页列表蛋糕分类
	 */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 输入一个`Wrapper<ShangpinfenleiEntity>`类型的参数`wrapper`
     * 返回一个`List<ShangpinfenleiVO>`类型的对象
     * 用于查询蛋糕分类的列表，返回的数据是视图对象（VO）
     */
   	List<ShangpinfenleiVO> selectListVO(Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	/**
   	 * 输入一个`Wrapper<ShangpinfenleiEntity>`类型的参数`wrapper`
   	 * 返回一个`ShangpinfenleiVO`类型的对象
   	 * 用于查询单个蛋糕分类的详细信息，返回的数据是视图对象（VO）
   	 */
   	ShangpinfenleiVO selectVO(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	/**
   	 * 输入一个`Wrapper<ShangpinfenleiEntity>`类型的参数`wrapper`
   	 * 返回一个`List<ShangpinfenleiView>`类型的对象
   	 * 用于查询蛋糕分类的列表，返回的数据是视图对象（View）
   	 */
   	List<ShangpinfenleiView> selectListView(Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	/**
   	 * 输入一个`Wrapper<ShangpinfenleiEntity>`类型的参数`wrapper`
   	 * 返回一个`ShangpinfenleiView`类型的对象
   	 * 用于查询单个蛋糕分类的详细信息，返回的数据是视图对象（View）
   	 */
   	ShangpinfenleiView selectView(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	/**
   	 * 输入一个`Map<String, Object>`类型的参数`params`
   	 * 和一个`Wrapper<ShangpinfenleiEntity>`类型的参数`wrapper`
   	 * 返回一个`PageUtils`类型的对象
   	 * 用于查询蛋糕分类的分页列表，同时支持条件查询
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinfenleiEntity> wrapper);
   	
}


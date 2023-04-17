package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghuView;


/**
 * 客户
 * 继承了IService接口，并指定了泛型类型为YonghuEntity
 * 提供了对YonghuEntity实体类的服务
 */

public interface YonghuService extends IService<YonghuEntity> {

	/**
	 * 查询方法，返回一个PageUtils对象
	 * 该对象是用来处理分页查询的工具类
	 * 方法需要传入一个Map类型的参数params，表示查询条件
	 */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 查询方法，返回一个YonghuVO类型的List列表
     * 该方法需要传入一个Wrapper类型的参数wrapper
     * 该对象是MyBatis-Plus中的条件构造器，用于构建SQL语句中的where子句
     */
   	List<YonghuVO> selectListVO(Wrapper<YonghuEntity> wrapper);
   	
   	/**
   	 * 查询方法，返回一个YonghuVO对象
   	 * 需要传入一个Wrapper类型的参数wrapper
   	 */
   	YonghuVO selectVO(@Param("ew") Wrapper<YonghuEntity> wrapper);
   	
   	/**
   	 * 查询方法，返回一个YonghuView类型的List列表
   	 * 同样需要传入一个Wrapper类型的参数wrapper
   	 */
   	List<YonghuView> selectListView(Wrapper<YonghuEntity> wrapper);
   	
   	/**
   	 * 查询方法，返回一个YonghuView对象
   	 * 需要传入一个Wrapper类型的参数wrapper
   	 */
   	YonghuView selectView(@Param("ew") Wrapper<YonghuEntity> wrapper);
   	
   	/**
   	 * 查询方法，返回一个PageUtils对象，需要传入两个参数
   	 * 一个是Map类型的参数params表示查询条件
   	 * 另一个是Wrapper类型的参数wrapper表示查询的条件构造器
   	 */
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghuEntity> wrapper);
   	
}


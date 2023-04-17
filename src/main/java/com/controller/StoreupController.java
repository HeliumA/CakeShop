package com.controller;
//声明了一个包名为com.controller的Java类，用于存放控制器类

import java.text.SimpleDateFormat;
//导入Java中用于格式化时间的类
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
//用于处理HTTP请求的类

import com.utils.ValidatorUtils;
//导入自定义的工具类，用于校验数据
import org.apache.commons.lang3.StringUtils;
//导入Apache工具包中用于处理字符串的类
import org.springframework.beans.factory.annotation.Autowired;
//导入Spring框架中的@Autowired注解，用于自动装配Bean
import org.springframework.format.annotation.DateTimeFormat;
//导入Spring框架中用于格式化日期的注解
import org.springframework.web.bind.annotation.PathVariable;
//导入Spring框架中用于处理HTTP请求的注解
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
//导入Mybatis-Plus框架中的Mapper接口，用于数据库操作

import com.annotation.IgnoreAuth;
//导入自定义注解，用于标记无需认证的接口

import com.entity.StoreupEntity;
//导入实体类，用于封装与表相关的数据

import com.entity.view.StoreupView;
//导入视图类，用于封装与表相关的数据，并提供额外的视图

import com.service.StoreupService;
//导入服务类，用于封装表的业务逻辑

import com.service.TokenService;
//导入服务类，用于处理Token

import com.utils.PageUtils;
//导入自定义工具类，用于处理分页相关的数据

import com.utils.R;
//导入自定义工具类，用于处理响应相关的数据

import com.utils.MD5Util;
//导入自定义工具类，用于处理MD5加密相关的数据

import com.utils.MPUtil;
//导入自定义工具类，用于处理Mybatis-Plus相关的数据

import com.utils.CommonUtil;
//导入自定义工具类，用于处理常规的工具函数

/**
 * 收藏表
 * 后端接口
 */

@RestController
//定义了该控制器处理请求的基础URL
@RequestMapping("/storeup")
//定义了处理请求的方法，它接收两个参数：params和storeup，返回值是一个R类型的对象
//该方法通过调用storeupService.queryPage(params, ...)方法，根据参数params和storeup获取相应的数据
//并返回一个R类型的对象

public class StoreupController {
    @Autowired
    private StoreupService storeupService;
    
    /**
     * 后端列表
     * 处理客户端发来的请求，返回收藏列表的某一页数据
     * 如果当前用户不是管理员，则只返回该用户的收藏数据
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,StoreupEntity storeup,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		storeup.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
		PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     * 处理客户端发来的请求，返回收藏列表的某一页数据
     * 如果当前用户不是管理员，则只返回该用户的收藏数据
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StoreupEntity storeup, HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		storeup.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
		PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     * 处理客户端发来的请求，返回符合查询条件的收藏数据
     */
    @RequestMapping("/lists")
    public R list( StoreupEntity storeup){
       	EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
      	ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
        return R.ok().put("data", storeupService.selectListView(ew));
    }

	 /**
     * 查询
     * 处理客户端发来的请求，返回符合查询条件的收藏数据的详细信息
     */
    @RequestMapping("/query")
    public R query(StoreupEntity storeup){
        EntityWrapper< StoreupEntity> ew = new EntityWrapper< StoreupEntity>();
 		ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
		StoreupView storeupView =  storeupService.selectView(ew);
		return R.ok("查询收藏表成功").put("data", storeupView);
    }
	
    /**
     * 后端详情
     * 处理客户端发来的请求，返回指定id的收藏数据的详细信息。仅管理员可访问
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
        return R.ok().put("data", storeup);
    }

    /**
     * 前端详情
     * 处理客户端发来的请求，返回指定id的收藏数据的详细信息
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
        return R.ok().put("data", storeup);
    }
    
    /**
     * 后端保存
     * 处理客户端发来的请求，保存收藏数据。仅管理员可访问
     */
    @RequestMapping("/save")
    public R save(@RequestBody StoreupEntity storeup, HttpServletRequest request){
    	storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(storeup);
    	storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        storeupService.insert(storeup);
        return R.ok();
    }
    
    /**
     * 前端保存
     * 处理客户端发来的请求，添加收藏数据
     */
    @RequestMapping("/add")
    public R add(@RequestBody StoreupEntity storeup, HttpServletRequest request){
    	storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(storeup);
    	storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        storeupService.insert(storeup);
        return R.ok();
    }

    /**
     * 修改
     * 处理客户端发来的请求，更新指定id的收藏数据
     */
    @RequestMapping("/update")
    public R update(@RequestBody StoreupEntity storeup, HttpServletRequest request){
        //ValidatorUtils.validateEntity(storeup);
        storeupService.updateById(storeup);//全部更新
        return R.ok();
    }
    
    /**
     * 删除
     * 处理客户端发来的请求，删除指定id的收藏数据
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        storeupService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     * 处理HTTP请求路径为"/remind/{columnName}/{type}"的GET请求
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		//通过@PathVariable注解将URL路径中的两个参数映射到方法的两个String类型的参数columnName和type中
		map.put("column", columnName);
		map.put("type", type);
		//将传入的参数map中的"column"和"type"键分别赋值为columnName和type的值
		
		if(type.equals("2")) {
			//转换"remindstart"和"remindend"键的值修改为格式为"yyyy-MM-dd"的日期字符串
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<StoreupEntity> wrapper = new EntityWrapper<StoreupEntity>();
		//创建一个Wrapper对象，通过EntityWrapper类创建，泛型指定了StoreupEntity类
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		//调用Wrapper对象的ge和le方法进行大于等于和小于等于的条件筛选
		
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}
		//判断了当前请求是否为管理员用户，如果不是，则根据当前用户的ID进行筛选


		int count = storeupService.selectCount(wrapper);
		//调用storeupService对象的selectCount方法，根据上述条件筛选出满足条件的记录总数
		return R.ok().put("count", count);
	}
	


}

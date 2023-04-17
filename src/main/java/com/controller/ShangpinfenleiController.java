package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShangpinfenleiEntity;
import com.entity.view.ShangpinfenleiView;

import com.service.ShangpinfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 蛋糕分类
 * 后端接口
 * 控制器类，包含了对商品分类进行增删改查的接口
 */

@RestController
//REST风格的控制器，用于接收和响应HTTP请求

@RequestMapping("/shangpinfenlei")


public class ShangpinfenleiController {
    @Autowired
    private ShangpinfenleiService shangpinfenleiService;
    
    /**
     * 后端列表
     * 分页查询蛋糕分类列表
     * 接收一个Map类型的参数和一个ShangpinfenleiEntity类型的参数
     * 返回一个PageUtils对象，该对象封装了分页查询的结果
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinfenleiEntity shangpinfenlei,
		HttpServletRequest request){
        EntityWrapper<ShangpinfenleiEntity> ew = new EntityWrapper<ShangpinfenleiEntity>();
		PageUtils page = shangpinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     * 查询蛋糕分类列表，但没有分页功能
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinfenleiEntity shangpinfenlei, HttpServletRequest request){
        EntityWrapper<ShangpinfenleiEntity> ew = new EntityWrapper<ShangpinfenleiEntity>();
		PageUtils page = shangpinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 用于查询蛋糕分类列表
     * 接收一个ShangpinfenleiEntity类型的参数
     * 返回一个List类型的对象，该对象封装了查询结果
     */
    @RequestMapping("/lists")
    public R list( ShangpinfenleiEntity shangpinfenlei){
       	EntityWrapper<ShangpinfenleiEntity> ew = new EntityWrapper<ShangpinfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinfenlei, "shangpinfenlei")); 
        return R.ok().put("data", shangpinfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     * 用于根据参数查询蛋糕分类
     * 接收一个ShangpinfenleiEntity类型的参数
     * 返回一个ShangpinfenleiView类型的对象
     * 该对象封装了查询结果。
     */
    @RequestMapping("/query")
    public R query(ShangpinfenleiEntity shangpinfenlei){
        EntityWrapper< ShangpinfenleiEntity> ew = new EntityWrapper< ShangpinfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinfenlei, "shangpinfenlei")); 
		ShangpinfenleiView shangpinfenleiView =  shangpinfenleiService.selectView(ew);
		return R.ok("查询蛋糕分类成功").put("data", shangpinfenleiView);
    }
	
    /**
     * 后端详情
     * 用于查询蛋糕分类详情，接收一个Long类型的参数id
     * 返回一个R类型的对象，该对象封装了查询结果
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinfenleiEntity shangpinfenlei = shangpinfenleiService.selectById(id);
        return R.ok().put("data", shangpinfenlei);
    }

    /**
     * 前端详情
     * 用于查询蛋糕分类详情，接收一个Long类型的参数id
     * 返回一个R类型的对象，该对象封装了查询结果
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinfenleiEntity shangpinfenlei = shangpinfenleiService.selectById(id);
        return R.ok().put("data", shangpinfenlei);
    }
    
    /**
     * 后端保存
     * 用于新增蛋糕分类，接收一个ShangpinfenleiEntity类型的参数
     * 返回一个R类型的对象，该对象封装了操作结果
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinfenleiEntity shangpinfenlei, HttpServletRequest request){
    	shangpinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinfenlei);
        shangpinfenleiService.insert(shangpinfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     * 用于新增蛋糕分类，接收一个ShangpinfenleiEntity类型的参数
     * 返回一个R类型的对象，该对象封装了操作结果
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinfenleiEntity shangpinfenlei, HttpServletRequest request){
    	shangpinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinfenlei);
        shangpinfenleiService.insert(shangpinfenlei);
        return R.ok();
    }

    /**
     * 修改
     * 用于更新蛋糕分类，接收一个ShangpinfenleiEntity类型的参数
     * 返回一个R类型的对象，该对象封装了操作结果
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinfenleiEntity shangpinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinfenlei);
        shangpinfenleiService.updateById(shangpinfenlei);//全部更新
        return R.ok();
    }
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
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
		
		Wrapper<ShangpinfenleiEntity> wrapper = new EntityWrapper<ShangpinfenleiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = shangpinfenleiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
	 * 对于后端和前端列表、查询和详情等接口方法
	 * 使用了实体包装类（EntityWrapper）和自定义的分页工具类（PageUtils）进行分页和条件查询操作
	 * 使用了R类作为返回结果的封装对象
	 * 后端保存和前端保存接口方法中
	 * 使用了Java注解和请求体（RequestBody）对提交的数据进行验证并添加到数据库
	 */


}

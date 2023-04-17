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

import com.entity.DiscussshangpinxinxiEntity;
import com.entity.view.DiscussshangpinxinxiView;

import com.service.DiscussshangpinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 蛋糕信息评论表
 * 用于处理与蛋糕信息评论表相关的请求
 */


@RestController
@RequestMapping("/discussshangpinxinxi")
public class DiscussshangpinxinxiController {
	//处理后端请求
    @Autowired
    private DiscussshangpinxinxiService discussshangpinxinxiService;
    //私有变量，该变量由Spring容器注入
    
    /**
     * 后端列表
     * 用于处理后端的分页请求
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshangpinxinxiEntity discussshangpinxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussshangpinxinxiEntity> ew = new EntityWrapper<DiscussshangpinxinxiEntity>();
		PageUtils page = discussshangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshangpinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     * 用于处理前端的列表请求
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request){
        EntityWrapper<DiscussshangpinxinxiEntity> ew = new EntityWrapper<DiscussshangpinxinxiEntity>();
		PageUtils page = discussshangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshangpinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     * 用于查询蛋糕信息评论表
     */
    @RequestMapping("/lists")
    public R list( DiscussshangpinxinxiEntity discussshangpinxinxi){
       	EntityWrapper<DiscussshangpinxinxiEntity> ew = new EntityWrapper<DiscussshangpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshangpinxinxi, "discussshangpinxinxi")); 
        return R.ok().put("data", discussshangpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     * 用于查询蛋糕信息评论表详情
     */
    @RequestMapping("/query")
    public R query(DiscussshangpinxinxiEntity discussshangpinxinxi){
        EntityWrapper< DiscussshangpinxinxiEntity> ew = new EntityWrapper< DiscussshangpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshangpinxinxi, "discussshangpinxinxi")); 
		DiscussshangpinxinxiView discussshangpinxinxiView =  discussshangpinxinxiService.selectView(ew);
		return R.ok("查询蛋糕信息评论表成功").put("data", discussshangpinxinxiView);
    }
	
    /**
     * 后端详情
     * 用于处理后端的详情请求
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshangpinxinxiEntity discussshangpinxinxi = discussshangpinxinxiService.selectById(id);
        return R.ok().put("data", discussshangpinxinxi);
    }

    /**
     * 前端详情
     * 用于处理前端的详情请求
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshangpinxinxiEntity discussshangpinxinxi = discussshangpinxinxiService.selectById(id);
        return R.ok().put("data", discussshangpinxinxi);
    }
    
    /**
     * 后端保存
     * 用于保存蛋糕信息评论表数据
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request){
    	discussshangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshangpinxinxi);
        discussshangpinxinxiService.insert(discussshangpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     * 用于保存蛋糕信息评论表数据
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request){
    	discussshangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshangpinxinxi);
        discussshangpinxinxiService.insert(discussshangpinxinxi);
        return R.ok();
    }

    /**
     * 修改
     * 使用@RequestMapping注释表示映射到URL路径“/update”
     * 接收请求体中的“DiscussshangpinxinxiEntity”对象实例
     * 使用“discussshangpinxinxiService.updateById()”方法进行全部更新
     * 返回一个“R.ok()”对象实例
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshangpinxinxi);
        discussshangpinxinxiService.updateById(discussshangpinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     * 使用@RequestMapping注释表示映射到URL路径“/delete”
     * 接收请求体中的“Long”类型数组“ids
     * 使用“discussshangpinxinxiService.deleteBatchIds()”方法批量删除
     * 返回一个“R.ok()”对象实例
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshangpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     * 使用@RequestMapping注释表示映射到URL路径“/remind/{columnName}/{type}”
     * 接收两个路径变量“columnName”和“type”，分别表示提醒的列名和类型
     * 接收一个请求参数映射为“Map<String, Object> map”，用于存储其他参数
     * 
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			//首先判断类型是否为“2”
			//如果是，则将请求参数中的“remindstart”和“remindend”参数解析为整数，并根据当前日期计算出提醒开始和结束日期，并将其格式化为“yyyy-MM-dd”格式存储在“map”中
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
		//使用“EntityWrapper”对象构造“wrapper”条件对象，并根据“map”中存储的提醒开始和结束日期添加大于等于和小于等于条件
		Wrapper<DiscussshangpinxinxiEntity> wrapper = new EntityWrapper<DiscussshangpinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussshangpinxinxiService.selectCount(wrapper);
		//最后使用“discussshangpinxinxiService.selectCount()”方法查询符合条件的记录数，并将结果存储在一个“R.ok()”对象实例中返回
		return R.ok().put("count", count);
	}
	


}

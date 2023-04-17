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

import com.entity.CartEntity;
import com.entity.view.CartView;

import com.service.CartService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 购物车表
 * 后端接口
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    


    /**
     * 后端列表
     * 获取购物车表的分页数据
     * 根据请求参数和当前登录用户的角色不同，返回不同的数据
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CartEntity cart,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		cart.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<CartEntity> ew = new EntityWrapper<CartEntity>();
		PageUtils page = cartService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cart), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     * 获取购物车表的分页数据
     * 与page()方法的区别在于不考虑登录用户的角色。
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CartEntity cart, HttpServletRequest request){
        EntityWrapper<CartEntity> ew = new EntityWrapper<CartEntity>();
		PageUtils page = cartService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cart), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     * 获取购物车表的视图数据，查询条件与请求参数相同
     */
    @RequestMapping("/lists")
    public R list( CartEntity cart){
       	EntityWrapper<CartEntity> ew = new EntityWrapper<CartEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cart, "cart")); 
        return R.ok().put("data", cartService.selectListView(ew));
    }

	 /**
     * 查询
     * 查询购物车表的详细信息，查询条件与请求参数相同
     */
    @RequestMapping("/query")
    public R query(CartEntity cart){
        EntityWrapper< CartEntity> ew = new EntityWrapper< CartEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cart, "cart")); 
		CartView cartView =  cartService.selectView(ew);
		return R.ok("查询购物车表成功").put("data", cartView);
    }
	
    /**
     * 后端详情
     * 获取购物车表的详细信息，根据购物车表的ID进行查询
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CartEntity cart = cartService.selectById(id);
        return R.ok().put("data", cart);
    }

    /**
     * 前端详情
     * 获取购物车表的详细信息
     * 与info()方法的区别在于不考虑当前登录用户的角色
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CartEntity cart = cartService.selectById(id);
        return R.ok().put("data", cart);
    }
    
    /**
     * 后端保存
     * 保存购物车表的信息，根据请求参数创建新的购物车表记录
     */
    @RequestMapping("/save")
    public R save(@RequestBody CartEntity cart, HttpServletRequest request){
    	cart.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cart);
    	cart.setUserid((Long)request.getSession().getAttribute("userId"));
        cartService.insert(cart);
        return R.ok();
    }
    
    /**
     * 前端保存
     * 添加购物车表的信息，与save()方法的区别在于不考虑当前登录用户的角色。
     */
    @RequestMapping("/add")
    public R add(@RequestBody CartEntity cart, HttpServletRequest request){
    	cart.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cart);
        cartService.insert(cart);
        return R.ok();
    }

    /**
     * 修改
     * 修改购物车表的信息，根据请求参数更新指定的购物车表记录
     */
    @RequestMapping("/update")
    public R update(@RequestBody CartEntity cart, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cart);
        cartService.updateById(cart);//全部更新
        return R.ok();
    }
    
    /**
     * 删除
     * 删除购物车表的信息，根据请求参数删除指定的购物车表记录
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cartService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     * 提醒接口，根据请求参数获取购物车表的数据，并返回符合条件的记录数。
     */
	@RequestMapping("/remind/{columnName}/{type}")
	//指定了映射的URL路径，包含两个占位符{columnName}和{type}
	
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		//将URL路径中的{columnName}占位符与这个参数绑定
		//包含了HTTP请求的信息
		//将URL路径中的{type}占位符与这个参数绑定
		//将所有的请求参数绑定到一个Map对象中
		
		map.put("column", columnName);
		//将列名存储到Map中
		
		map.put("type", type);
		//将类型存储到Map中
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//创建一个日期格式化器
			Calendar c = Calendar.getInstance();//创建一个日历对象
			Date remindStartDate = null;//初始化一个提醒开始日期
			Date remindEndDate = null;//初始化一个提醒结束日期
			if(map.get("remindstart")!=null) {//如果提醒开始日期不为空
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); //设置日历对象的日期为当前日期
				c.add(Calendar.DAY_OF_MONTH,remindStart);//将提醒开始天数添加到日历对象的日期中
				remindStartDate = c.getTime();//将日历对象转换为日期对象，并将其存储到提醒开始日期变量中
				map.put("remindstart", sdf.format(remindStartDate));
				//将提醒开始日期格式化为字符串，并将其存储到Map中
			}
			if(map.get("remindend")!=null) {//如果提醒结束日期不为空
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CartEntity> wrapper = new EntityWrapper<CartEntity>();
		//创建一个查询条件包装器
		if(map.get("remindstart")!=null) {//如果提醒开始日期不为空，则添加一个大于等于提醒开始日期的条件
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {//如果提醒开始日期不为空，则添加一个大于等于提醒开始日期的条件。
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {//如果非管理员，则添加一个用户id的条件
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = cartService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

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

import com.entity.ShangpinxinxiEntity;
import com.entity.view.ShangpinxinxiView;

import com.service.ShangpinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 蛋糕信息
 * 后端接口
 */

@RestController
//控制器类，用于处理 HTTP 请求并返回 JSON 格式的数据
@RequestMapping("/shangpinxinxi")
//表示该控制器的所有接口路径都以 /shangpinxinxi 开头

public class ShangpinxinxiController {
    @Autowired
    //自动注入 ShangpinxinxiService 实例
    private ShangpinxinxiService shangpinxinxiService;
    


    /**
     * 后端列表
     * 根据请求参数params和实体类ShangpinxinxiEntity中的属性值进行查询
     * 返回查询结果的分页数据
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinxinxiEntity shangpinxinxi,
		HttpServletRequest request){
        EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
		PageUtils page = shangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     * 与前面接口功能一样，只是加上了 @IgnoreAuth 注解
     * 表示该接口不需要鉴权
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
        EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
		PageUtils page = shangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     * 根据ShangpinxinxiEntity实体类中的属性值进行查询
     * 并返回查询结果的List视图
     */
    @RequestMapping("/lists")
    public R list( ShangpinxinxiEntity shangpinxinxi){
       	EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinxinxi, "shangpinxinxi")); 
        return R.ok().put("data", shangpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     * 根据ShangpinxinxiEntity实体类中的属性值进行查询
     * 并返回查询结果的视图
     */
    @RequestMapping("/query")
    public R query(ShangpinxinxiEntity shangpinxinxi){
        EntityWrapper< ShangpinxinxiEntity> ew = new EntityWrapper< ShangpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinxinxi, "shangpinxinxi")); 
		ShangpinxinxiView shangpinxinxiView =  shangpinxinxiService.selectView(ew);
		return R.ok("查询蛋糕信息成功").put("data", shangpinxinxiView);
    }
	
    /**
     * 后端详情
     * 根据请求参数id查询蛋糕信息，并将蛋糕信息的点击次数和点击时间更新到数据库
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinxinxiEntity shangpinxinxi = shangpinxinxiService.selectById(id);
		shangpinxinxi.setClicknum(shangpinxinxi.getClicknum()+1);
		shangpinxinxi.setClicktime(new Date());
		shangpinxinxiService.updateById(shangpinxinxi);
        return R.ok().put("data", shangpinxinxi);
    }

    /**
     * 前端详情
     * 与前面接口功能一样
     * 加上了 @IgnoreAuth 注解，表示该接口不需要鉴权
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinxinxiEntity shangpinxinxi = shangpinxinxiService.selectById(id);
		shangpinxinxi.setClicknum(shangpinxinxi.getClicknum()+1);
		shangpinxinxi.setClicktime(new Date());
		shangpinxinxiService.updateById(shangpinxinxi);
        return R.ok().put("data", shangpinxinxi);
    }
    
    /**
     * 后端保存
     * 根据请求体中的ShangpinxinxiEntity实体类的属性值保存到数据库中
     * 在保存之前还会生成一个唯一的id
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
    	shangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinxinxi);
        shangpinxinxiService.insert(shangpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     * 添加蛋糕信息的请求映射
     * 接受HTTP请求并返回一个包含成功或失败信息的JSON数据
     * 使用了@RequestBody注解来将HTTP请求中的JSON数据映射到ShangpinxinxiEntity实体类中
     * 在方法体中，给商品信息实体类的id属性赋值
     * 使用了时间戳和随机数的方式生成一个唯一的id
     * 然后调用shangpinxinxiService的insert方法插入一条新的商品信息记录。
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
    	shangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinxinxi);
        shangpinxinxiService.insert(shangpinxinxi);
        return R.ok();
    }

    /**
     * 修改
     * 修改商品信息的请求映射
     * 接受HTTP请求并返回一个包含成功或失败信息的JSON数据
     * 同样使用了@RequestBody注解来将HTTP请求中的JSON数据映射到ShangpinxinxiEntity实体类中
     * 在方法体中，直接调用shangpinxinxiService的updateById方法更新商品信息记录。
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinxinxi);
        shangpinxinxiService.updateById(shangpinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除商品信息的请求映射
     * 接受HTTP请求并返回一个包含成功或失败信息的JSON数据
     * 使用了@RequestBody注解来将HTTP请求中的JSON数据映射到一个Long类型的数组中
     * 在方法体中，将数组转换成List类型并调用shangpinxinxiService的deleteBatchIds方法删除多条商品信息记录
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     * HTTP请求处理器，接受一个请求，对数据库中的记录进行查询，并返回查询结果的数量
     * 该方法使用Spring MVC框架的“@RequestMapping”注解进行路径映射
     * 并使用“@PathVariable”注解将URL路径中的参数值绑定到方法的参数中
     * 该方法还使用了Java中的日期和时间操作类“SimpleDateFormat”和“Calendar”，用于计算日期
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
		
		Wrapper<ShangpinxinxiEntity> wrapper = new EntityWrapper<ShangpinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = shangpinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     * HTTP请求处理器，用于实现前端的智能排序功能
     * 接收一个HTTP请求，并使用Spring MVC框架的“@RequestMapping”注解进行路径映射
     * 使用了一些Java集合类和字符串处理类，用于处理请求参数和构建查询条件
     * 调用“shangpinxinxiService”服务类的“queryPage”方法，查询并返回数据库记录的分页数据。
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = shangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinxinxi), params), params));
        return R.ok().put("data", page);
    }


}

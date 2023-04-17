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

import com.entity.AddressEntity;
import com.entity.view.AddressView;

import com.service.AddressService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * Java Spring Boot框架的地址管理系统的控制器类
 * 提供了对地址的CRUD操作
 */

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    


    /**
     * 后端列表
     * 分页查询所有地址，返回包含分页信息和地址列表的R对象
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AddressEntity address,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		address.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<AddressEntity> ew = new EntityWrapper<AddressEntity>();
		PageUtils page = addressService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, address), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     * 查询所有地址，返回包含地址列表的R对象
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AddressEntity address, HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		address.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<AddressEntity> ew = new EntityWrapper<AddressEntity>();
		PageUtils page = addressService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, address), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     * 根据地址属性查询地址，返回包含地址列表的R对象
     */
    @RequestMapping("/lists")
    public R list( AddressEntity address){
       	EntityWrapper<AddressEntity> ew = new EntityWrapper<AddressEntity>();
      	ew.allEq(MPUtil.allEQMapPre( address, "address")); 
        return R.ok().put("data", addressService.selectListView(ew));
    }

	 /**
     * 查询
     * 根据地址属性查询地址详细信息，返回包含地址详细信息的R对象
     */
    @RequestMapping("/query")
    public R query(AddressEntity address){
        EntityWrapper< AddressEntity> ew = new EntityWrapper< AddressEntity>();
 		ew.allEq(MPUtil.allEQMapPre( address, "address")); 
		AddressView addressView =  addressService.selectView(ew);
		return R.ok("查询地址成功").put("data", addressView);
    }
	
    /**
     * 后端详情
     * 根据地址ID查询地址详细信息，返回包含地址详细信息的R对象
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AddressEntity address = addressService.selectById(id);
        return R.ok().put("data", address);
    }

    /**
     * 前端详情
     * 根据地址ID查询地址详细信息，返回包含地址详细信息的R对象
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AddressEntity address = addressService.selectById(id);
        return R.ok().put("data", address);
    }
    
    /**
     * 后端保存
     * 新增地址，返回R.ok()
     */
    @RequestMapping("/save")
    public R save(@RequestBody AddressEntity address, HttpServletRequest request){
    	address.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(address);
    	address.setUserid((Long)request.getSession().getAttribute("userId"));
		Long userId = (Long)request.getSession().getAttribute("userId");
    	if(address.getIsdefault().equals("是")) {
    		addressService.updateForSet("isdefault='否'", new EntityWrapper<AddressEntity>().eq("userid", userId));
    	}
    	address.setUserid(userId);
        addressService.insert(address);
        return R.ok();
    }
    
    /**
     * 前端保存
     * 新增地址，返回R.ok()
     */
    @RequestMapping("/add")
    public R add(@RequestBody AddressEntity address, HttpServletRequest request){
    	address.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(address);
    	address.setUserid((Long)request.getSession().getAttribute("userId"));
		Long userId = (Long)request.getSession().getAttribute("userId");
    	if(address.getIsdefault().equals("是")) {
    		addressService.updateForSet("isdefault='否'", new EntityWrapper<AddressEntity>().eq("userid", userId));
    	}
    	address.setUserid(userId);
        addressService.insert(address);
        return R.ok();
    }

    /**
     * 修改
     * 更新地址信息，返回R.ok()
     */
    @RequestMapping("/update")
    public R update(@RequestBody AddressEntity address, HttpServletRequest request){
        //ValidatorUtils.validateEntity(address);
        if(address.getIsdefault().equals("是")) {
    		addressService.updateForSet("isdefault='否'", new EntityWrapper<AddressEntity>().eq("userid", request.getSession().getAttribute("userId")));
    	}
        addressService.updateById(address);//全部更新
        return R.ok();
    }
    
    /**
     * 获取默认地址
     * 获取用户默认地址信息，返回包含地址详细信息的R对象
     */
    @RequestMapping("/default")
    public R defaultAddress(HttpServletRequest request){
    	Wrapper<AddressEntity> wrapper = new EntityWrapper<AddressEntity>().eq("isdefault", "是").eq("userid", request.getSession().getAttribute("userId"));
        AddressEntity address = addressService.selectOne(wrapper);
        return R.ok().put("data", address);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //接收一个Long类型的数组作为参数
    //将这个数组转换为一个List，然后调用addressService对象的deleteBatchIds方法来批量删除这些ID对应的地址信息
    //最后返回一个"ok"的状态。
    public R delete(@RequestBody Long[] ids){
        addressService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		//remindCount方法用于处理提醒请求，接收三个参数：columnName表示查询的列名，type表示查询类型，map是一个包含查询条件的Map对象
		//map中包含remindstart和remindend两个参数，表示查询的起始时间和结束时间。
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			//如果type的值为2，那么它会根据remindstart和remindend参数计算出起始时间和结束时间，并将它们格式化为日期字符串放入map中。
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
		
		Wrapper<AddressEntity> wrapper = new EntityWrapper<AddressEntity>();
		//创建一个Wrapper对象来存储查询条件，并根据remindstart和remindend参数添加查询条件
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}
		//如果当前用户不是管理员，添加一个额外的查询条件：限制查询结果只包含当前用户的地址信息


		int count = addressService.selectCount(wrapper);
		return R.ok().put("count", count);
		//调用addressService对象的selectCount方法来查询符合条件的地址数量，并将数量以及一个"ok"的状态返回
	}
	


}

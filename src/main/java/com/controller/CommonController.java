package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ConfigEntity;
import com.service.CommonService;
import com.service.ConfigService;
import com.utils.BaiduUtil;
import com.utils.FileUtil;
import com.utils.R;

/**
 * 通用接口
 * REST API的端点
 * SpringBoot项目的通用接口控制器
 * 百度地图API获取城市信息、人脸比对、获取数据库表中的列值列表、根据表中的列获取单条记录
 */

@RestController
public class CommonController{

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ConfigService configService;
	
	private static AipFace client = null;
	
	private static String BAIDU_DITU_AK = null;
	
	@RequestMapping("/location")
	//接收两个参数lng和lat（分别为经度和纬度），并使用它们从百度地图API获取城市信息
	
	public R location(String lng,String lat) {
		if(BAIDU_DITU_AK==null) {
			BAIDU_DITU_AK = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "baidu_ditu_ak")).getValue();
			if(BAIDU_DITU_AK==null) {
				return R.error("请在配置管理中正确配置baidu_ditu_ak");
			}
		}
		Map<String, String> map = BaiduUtil.getCityByLonLat(BAIDU_DITU_AK, lng, lat);
		return R.ok().put("data", map);
	}
	
	/**
	 * 人脸比对
	 */
	@RequestMapping("/matchFace")
	//使用百度人脸识别API比较两张面部图像（由face1和face2参数指定），并返回匹配得分
	public R matchFace(String face1, String face2) {
		if(client==null) {
			/*String AppID = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "AppID")).getValue();*/
			String APIKey = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "APIKey")).getValue();
			String SecretKey = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "SecretKey")).getValue();
			String token = BaiduUtil.getAuth(APIKey, SecretKey);
			if(token==null) {
				return R.error("请在配置管理中正确配置APIKey和SecretKey");
			}
			client = new AipFace(null, APIKey, SecretKey);
			client.setConnectionTimeoutInMillis(2000);
			client.setSocketTimeoutInMillis(60000);
		}
		JSONObject res = null;
		try {
			File file1 = new File(ResourceUtils.getFile("classpath:static/upload").getAbsolutePath()+"/"+face1);
			File file2 = new File(ResourceUtils.getFile("classpath:static/upload").getAbsolutePath()+"/"+face2);
			String img1 = Base64Util.encode(FileUtil.FileToByte(file1));
			String img2 = Base64Util.encode(FileUtil.FileToByte(file2));
			MatchRequest req1 = new MatchRequest(img1, "BASE64");
			MatchRequest req2 = new MatchRequest(img2, "BASE64");
			ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
			requests.add(req1);
			requests.add(req2);
			res = client.match(requests);
			System.out.println(res.get("result"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return R.error("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return R.ok().put("data", com.alibaba.fastjson.JSONObject.parse(res.get("result").toString()));
	}
    
	/**
	 * 获取table表中的column列表(联动接口)
	 */
	@IgnoreAuth
	@RequestMapping("/option/{tableName}/{columnName}")
	public R getOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName,String level,String parent) {
		//此方法接收数据库表和列的名称，并返回该列的值列表。它用于根据数据库中的值创建下拉列表选项
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		if(StringUtils.isNotBlank(level)) {
			params.put("level", level);
		}
		if(StringUtils.isNotBlank(parent)) {
			params.put("parent", parent);
		}
		List<String> data = commonService.getOption(params);
		return R.ok().put("data", data);
	}
	
	/**
	 * 根据table中的column获取单条记录
	 */
	@IgnoreAuth
	@RequestMapping("/follow/{tableName}/{columnName}")
	public R getFollowByOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, @RequestParam String columnValue) {
		//根据table中的column获取单条记录
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		params.put("columnValue", columnValue);
		Map<String, Object> result = commonService.getFollowByOption(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * 修改table表的sfsh状态
	 * @return
	 */
	@RequestMapping("/sh/{tableName}")
	//映射HTTP请求到特定的URL以处理各种类型的数据请求
	public R sh(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map) {
		//sh方法用于更新数据库中表的sfsh状态。tableName路径变量用于指定要更新的表的名称
		map.put("table", tableName);
		//map参数用于传递其他参数，包括更新后的sfsh状态
		commonService.sh(map);
		return R.ok();
	}
	
	/**
	 * 获取需要提醒的记录数
	 * @param tableName
	 * @param columnName
	 * @param type 1:数字 2:日期
	 * @param map
	 * @return
	 */
	@IgnoreAuth
	//不需要身份验证即可访问
	@RequestMapping("/remind/{tableName}/{columnName}/{type}")
	//remindCount方法用于获取满足某些条件的记录数
	public R remindCount(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		//tableName、columnName和type路径变量分别用于指定要用于计算的表、列和数据类型。map参数用于传递指定计算开始和结束日期的其他参数
		map.put("table", tableName);
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
		
		int count = commonService.remindCount(map);
		return R.ok().put("count", count);
	}
	
	/**
	 * 单列求和
	 */
	@IgnoreAuth
	@RequestMapping("/cal/{tableName}/{columnName}")
	public R cal(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
		//cal方法用于对表进行单列计算
		//tableName和columnName路径变量分别用于指定要用于计算的表和列
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		Map<String, Object> result = commonService.selectCal(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * 分组统计
	 */
	@IgnoreAuth
	@RequestMapping("/group/{tableName}/{columnName}")
	public R group(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
		//group方法用于按特定列对表中的数据进行分组
		//tableName和columnName路径变量分别用于指定要用于分组的表和列。
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		List<Map<String, Object>> result = commonService.selectGroup(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * （按值统计）
	 */
	@IgnoreAuth
	@RequestMapping("/value/{tableName}/{xColumnName}/{yColumnName}")
	public R value(@PathVariable("tableName") String tableName, @PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName) {
		//value方法用于对表进行基于值的计算
		//tableName、xColumnName和yColumnName路径变量分别用于指定要用于计算的表、x列和y列
		//使用SimpleDateFormat格式化生成的数据，以在"yyyy-MM-dd"格式中显示日期
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("xColumn", xColumnName);
		params.put("yColumn", yColumnName);
		List<Map<String, Object>> result = commonService.selectValue(params);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Map<String, Object> m : result) {
			for(String k : m.keySet()) {
				if(m.get(k) instanceof Date) {
					m.put(k, sdf.format((Date)m.get(k)));
				}
			}
		}
		return R.ok().put("data", result);
	}
	
}

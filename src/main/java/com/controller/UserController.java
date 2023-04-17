
package com.controller;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.TokenEntity;
import com.entity.UserEntity;
import com.service.TokenService;
import com.service.UserService;
import com.utils.CommonUtil;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.ValidatorUtils;

/**
 * 登录相关
 */


@RequestMapping("users")
@RestController
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 * 处理用户登录请求，根据用户输入的用户名和密码
	 * 查询数据库中是否存在该用户，若不存在或密码不正确
	 * 则返回错误信息，否则生成token并返回给用户
	 */
	@IgnoreAuth
	@PostMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", username));
		if(user==null || !user.getPassword().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(),username, "users", user.getRole());
		return R.ok().put("token", token);
	}
	
	/**
	 * 注册
	 * 处理用户注册请求，先验证该用户名是否已存在
	 * 若存在则返回错误信息，否则将用户信息存入数据库
	 */
	@IgnoreAuth
	@PostMapping(value = "/register")
	public R register(@RequestBody UserEntity user){

    	if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("客户已存在");
    	}
        userService.insert(user);
        return R.ok();
    }

	/**
	 * 退出
	 * 处理用户退出请求，清空当前session并返回退出成功信息
	 */
	@GetMapping(value = "logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 密码重置
     * 处理用户密码重置请求，根据用户名查询数据库中是否存在该用户
     * 若不存在则返回错误信息，否则将密码重置为默认值“123456”
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setPassword("123456");
        userService.update(user,null);
        return R.ok("密码已重置为：123456");
    }
	
	/**
     * 列表
     * 处理用户列表分页请求，查询符合条件的用户列表并返回给用户
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,UserEntity user){
        EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
    	PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, user), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     * 处理用户列表请求，查询符合条件的用户列表并返回给用户
     */
    @RequestMapping("/list")
    public R list( UserEntity user){
       	EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
      	ew.allEq(MPUtil.allEQMapPre( user, "user")); 
        return R.ok().put("data", userService.selectListView(ew));
    }

    /**
     * 信息
     * 处理用户信息查询请求，根据用户id查询该用户信息并返回给用户
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        UserEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 获取客户的session客户信息
     * 处理获取当前登录用户信息请求，从session中获取当前用户id，并根据id查询该用户信息并返回给用户
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        UserEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 保存
     * 处理新增用户请求
     * 先验证该用户名是否已存在
     * 若存在则返回错误信息，否则将用户信息存入数据库
     */
    @PostMapping("/save")
    public R save(@RequestBody UserEntity user){
//    	ValidatorUtils.validateEntity(user);
    	if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("客户已存在");
    	}
        userService.insert(user);
        return R.ok();
    }

    /**
     * 修改
     * 处理更新用户请求，先根据用户名查询数据库中是否存在其他同名用户
     * 若存在则返回错误信息，否则更新该用户信息并返回成功信息
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserEntity user){
    	UserEntity u = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername()));
    	if(u!=null && u.getId()!=user.getId() && u.getUsername().equals(user.getUsername())) {
    		return R.error("客户名已存在。");
    	}
        userService.updateById(user);//全部更新
        return R.ok();
    }

    /**
     * 删除
     * 处理删除用户请求，根据用户id列表删除相应用户信息
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        userService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

package com.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/** 
 * 客户
 */
@TableName("users")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 表示用户ID
	 * 使用MyBatis-Plus框架注解@TableId表示主键
	 * 并设置为自增类型
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	
	/**
	 * 客户账号
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 客户类型
	 */
	private String role;
	
	private Date addtime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

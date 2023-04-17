package com.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/** 
 * token表
 */

@TableName("token")
public class TokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 序列化id，用于序列化和反序列化Java对象
	 */
	
	@TableId(type = IdType.AUTO)
	/**
	 * 表主键ID，使用自增长方式生成
	 */
	
	private Long id;
	
	/**
	 * 客户id
	 */
	private Long userid;
	
	/**
	 * 客户名
	 */
	private String username;
	
	/**
	 * 表名
	 */
	private String tablename;
	
	/**
	 * 角色
	 */
	private String role;
	
	/**
	 * token令牌信息
	 */
	private String token;
	
	/**
	 * 过期时间
	 */
	private Date expiratedtime;
	
	/**
	 * 新增时间
	 */
	private Date addtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiratedtime() {
		return expiratedtime;
	}

	public void setExpiratedtime(Date expiratedtime) {
		this.expiratedtime = expiratedtime;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TokenEntity(Long userid, String username, String tablename,String role, String token, Date expiratedtime) {
		/**
		 * 有参构造函数，用于创建一个具有上述成员变量的TokenEntity实例
		 */
		super();
		this.userid = userid;
		this.username = username;
		this.tablename = tablename;
		this.role = role;
		this.token = token;
		this.expiratedtime = expiratedtime;
	}
	
	public TokenEntity() {
		/**
		 * 无参构造函数
		 */
	}
	
}

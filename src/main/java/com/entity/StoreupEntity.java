package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 类用于实现各种功能
 * @TableId和@TableField注释类用于定义数据库表的字段
 * @JsonIgnoreProperties注释类用于指示Jackson JSON库在序列化对象时应忽略指定的属性。
 * 其他类包括日期格式化、验证、枚举类型等
 */
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 收藏表
 */

@TableName("storeup")
/**
 * 与数据库表storeup进行映射
 */
public class StoreupEntity<T> implements Serializable {
	/**
	 * 实现了Java的Serializable接口
	 * 可以将对象转换为字节流，方便在不同的JVM之间传递对象
	 */
	private static final long serialVersionUID = 1L;


	public StoreupEntity() {
		/**
		 * 空构造函数，没有参数
		 */
	}
	
	public StoreupEntity(T t) {
		/**
		 * 构造函数使用org.apache.commons.beanutils.BeanUtils类
		 * 将一个对象t的属性复制到StoreupEntity对象中
		 */
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 客户id
	 */
					
	private Long userid;
	
	/**
	 * 收藏id
	 */
					
	private Long refid;
	
	/**
	 * 表名
	 */
					
	private String tablename;
	
	/**
	 * 收藏名称
	 */
					
	private String name;
	
	/**
	 * 收藏图片
	 */
					
	private String picture;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

	
	private Date addtime;

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
	/**
	 * 设置：客户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：客户id
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：收藏id
	 */
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	/**
	 * 获取：收藏id
	 */
	public Long getRefid() {
		return refid;
	}
	/**
	 * 设置：表名
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	/**
	 * 获取：表名
	 */
	public String getTablename() {
		return tablename;
	}
	/**
	 * 设置：收藏名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：收藏名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：收藏图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：收藏图片
	 */
	public String getPicture() {
		return picture;
	}

}

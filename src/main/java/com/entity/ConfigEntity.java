package com.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 实现了Serializable接口
 * 可以被序列化为二进制流，用于在网络上传输或持久化到磁盘
*/

@TableName("config")
public class ConfigEntity implements Serializable{
private static final long serialVersionUID = 1L;
	//用于和数据库表config进行交互
    //其中包括表中的主键id，和非主键的name和value两个属性

	@TableId(type = IdType.AUTO)
	private Long id;
	
	/**
	 * key
	 */
	private String name;
	
	/**
	 * value
	 */
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}

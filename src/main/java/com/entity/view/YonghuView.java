package com.entity.view;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 客户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */

@TableName("yonghu")
/**
 * 映射的数据库表名为"yonghu"
 */

public class YonghuView  extends YonghuEntity implements Serializable {
	/**
	 * 序列化（将对象转换为字节序列）
	 * 以便在网络上传输或在不同的Java虚拟机之间传输
	 */
	private static final long serialVersionUID = 1L;

	public YonghuView(){
		/**
		 * 无参的构造方法
		 */	
	}
 
 	public YonghuView(YonghuEntity yonghuEntity){
		/**
		 * 使用BeanUtils.copyProperties方法将yonghuEntity的属性值复制到YonghuView类的属性中
		 * 将YonghuEntity实体转换为YonghuView视图实体
		 * 以便于在后端返回前端页面所需的数据
		 * 
		 * 
		 */	
 	try {
			BeanUtils.copyProperties(this, yonghuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

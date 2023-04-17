package com.entity.view;

import com.entity.ShangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 蛋糕信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */

@TableName("shangpinxinxi")
/**
 * 映射的数据库表名为"shangpinxinxi"
 */

public class ShangpinxinxiView  extends ShangpinxinxiEntity implements Serializable {
	/**
	 * 序列化（将对象转换为字节序列）
	 * 以便在网络上传输或在不同的Java虚拟机之间传输
	 */
	
	private static final long serialVersionUID = 1L;

	public ShangpinxinxiView(){
		/**
		 * 无参的构造方法
		 */		
	}
 
 	public ShangpinxinxiView(ShangpinxinxiEntity shangpinxinxiEntity){
		/**
		 * 带参数的构造方法
		 * 将`ShangpinxinxiEntity`对象复制到`ShangpinxinxiView`对象中
		 */		
 	try {
			BeanUtils.copyProperties(this, shangpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			/**
			 * 将`ShangpinxinxiEntity`对象中的属性值复制到`ShangpinxinxiView`对象中
			 * 如果复制过程中出现了异常，将在控制台上打印异常堆栈信息
			 */	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

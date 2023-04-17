package com.entity.view;

import com.entity.CartEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 购物车表
 * 视图实体的辅助类
 * 通常用于返回后端关联的表或自定义字段等信息
 * 注解来指定映射到数据库中的表名为"cart"
 */

@TableName("cart")
public class CartView  extends CartEntity implements Serializable {
	/**
	 * 序列化（将对象转换为字节序列）
	 * 以便在网络上传输或在不同的Java虚拟机之间传输
	 */
	
	private static final long serialVersionUID = 1L;

	public CartView(){
	}
 
 	public CartView(CartEntity cartEntity){
 		/**
 		 * 使用了"Apache Commons BeanUtils"库的"copyProperties"方法
 		 * 来将"cartEntity"对象的属性复制到"CartView"对象中
 		 * 如果复制属性的过程中发生异常
 		 * 将打印异常信息，但并不会中断程序的运行
 		 */
 	try {
			BeanUtils.copyProperties(this, cartEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

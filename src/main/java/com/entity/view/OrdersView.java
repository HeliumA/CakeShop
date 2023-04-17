package com.entity.view;

import com.entity.OrdersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 订单
 * 视图实体辅助类，通常用于后端接口返回数据给前端页面时，
把后端关联的多个表或自定义的字段信息进行合并，并以该类为模型返回
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */

@TableName("orders")
/**
 * 映射的数据库表名为"orders"
 */

public class OrdersView  extends OrdersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrdersView(){
		/**
		 * 默认构造函数，没有任何参数
		 */
	}
 
 	public OrdersView(OrdersEntity ordersEntity){
		/**
		 * 接收一个OrdersEntity类型的参数ordersEntity
		 * 使用Apache Commons BeanUtils工具类的copyProperties()方法
		 * 将ordersEntity中的属性值拷贝到当前对象中
		 */
 	try {
			BeanUtils.copyProperties(this, ordersEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			/**
			 * 如果存在IllegalAccessException
			 * 或InvocationTargetException异常，则打印出堆栈信息
			 */
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/**
	 * 通过调用这个构造函数
	 * 就可以把OrdersEntity对象的属性值拷贝到OrdersView对象中
	 * 从而使OrdersView对象具有OrdersEntity对象的所有属性
	 */
	}
}

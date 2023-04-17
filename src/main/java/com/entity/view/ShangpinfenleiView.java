package com.entity.view;

import com.entity.ShangpinfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 蛋糕分类
 * 通常被用作后端返回给前端的数据视图实体辅助类
 * 可以扩展ShangpinfenleiEntity类
 * 以便在需要自定义返回给前端的字段或关联表时使用
 * 可以快速地将数据库中查询出来的蛋糕分类数据封装成ShangpinfenleiView对象
 * 然后再将该对象返回给前端
 * 使用了MyBatis-Plus框架提供的TableName注解，指定了该实体类对应的数据库表名
 * 使得查询数据时可以自动匹配到正确的数据库表
 */

@TableName("shangpinfenlei")
/**
 * 映射的数据库表名为"shangpinfenlei"
 */

public class ShangpinfenleiView  extends ShangpinfenleiEntity implements Serializable {
	/**
	 * 序列化（将对象转换为字节序列）
	 * 以便在网络上传输或在不同的Java虚拟机之间传输
	 */
	
	private static final long serialVersionUID = 1L;

	public ShangpinfenleiView(){
		/**
		 * 无参的构造方法
		 */
	}
 
 	public ShangpinfenleiView(ShangpinfenleiEntity shangpinfenleiEntity){
 		/**
 		 * 有参的构造方法
 		 * 接收一个ShangpinfenleiEntity类型的参数
 		 * 使用BeanUtils.copyProperties()方法将该参数的属性值复制到当前实例的对应属性中
 		 */
 		try {
			BeanUtils.copyProperties(this, shangpinfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

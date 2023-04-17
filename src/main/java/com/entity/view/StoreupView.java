package com.entity.view;

import com.entity.StoreupEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 收藏表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("storeup")
/**
 * 映射的数据库表名为"storeup"
 */

public class StoreupView  extends StoreupEntity implements Serializable {
	/**
	 * 序列化（将对象转换为字节序列）
	 * 以便在网络上传输或在不同的Java虚拟机之间传输
	 */
	private static final long serialVersionUID = 1L;

	public StoreupView(){
		/**
		 * 无参的构造方法
		 */	
	}
 
 	public StoreupView(StoreupEntity storeupEntity){
		/**
		 * 将传入的StoreupEntity类型的对象拷贝到当前类的对象中
		 * 以便进行后续操作
		 * 使用了Apache Commons BeanUtils工具类的copyProperties方法
		 * 将storeupEntity对象的属性复制到当前对象中
		 */	
 	try {
			BeanUtils.copyProperties(this, storeupEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

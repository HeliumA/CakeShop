package com.entity.view;

import com.entity.AddressEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 地址
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */

@TableName("address")
public class AddressView  extends AddressEntity implements Serializable {
	/**
	 * 序列化（将对象转换为字节序列）
	 * 以便在网络上传输或在不同的Java虚拟机之间传输
	 */
	
	private static final long serialVersionUID = 1L;

	public AddressView(){
	/**
	* 无参构造函数
	*/		
	}
 
 	public AddressView(AddressEntity addressEntity){
 		/**
 		* 参数为AddressEntity类型的构造函数
 		* 通过BeanUtils.copyProperties()方法将AddressEntity
 		* 类型的对象的属性值复制到AddressView类型的对象中
 		*/	
 	try {
			BeanUtils.copyProperties(this, addressEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

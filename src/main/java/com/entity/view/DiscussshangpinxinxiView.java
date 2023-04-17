package com.entity.view;

import com.entity.DiscussshangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 蛋糕信息评论表
 * 使用了"Apache Commons BeanUtils"库的"copyProperties"方法
 * 来将"cartEntity"对象的属性复制到"CartView"对象中
 * 
 * 将"cartEntity"对象的属性值
 * 拷贝到"CartView"对象对应的同名属性中
 * 
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */

@TableName("discussshangpinxinxi")
public class DiscussshangpinxinxiView  extends DiscussshangpinxinxiEntity implements Serializable {
	/**
	 * 序列化（将对象转换为字节序列）
	 * 以便在网络上传输或在不同的Java虚拟机之间传输
	 */
	
	private static final long serialVersionUID = 1L;

	public DiscussshangpinxinxiView(){
	}
 
 	public DiscussshangpinxinxiView(DiscussshangpinxinxiEntity discussshangpinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussshangpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

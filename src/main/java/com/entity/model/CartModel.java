package com.entity.model;

import com.entity.CartEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 
/**
 * 购物车表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 */

public class CartModel  implements Serializable {
	/**
	 * 作为购物车表的实体类，在程序中用来接收传参
	 * Serializable接口的实现类，意味着该类的对象可以被序列化和反序列化
	 */
	
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 客户id
	 */
	
	private Long userid;
		
	/**
	 * 蛋糕id
	 */
	
	private Long goodid;
		
	/**
	 * 蛋糕名称
	 */
	
	private String goodname;
		
	/**
	 * 图片
	 */
	
	private String picture;
		
	/**
	 * 购买数量
	 */
	
	private Integer buynumber;
		
	/**
	 * 单价
	 */
	
	private Float price;
		
	/**
	 * 会员价
	 */
	
	private Float discountprice;
				
	
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
	 * 设置：蛋糕id
	 */
	 
	public void setGoodid(Long goodid) {
		this.goodid = goodid;
	}
	
	/**
	 * 获取：蛋糕id
	 */
	public Long getGoodid() {
		return goodid;
	}
				
	
	/**
	 * 设置：蛋糕名称
	 */
	 
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	
	/**
	 * 获取：蛋糕名称
	 */
	public String getGoodname() {
		return goodname;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：购买数量
	 */
	 
	public void setBuynumber(Integer buynumber) {
		this.buynumber = buynumber;
	}
	
	/**
	 * 获取：购买数量
	 */
	public Integer getBuynumber() {
		return buynumber;
	}
				
	
	/**
	 * 设置：单价
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：单价
	 */
	public Float getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：会员价
	 */
	 
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	
	/**
	 * 获取：会员价
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
			
}

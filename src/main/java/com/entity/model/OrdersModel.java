package com.entity.model;

import com.entity.OrdersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 订单模块的实体类，用于接收传参 
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 */

public class OrdersModel  implements Serializable {
	/**
	 * 这个类的实例可以序列化和反序列化
	 * 可以在分布式系统中进行网络传输
	 */
	
	/**
	 * Java中实现序列化的一个标志符
	 * 用于检查序列化的版本一致性
	 */
	private static final long serialVersionUID = 1L;

	
	
	 			
	/**
	 * 蛋糕表名
	 */
	
	private String tablename;
		
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
	 * 蛋糕图片
	 */
	
	private String picture;
		
	/**
	 * 购买数量
	 */
	
	private Integer buynumber;
		
	/**
	 * 价格/积分
	 */
	
	private Float price;
		
	/**
	 * 折扣价格
	 */
	
	private Float discountprice;
		
	/**
	 * 总价格/总积分
	 */
	
	private Float total;
		
	/**
	 * 折扣总价格
	 */
	
	private Float discounttotal;
		
	/**
	 * 支付类型
	 */
	
	private Integer type;
		
	/**
	 * 状态
	 */
	
	private String status;
		
	/**
	 * 地址
	 */
	
	private String address;
				
	
	/**
	 * 设置：蛋糕表名
	 */
	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * 获取：蛋糕表名
	 */
	public String getTablename() {
		return tablename;
	}
				
	
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
	 * 设置：蛋糕图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：蛋糕图片
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
	 * 设置：价格/积分
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格/积分
	 */
	public Float getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：折扣价格
	 */
	 
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	
	/**
	 * 获取：折扣价格
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
				
	
	/**
	 * 设置：总价格/总积分
	 */
	 
	public void setTotal(Float total) {
		this.total = total;
	}
	
	/**
	 * 获取：总价格/总积分
	 */
	public Float getTotal() {
		return total;
	}
				
	
	/**
	 * 设置：折扣总价格
	 */
	 
	public void setDiscounttotal(Float discounttotal) {
		this.discounttotal = discounttotal;
	}
	
	/**
	 * 获取：折扣总价格
	 */
	public Float getDiscounttotal() {
		return discounttotal;
	}
				
	
	/**
	 * 设置：支付类型
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取：支付类型
	 */
	public Integer getType() {
		return type;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
			
}

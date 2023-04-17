package com.entity.model;

import com.entity.DiscussshangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 表示蛋糕信息评论表的数据
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 */

public class DiscussshangpinxinxiModel  implements Serializable {
	/**
	 * 该类的对象可以被序列化（即在网络中传输、在硬盘中保存等操作）
	 */
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 客户id
	 */
	
	private Long userid;
		
	/**
	 * 客户名
	 */
	
	private String nickname;
		
	/**
	 * 评论内容
	 */
	
	private String content;
		
	/**
	 * 回复内容
	 */
	
	private String reply;
				
	
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
	 * 设置：客户名
	 */
	 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * 获取：客户名
	 */
	public String getNickname() {
		return nickname;
	}
				
	
	/**
	 * 设置：评论内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getReply() {
		return reply;
	}
			
}

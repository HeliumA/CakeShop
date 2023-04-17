package com.entity.vo;

import com.entity.DiscussshangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 蛋糕信息评论表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */

public class DiscussshangpinxinxiVO  implements Serializable {
	/**
	 * 序列化为二进制流，以便在网络上传输或保存在文件中
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

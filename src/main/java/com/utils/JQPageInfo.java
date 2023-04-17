package com.utils;

/**
 * 
 * 封装前端传来的查询参数，便于在后端进行相应的数据查询操作
 * 方便地获取和设置jQgrid分页组件的相关信息，从而实现分页查询功能
 */

public class JQPageInfo{
	
	//当前页码
	private Integer page;
	
	//每页显示的记录数
	private Integer limit;
	
	//排序字段
	private String sidx;
	
	//排序方式
	private String order;
	
	//当前页第一条记录的偏移量
	private  Integer offset;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
}

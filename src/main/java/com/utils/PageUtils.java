
package com.utils;
/**
 * 
 */
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * 分页工具类
 * 封装分页相关的数据
 * 方便对分页数据进行操作和传输
 * 当需要对分页数据进行封装时
 * 只需要创建一个 PageUtils 对象即可
 */

public class PageUtils implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//总记录数
	private long total;
	
	//每页记录数
	private int pageSize;
	
	//总页数
	private long totalPage;
	
	//当前页数
	private int currPage;
	
	//列表数据
	private List<?> list;
	
	/**
	 * 构造函数
	 * 根据列表数据、总记录数、每页记录数和当前页数构造一个分页对象
	 */
	public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.total = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}

	/**
	 * 根据 mybatis-plus 框架的分页对象构造一个分页对象
	 */
	public PageUtils(Page<?> page) {
		this.list = page.getRecords();
		this.total = page.getTotal();
		this.pageSize = page.getSize();
		this.currPage = page.getCurrent();
		this.totalPage = page.getPages();
	}
	
	/**
	 * 根据传入的参数构造一个空数据的分页对象
	 * 这个方法使用了另外一个名为 Query 的类
	 * 这个类的作用是根据传入的参数构造 mybatis-plus 框架的分页对象
	 */
	public PageUtils(Map<String, Object> params) {
 		Page page =new Query(params).getPage();
		new PageUtils(page);
	}

	/**
	 * 获取和设置每页记录数
	 */ 
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取和设置当前页数
	 */
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	/**
	 * 获取和设置当前页数
	 */
	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * 获取和设置总页数
	 */
	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 获取和设置总记录数
	 */
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
}

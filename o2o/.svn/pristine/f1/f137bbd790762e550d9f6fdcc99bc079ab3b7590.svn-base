package com.xjwfk.o2o.vo;

import java.util.List;

/**
 * @ClassName: PageBean
 * @Description: TODO(分页查询)
 * @author 白巾川
 * @date 2019年8月1日
 * @param <T>
 */
public class PageBean<T> {
	private int page; // 一共有多少页
	private int total; // 一共有条数据
	private int pageSize; // 当前第几页
	private List<T> rows; // 当前页要显示的数据

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageBean(int total, int pageSize, List<T> rows) {
		this.total = total;
		this.pageSize = pageSize;
		this.rows = rows;

		this.page = total % pageSize == 0 ? (total / pageSize) : (total / pageSize + 1);
	}

}

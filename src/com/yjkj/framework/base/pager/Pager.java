package com.yjkj.framework.base.pager;

import java.util.List;

public class Pager {

	private static final long serialVersionID = -3366308535140328396L;//序列组号
	private int pageNow = 1; //当前页码,默认为1
	private int pageSize = 10; //每页显示条数
	private int totalCount; //条目总数
	private int totalPages; //总页数
	private int offSet; //limit中起始位置
	private List<?> datas; //存储数据集
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPages = (this.totalCount%this.pageSize==0)?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize)+1;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getOffSet() {
		this.offSet = (this.pageNow-1)*this.pageSize;
		return offSet;
	}
	public void setOffSets(int offSet) {
		this.offSet = offSet;
	}
	public List<?> getDatas() {
		return datas;
	}
	public void setDatas(List<?> datas) {
		this.datas = datas;
	}
	public static long getSerialversionid() {
		return serialVersionID;
	}
	
	
	
	
}

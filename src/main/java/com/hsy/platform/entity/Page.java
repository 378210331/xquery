package com.hsy.platform.entity;

import java.io.Serializable;
import java.util.List;


/**
 * @author Gravity
 *
 */
public class Page implements Serializable{

	private int pageSize ; //每页显示记录数
	private int totalPage;		//总页数
	private int total;	//总记录数
	private int currentPage;	//当前页
	private int currentResult;	//当前记录起始索引
	private PageData pd = new PageData();
	private boolean hasNext;
	List rows ;//页面数据


	public Page(){
		this.pageSize =20;
		this.currentPage = 1;
	}


	public List getRows(){
		return this.rows;
	}

	public void setRows(List data){
		this.rows = data;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPage() {
		if(total%pageSize==0)
			totalPage = total/pageSize;
		else
			totalPage = total/pageSize+1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotal() {
		return total;
	}


	public void setTotal(int totalResult) {
		this.total = totalResult;
	}

	public int getCurrentPage() {
		if(currentPage<=0)currentPage =1;
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getCurrentResult() {
		currentResult = (getCurrentPage()-1)*getPageSize();
		if(currentResult<0)
			currentResult = 0;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public PageData getPd() {
		return pd;
	}

	public void setPd(PageData pd) {
		this.pd = pd;
	}

	public boolean isHasNext() {
		return currentResult+pageSize<total;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
}

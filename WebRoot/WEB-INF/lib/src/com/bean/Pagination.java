package com.bean;

public class Pagination {
	private int start;
	private int size;
	private int currentPage = 1;
	private int totalPage = 0;
	private int totalRecord;
	public Pagination(int size2) {
		this.setSize(size2);
	}
	public int getStart() {
		this.start = (currentPage-1)*size;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = totalRecord % size == 0?totalRecord / size:totalRecord/size+1;
	}
	

}

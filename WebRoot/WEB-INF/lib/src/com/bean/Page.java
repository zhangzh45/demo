package com.bean;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
	private List list;//Ҫ���ص�ĳһҳ�ļ�¼�б�
	
	private int allRow;//�ܼ�¼��
	private int totalPage;//��ҳ��
	private int currentPage;//��ǰҳ
	private int pageSize;//ÿҳ��¼��
	
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//�жϵ�ǰҳ����Ϣ
	public boolean isFirstPage() {
		return currentPage==1;//���ǰҳ�ǵ�һҳ
	}
	public boolean isLastPage() {
		return currentPage==totalPage;//���ǰҳ�����һҳ
	}
	public boolean isHasPreviousPage() {
		return currentPage!=1;//ֻҪ��ǰҲ���ǵ�һҳ
	}
	public boolean isHasNextPage() {
		return currentPage!=totalPage;//ֻҪ��ǰҳ�������һҳ
	}
	/*��ʼ����ҳ��Ϣ*/
	public void init(){
		this.isFirstPage=isFirstPage();
		this.isLastPage=isLastPage();
		this.hasPreviousPage=isHasPreviousPage();
		this.hasNextPage=isHasNextPage();
	}
	
	/*
	 * ������ҳ��̬���������ⲿֱ��ͨ���������
	 * @param pageSize ÿҳ��¼��
	 * @param allRow �ܼ�¼��
	 * @return ��ҳ��
	 */
	public static int countTotalPage(final int pageSize,final int allRow){
		int totalPage=allRow%pageSize==0?allRow/pageSize:allRow/pageSize+1;
		return totalPage;
	}
    
	/*
	 * ���㵱ǰҳ��ʼ��¼
	 * 
	 * @param pageSizeÿҳ��¼��
	 * @param currentPage ��ǰ�ڼ�ҳ
	 * @return ��ǰҳ��ʼ��¼��*/
	public static int countOffset(final int pageSize,final int currentPage){
		final int offset=pageSize*(countCurrentPage(currentPage)-1);
		return offset;
	}
	
	/*
	 * ���㵱ǰҳ����Ϊ0���������URL��û��"?page=",����1����
	 * @param page ����Ĳ������Ϊ�գ���0���򷵻�1��
	 * @return ��ǰҳ
	 */
	public static int countCurrentPage(int page){
		final int currentPage=(page==0?1:page);
		return currentPage;
	}
	
}

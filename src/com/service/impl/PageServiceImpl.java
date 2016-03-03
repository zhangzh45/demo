package com.service.impl;

import java.util.List;

import com.dao.PageDAO;
import com.model.Page;
import com.service.PageService;

public class PageServiceImpl implements PageService{
	private PageDAO pagedao;
	public void setPagedao(PageDAO pagedao) {
		this.pagedao = pagedao;
	}

	public Page queryForPage(String hqls, int pageSize, int page) {
		final String hql=hqls;//查询语句
		int allRow=pagedao.getAllRowCount(hql);//总记录数
		int totalPage=Page.countTotalPage(pageSize, allRow);//总页数
		final int offset=Page.countOffset(pageSize, page);//当前页开始记录
		final int length=pageSize;//每页记录数
		final int currentPage=Page.countCurrentPage(page);
		List<Page> list=pagedao.queryForPage(hql, offset, length);//"一页"的记录
		Page p=new Page();
		p.setPageSize(pageSize);
		p.setCurrentPage(currentPage);
		p.setAllRow(allRow);
		p.setTotalPage(totalPage);
		p.setList(list);
		p.init();
		return p;
	}

}

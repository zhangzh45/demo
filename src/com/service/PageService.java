package com.service;

import com.dao.PageDAO;
import com.model.Page;

public interface PageService {

	public abstract void setPagedao(PageDAO pagedao);

	/*
	 * 分页查询
	 * @@param currentPage当前第几页
	 * @@param pageSize 每页大小
	 * @@return 封闭了分页信息（包括记录集list）的entry
	 */
	public abstract Page queryForPage(String hqls, int pageSize, int page);

}
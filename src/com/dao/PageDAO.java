package com.dao;

import java.util.List;

public interface PageDAO {

	public abstract List queryForPage(final String hql, final int offset,
			final int length);

	public abstract int getAllRowCount(String hql);

}
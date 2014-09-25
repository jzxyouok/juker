package cn.juke.admin.dao;

import java.io.Serializable;

public interface GenericDao<T>
{
	T query(Serializable id);
	
	void create(T t);
	
	void delete(T t);
	
	void update(T t);
}

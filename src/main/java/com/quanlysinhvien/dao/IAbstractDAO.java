package com.quanlysinhvien.dao;

import java.util.List;

public interface IAbstractDAO<T> extends GenericDAO<T> {
	   	List<T> findAll();
	   	T findById(Long id);
	    Long insert(T t);
	    void update(T t);
	    void delete(Long id);
}

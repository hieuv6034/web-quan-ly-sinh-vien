package com.quanlysinhvien.dao;

import java.util.List;

import com.quanlysinhvien.model.DepartmentModel;

public interface IDepartmentDAO extends GenericDAO<DepartmentModel>{
	List<DepartmentModel> findAll();
	List<DepartmentModel> findByCode(String code);
	DepartmentModel findById (Long id);
}

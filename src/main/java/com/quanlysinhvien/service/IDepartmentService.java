package com.quanlysinhvien.service;

import java.util.List;

import com.quanlysinhvien.model.DepartmentModel;

public interface IDepartmentService {
	List<DepartmentModel> findAll();
	List<DepartmentModel> findByCode(String code);
	DepartmentModel findById (Long id);
}

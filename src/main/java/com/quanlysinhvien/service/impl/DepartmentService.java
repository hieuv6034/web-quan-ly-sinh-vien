package com.quanlysinhvien.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.quanlysinhvien.dao.IDepartmentDAO;
import com.quanlysinhvien.model.DepartmentModel;
import com.quanlysinhvien.service.IDepartmentService;

public class DepartmentService implements IDepartmentService{
	@Inject
	private IDepartmentDAO departmentDAO;

	@Override
	public List<DepartmentModel> findAll() {
		// TODO Auto-generated method stub
		return departmentDAO.findAll();
	}

	@Override
	public List<DepartmentModel> findByCode(String code) {
		// TODO Auto-generated method stub
		return departmentDAO.findByCode(code);
		
	}

	@Override
	public DepartmentModel findById(Long id) {
		// TODO Auto-generated method stub
		return departmentDAO.findById(id);
	}


}

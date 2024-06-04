package com.quanlysinhvien.dao.impl;

import java.util.List;

import com.quanlysinhvien.dao.IDepartmentDAO;
import com.quanlysinhvien.mapper.DepartmentMapper;
import com.quanlysinhvien.model.DepartmentModel;

public class DepartmentDAO extends AbstractDAO<DepartmentModel> implements IDepartmentDAO{

	@Override
	public List<DepartmentModel> findAll() {
		String sql = "SELECT * FROM chuyendecs.departments";
		return query(sql, new DepartmentMapper());
	}

	@Override
	public List<DepartmentModel> findByCode(String code) {
		StringBuilder sql = new StringBuilder("SELECT * FROM chuyendecs.departments ");
		sql.append("Where code = ?"); 
		List<DepartmentModel> departmentModels = query(sql.toString(), new DepartmentMapper(), code);
		return departmentModels.isEmpty() ? null : departmentModels;
	}

	@Override
	public DepartmentModel findById(Long id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM chuyendecs.departments ");
		sql.append("Where id = ?"); 
		List<DepartmentModel> departmentModels = query(sql.toString(), new DepartmentMapper(), id);
		return departmentModels.isEmpty() ? null : departmentModels.get(0);
	}
	
}

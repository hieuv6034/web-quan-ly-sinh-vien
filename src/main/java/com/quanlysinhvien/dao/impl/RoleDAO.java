package com.quanlysinhvien.dao.impl;

import java.util.List;

import com.quanlysinhvien.dao.IRoleDAO;
import com.quanlysinhvien.mapper.RoleMapper;
import com.quanlysinhvien.mapper.StudentMapper;
import com.quanlysinhvien.model.RoleModel;
import com.quanlysinhvien.model.StudentModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{

	@Override
	public RoleModel findByRoleId(Long id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM roles AS r");
		sql.append(" WHERE id = ? ");
        List<RoleModel> roleModels = query(sql.toString(), new RoleMapper(), id);
		return roleModels.isEmpty() ? null : roleModels.get(0);
	}

}
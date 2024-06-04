package com.quanlysinhvien.dao;

import com.quanlysinhvien.model.RoleModel;

import java.util.List;

public interface IRoleDAO extends GenericDAO<RoleModel>{
	RoleModel findByRoleId(Long id);
}

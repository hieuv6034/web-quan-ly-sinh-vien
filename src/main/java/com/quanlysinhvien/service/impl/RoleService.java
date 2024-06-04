package com.quanlysinhvien.service.impl;

import javax.inject.Inject;

import com.quanlysinhvien.dao.IRoleDAO;
import com.quanlysinhvien.model.RoleModel;
import com.quanlysinhvien.service.IRoleService;

public class RoleService implements IRoleService{
	@Inject
	private IRoleDAO roleDAO; 
	
	@Override
	public RoleModel findByRoleId(Long id) {
		// TODO Auto-generated method stub
		return roleDAO.findByRoleId(id);
	}
	


}

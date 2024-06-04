package com.quanlysinhvien.service.impl;

import javax.inject.Inject;

import com.quanlysinhvien.dao.IUserDAO;
import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.model.UserModel;
import com.quanlysinhvien.service.IRoleService;
import com.quanlysinhvien.service.IUserService;

import java.util.List;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	@Inject
	private IRoleService roleService;
	@Override
	public UserModel findByUserEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userDAO.findByUserEmailAndPassword(email, password);
	}
	@Override
	public List<UserModel> findAll() {
		return userDAO.findAll();
	}
}

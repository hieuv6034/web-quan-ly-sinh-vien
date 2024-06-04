package com.quanlysinhvien.dao;

import com.quanlysinhvien.model.UserModel;

import java.util.List;

public interface IUserDAO extends GenericDAO<UserModel>{
 	List<UserModel> findAll();
	public UserModel findByUserEmailAndPassword(String email, String password);
}

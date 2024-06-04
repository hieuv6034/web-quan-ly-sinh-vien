package com.quanlysinhvien.service;

import com.quanlysinhvien.model.UserModel;

import java.util.List;

public interface IUserService {
	UserModel findByUserEmailAndPassword(String email, String password);
	List<UserModel> findAll();
}

package com.quanlysinhvien.dao.impl;

import java.util.List;

import com.quanlysinhvien.dao.IUserDAO;
import com.quanlysinhvien.mapper.RoleMapper;
import com.quanlysinhvien.mapper.UserMapper;
import com.quanlysinhvien.model.RoleModel;
import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
		sql.append(" INNER JOIN roles AS r ON r.id = u.rolesid");
		sql.append(" WHERE email = ? AND password = ?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), email, password);
		return users.isEmpty() ? null : users.get(0);
	}
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM chuyendecs.users";
		List<UserModel> userModels = query(sql,new UserMapper() );
		return userModels;
	}
	public Long insert(UserModel userModel) {
		String sql = "INSERT INTO `chuyendecs`.`users` ( `name`, `email`, `password`, `rolesid`) VALUES(?,?,?,?)";
		return insert(sql, userModel.getName(), userModel.getEmail(), userModel.getPassword(),
				userModel.getRolesid());
	}
    
}

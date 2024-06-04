package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysinhvien.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{


	@Override
	public UserModel mapRow(ResultSet rs) {
		UserModel user = new UserModel();
		try {
			user.setId(rs.getLong("id"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setRolesid(rs.getLong("rolesid"));
			user.setCreatedat(rs.getTimestamp("createdat"));
			user.setUpdatedat(rs.getTimestamp("updatedat"));
			return user;
		} catch (SQLException e) {
			System.out.println("Lỗi ở UserMapper");
			return null;
		}

	}
	
}

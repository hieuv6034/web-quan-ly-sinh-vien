package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysinhvien.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel>{

	@Override
	public RoleModel mapRow(ResultSet rs) {
		try {
			RoleModel role = new RoleModel();
			role.setId(rs.getLong("id"));
			role.setRole_name(rs.getString("role_name"));
			role.setRole_symbol(rs.getString("role_symbol"));
			role.setCreatedat(rs.getTimestamp("createdat"));
			role.setUpdatedat(rs.getTimestamp("updatedat"));
			return role;
		} catch (SQLException e) {
			return null;
		}
	}
	 
}

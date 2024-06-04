package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysinhvien.model.DepartmentModel;

public class DepartmentMapper implements RowMapper<DepartmentModel>{

	@Override
	public DepartmentModel mapRow(ResultSet rs) {
		try {
			DepartmentModel department = new DepartmentModel();
			department.setId(rs.getLong("id"));
			department.setCode(rs.getString("code"));
			department.setName(rs.getString("name"));
			department.setCreatedat(rs.getTimestamp("createdat"));
			department.setUpdatedat(rs.getTimestamp("updatedat"));
			return department;
		} catch (SQLException e) {
			System.out.println("Lỗi ở DepartmentMapper");
			return null;
		}
	}
}

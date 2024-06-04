package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysinhvien.model.StudentModel;

public class StudentMapper implements RowMapper<StudentModel> {

	@Override
	public StudentModel mapRow(ResultSet rs) {
		
		try {
			StudentModel student = new StudentModel();
			student.setId(rs.getLong("id"));
			student.setCode(rs.getString("code"));
			student.setName(rs.getString("name"));
			student.setGender(rs.getString("gender"));
			student.setImage(rs.getString("image"));
			student.setLop(rs.getString("class"));
			student.setBank_number(rs.getString("bank_number"));
			student.setBank(rs.getString("bank"));
			student.setSchool_year_id(rs.getString("school_year_id"));
			student.setDob(rs.getString("dob"));
			student.setAddress(rs.getString("address"));
			student.setIdentify_number(rs.getString("identify_number"));
			student.setIdentify_date(rs.getString("identify_date"));
			student.setIdentify_address(rs.getString("identify_address"));
			student.setCreatedat(rs.getTimestamp("createdat"));
			student.setUpdatedat(rs.getTimestamp("updatedat"));
			student.setBirthday(rs.getString("birthday"));
			return student;
		} catch (SQLException e) {
			return null;
		}
	}
	 	
}

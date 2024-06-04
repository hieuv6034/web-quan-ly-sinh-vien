package com.quanlysinhvien.mapper;

import com.quanlysinhvien.model.Semester;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SemesterMapper implements RowMapper<Semester>{

	@Override
	public Semester mapRow(ResultSet rs) {
		try {
			Semester semester = new Semester();
			semester.setId(rs.getLong("id"));
			semester.setName(rs.getString("name"));
			semester.setStartDate(rs.getString("start_at"));
			semester.setEndDate(rs.getString("end_at"));
			return semester;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}

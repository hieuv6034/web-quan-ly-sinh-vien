package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysinhvien.model.SchoolyearModel;

public class SchoolyearMapper implements RowMapper<SchoolyearModel>{

	@Override
	public SchoolyearModel mapRow(ResultSet rs) {
		try {
			SchoolyearModel schoolyear = new SchoolyearModel();
			schoolyear.setId(rs.getLong("id"));
			schoolyear.setDisplay_name(rs.getString("display_name"));
			schoolyear.setStart(rs.getString("start"));
			schoolyear.setEnd(rs.getString("end"));
			schoolyear.setCreatedat(rs.getTimestamp("createdat"));
			schoolyear.setUpdatedat(rs.getTimestamp("updatedat"));
			return schoolyear;
		} catch (SQLException e) {
			return null;
		}
	}
	
}

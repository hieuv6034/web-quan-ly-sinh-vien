package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysinhvien.model.ClassroomModel;

public class ClassroomMapper implements RowMapper<ClassroomModel>{

	@Override
	public ClassroomModel mapRow(ResultSet rs) {
		
		try {
			ClassroomModel classroom = new ClassroomModel();
			classroom.setId(rs.getLong("id"));
			classroom.setCode(rs.getString("code"));
			classroom.setName(rs.getString("name"));
			classroom.setSubject_id(rs.getString("subject_id"));
			classroom.setTeacher_id(rs.getString("teacher_id"));
			classroom.setCourse_id(rs.getString("course_id"));
			classroom.setSemester_id(rs.getString("semester_id"));
			classroom.setCreatedat(rs.getTimestamp("createdat"));
			classroom.setUpdatedat(rs.getTimestamp("updatedat"));
			return classroom;
		} catch (SQLException e) {
			return null;
		}
	}
	
}

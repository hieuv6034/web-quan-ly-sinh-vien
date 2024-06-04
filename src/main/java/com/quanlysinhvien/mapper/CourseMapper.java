package com.quanlysinhvien.mapper;

import com.quanlysinhvien.model.Course;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs) {
		
		try {
			Course course = new Course();
			course.setId(rs.getLong("id"));
			course.setName(rs.getString("name"));
			course.setDepartmentId(rs.getLong("department_id"));
			course.setSemesterId(rs.getLong("semester_id"));
			course.setSubjectId(rs.getLong("subject_id"));
			return course;
		} catch (SQLException e) {
			return null;
		}
	}
	
}

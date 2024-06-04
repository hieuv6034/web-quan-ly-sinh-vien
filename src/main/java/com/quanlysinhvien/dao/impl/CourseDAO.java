package com.quanlysinhvien.dao.impl;

import com.quanlysinhvien.dao.ICourseDAO;
import com.quanlysinhvien.mapper.CourseMapper;
import com.quanlysinhvien.model.Course;
import com.quanlysinhvien.model.Semester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends AbstractDAO<Course> implements ICourseDAO {
    private Connection connection = MySQLConnection.getMySQLConnection();

    public List<Course> findAll(){
        String sql = "SELECT * FROM chuyendecs.courses";
        List<Course> courses = query(sql, new CourseMapper());
        return courses;
    }

    public Course findById(long id){
        String sql = "SELECT * FROM chuyendecs.courses WHERE id = ?";
        List<Course> courses = query(sql, new CourseMapper(), id);
        return courses.isEmpty() ? null : courses.get(0);
    }

}

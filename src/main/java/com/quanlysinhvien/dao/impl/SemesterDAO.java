package com.quanlysinhvien.dao.impl;

import com.quanlysinhvien.dao.ISemesterDAO;
import com.quanlysinhvien.mapper.SemesterMapper;
import com.quanlysinhvien.model.Course;
import com.quanlysinhvien.model.Semester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SemesterDAO extends AbstractDAO<Semester> implements ISemesterDAO {
    private Connection connection = MySQLConnection.getMySQLConnection();

    public List<Semester> findAll(){
        String sql = "SELECT * FROM chuyendecs.semesters;";
        List<Semester> semesters = query(sql, new SemesterMapper());
        return semesters;
    }

    public Semester findById(long id){
        String sql = "SELECT * FROM chuyendecs.semesters WHERE id = ?";
        List<Semester> semesters = query(sql, new SemesterMapper(), id);
        return semesters.isEmpty() ? null : semesters.get(0);
    }

}

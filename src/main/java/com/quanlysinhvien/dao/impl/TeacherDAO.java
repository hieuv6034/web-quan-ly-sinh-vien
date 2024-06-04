package com.quanlysinhvien.dao.impl;

import com.quanlysinhvien.dao.ITeacherDAO;
import com.quanlysinhvien.mapper.TeacherMapper;
import com.quanlysinhvien.model.TeacherModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO extends AbstractDAO<TeacherModel> implements ITeacherDAO {
    private Connection connection = MySQLConnection.getMySQLConnection();

    @Override
    public TeacherModel findById(Long id) {
        String sql ="SELECT * FROM chuyendecs.teachers WHERE id = ?";
        List<TeacherModel> teacherModels = query(sql, new TeacherMapper(), id);
        return teacherModels.isEmpty() ? null : teacherModels.get(0);
    }

    @Override
    public List<TeacherModel> findAll() {
        String sql ="SELECT * FROM chuyendecs.teachers;";
        List<TeacherModel> teacherModels = query(sql, new TeacherMapper());
        return teacherModels;
    }

    @Override
    public List<TeacherModel> search(Long department, String code) {
        String sql ="SELECT * FROM chuyendecs.teachers WHERE 1 = 1";
        if(department!= null && department > 0){
            sql += " AND department_id = "+ department;
        }
        if(code !=null && !code.isEmpty()){
            sql += " AND code = '" + code+"'";
        }
        List<TeacherModel> teacherModels = query(sql, new TeacherMapper(), department, code);
        return teacherModels;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM teachers WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TeacherModel teacherModel) {
        String sql = "UPDATE chuyendecs.teachers SET code = ?, lname = ?, fname = ?, image = ?, department_id = ?, gender = ?, phone = ?, dob = ?, email = ? WHERE id = ?";
        update(sql,teacherModel.getCode(),teacherModel.getLname(),teacherModel.getFname(),teacherModel.getImage(),teacherModel.getDepartment_id(),teacherModel.getGender(),teacherModel.getPhone()
        ,teacherModel.getDob(),teacherModel.getEmail(), teacherModel.getId());
    }

    @Override
    public Long insert(TeacherModel teacherModel) {
        String sql = "INSERT INTO `chuyendecs`.`teachers` ( `code`, `fname`, `image`, `department_id`, `gender`, `phone`, `dob`, `email`, `createdat`, `updatedat`, `lname`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        return insert(sql, teacherModel.getCode(), teacherModel.getFname(), teacherModel.getImage(),
                teacherModel.getDepartment_id(),teacherModel.getGender(),teacherModel.getPhone(),teacherModel.getDob(), teacherModel.getEmail(),
                teacherModel.getCreatedat(),teacherModel.getUpdatedat(),teacherModel.getLname());
    }
}

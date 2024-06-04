package com.quanlysinhvien.dao.impl;

import com.quanlysinhvien.dao.IStudentDAO;
import com.quanlysinhvien.mapper.StudentMapper;
import com.quanlysinhvien.mapper.TeacherMapper;
import com.quanlysinhvien.model.StudentModel;
import com.quanlysinhvien.model.TeacherModel;

import java.util.List;

public class StudentDAO extends AbstractDAO<StudentModel> implements IStudentDAO {

    @Override
    public StudentModel findById(Long id) {
        String sql = "SELECT * FROM chuyendecs.students WHERE id = ?";
        List<StudentModel> studentModels = query(sql, new StudentMapper(), id);
        return studentModels.isEmpty() ? null : studentModels.get(0);
    }

    @Override
    public List<StudentModel> findAll() {
        String sql = "SELECT * FROM chuyendecs.students;";
        List<StudentModel> studentModels = query(sql,new StudentMapper() );
        return studentModels;
    }

    @Override
    public List<StudentModel> search(String code,String name) {
        String sql ="SELECT * FROM chuyendecs.students WHERE 1 = 1";
        if(code !=null && !code.isEmpty()){
            sql += " AND code like '%" + code+"%'";
        }
        if(name !=null && !name.isEmpty()){
            sql += " AND name like '%" + name+"%'";
        }
        List<StudentModel> studentModels = query(sql, new StudentMapper(), code, name);
        return studentModels;
    }


    @Override
    public Long insert(StudentModel studentModel) {
        String sql ="INSERT INTO chuyendecs.students ( code, name, image, class, bank_number, bank, school_year_id, dob, address, identify_number, identify_date, identify_address, createdat, updatedat, birthday, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); " ;
        return insert(sql, studentModel.getCode(), studentModel.getName(), studentModel.getImage(), studentModel.getLop(), studentModel.getBank_number(),studentModel.getBank(),studentModel.getSchool_year_id(),studentModel.getDob(),studentModel.getAddress(),
                studentModel.getIdentify_number(),studentModel.getIdentify_date(),studentModel.getIdentify_address(),studentModel.getCreatedat(),studentModel.getUpdatedat(),studentModel.getBirthday(), studentModel.getGender());
    }

    @Override
    public void delete(Long id) {
        String sql = ("DELETE FROM `chuyendecs`.`students` WHERE id = ? ;");
        update(sql,id);
    }

    @Override
    public void update(StudentModel studentModel) {
        String sql = "UPDATE chuyendecs.students SET code = ?, name = ?, image = ?, class = ?, bank_number = ?, bank = ?, school_year_id = ?, dob = ?, address = ?, identify_number = ?, identify_date = ?, identify_address = ?, createdat = ?, updatedat = ?, birthday = ?, gender = ? WHERE id = ?;";
        update(sql , studentModel.getCode(), studentModel.getName(), studentModel.getImage() , studentModel.getLop(), studentModel.getBank_number(),studentModel.getBank(),studentModel.getSchool_year_id(),studentModel.getDob(),studentModel.getAddress(),studentModel.getIdentify_number(),studentModel.getIdentify_date(),studentModel.getIdentify_address(),studentModel.getCreatedat(),studentModel.getUpdatedat(),studentModel.getBirthday(),studentModel.getGender(),studentModel.getId());
    }
}

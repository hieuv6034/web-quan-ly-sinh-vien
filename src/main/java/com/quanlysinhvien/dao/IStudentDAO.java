package com.quanlysinhvien.dao;

import com.quanlysinhvien.model.StudentModel;
import com.quanlysinhvien.model.TeacherModel;

import java.util.List;

public interface IStudentDAO extends IAbstractDAO<StudentModel> {
    @Override
    List<StudentModel> findAll();
    List<StudentModel> search(String code, String name);
    @Override
    Long insert(StudentModel studentModel);

    @Override
    void delete(Long id);

    @Override
    void update(StudentModel studentModel);
}

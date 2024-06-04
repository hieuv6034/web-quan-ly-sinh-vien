package com.quanlysinhvien.service;

import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.model.respone.TeacherRespone;

import java.util.List;

public interface ITeacherService extends  IGenericService<TeacherModel> {
    List<TeacherRespone> findAll();

    List<TeacherRespone> search(Long department, String code);


    @Override
    Long insert(TeacherModel teacherModel);

    @Override
    void delete(Long id);

    @Override
    void update(TeacherModel teacherModel);
}

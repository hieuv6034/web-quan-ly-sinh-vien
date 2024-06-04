package com.quanlysinhvien.service;

import com.quanlysinhvien.model.StudentModel;
import com.quanlysinhvien.model.respone.StudentResponse;

import java.util.List;

public interface IStudentService extends  IGenericService<StudentModel>{
    List<StudentResponse> findAll();
    List<StudentResponse> search(String code, String name);
    @Override
    Long insert(StudentModel studentModel);

    @Override
    void delete(Long id);

    @Override
    void update(StudentModel studentModel);
}

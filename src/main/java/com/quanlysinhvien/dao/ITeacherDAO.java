package com.quanlysinhvien.dao;

import com.quanlysinhvien.dao.impl.TeacherDAO;
import com.quanlysinhvien.model.TeacherModel;

import java.util.List;

public interface ITeacherDAO extends IAbstractDAO<TeacherModel>
{
    @Override
    List<TeacherModel> findAll();
    List<TeacherModel> search(Long department, String code);

    @Override
    void delete(Long id);

    @Override
    void update(TeacherModel teacherModel);

    @Override
    Long insert(TeacherModel teacherModel);
}

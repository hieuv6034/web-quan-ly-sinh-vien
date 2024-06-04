package com.quanlysinhvien.dao;

import com.quanlysinhvien.model.Semester;

import java.util.List;

public interface ISemesterDAO extends GenericDAO<Semester>{
    List<Semester> findAll();
    Semester findById(long id);
}

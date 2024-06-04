package com.quanlysinhvien.dao;

import com.quanlysinhvien.model.Course;
import com.quanlysinhvien.model.Schedule;

import java.util.List;

public interface ICourseDAO extends GenericDAO<Course> {
    List<Course> findAll();
    Course findById(long id);
}

package com.quanlysinhvien.dao;

import com.quanlysinhvien.model.Schedule;

import java.util.List;

public interface IScheduleDAO extends GenericDAO<Schedule> {
    List<Schedule> findAll();
}

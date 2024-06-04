package com.quanlysinhvien.dao.impl;

import com.quanlysinhvien.dao.IScheduleDAO;
import com.quanlysinhvien.mapper.ScheduleMapper;
import com.quanlysinhvien.model.Course;
import com.quanlysinhvien.model.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO extends AbstractDAO<Schedule> implements IScheduleDAO {
    private Connection connection = MySQLConnection.getMySQLConnection();

    public Long insert(Schedule schedule) {
        String sql = "INSERT INTO chuyendecs.schedules (courses_id,semester_id,department_id,teacher_id,total_class, subject_id, name_class) VALUES (?,?,?,?,?,?,?)";
        return insert(sql, schedule.getCoursesId(),schedule.getSemesterId(), schedule.getDepartmentId(),schedule.getTeacherId()
        ,schedule.getTotalClass(),schedule.getSubjectId(),schedule.getNameClass());
    }

    public List<Schedule> findAll(){
        String sql = "SELECT * FROM chuyendecs.schedules";
        List<Schedule> schedules = query(sql, new ScheduleMapper());
        return schedules;
    }
}

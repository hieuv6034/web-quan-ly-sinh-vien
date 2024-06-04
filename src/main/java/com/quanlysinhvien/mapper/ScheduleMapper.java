package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.quanlysinhvien.model.Schedule;

public class ScheduleMapper implements RowMapper<Schedule>{

    @Override
    public Schedule mapRow(ResultSet rs) {

        try {
            Schedule schedule = new Schedule();
            schedule.setCoursesId(rs.getLong("courses_id"));
            schedule.setSemesterId(rs.getLong("semester_id"));
            schedule.setDepartmentId(rs.getLong("department_id"));
            schedule.setTeacherId(rs.getLong("teacher_id"));
            schedule.setTotalClass(rs.getLong("total_class"));
            schedule.setSubjectId(rs.getLong("subject_id"));
            schedule.setTotalClass(rs.getLong("total_class"));
            schedule.setNameClass(rs.getString("name_class"));
            return schedule;
        } catch (SQLException e) {
            return null;
        }
    }

}

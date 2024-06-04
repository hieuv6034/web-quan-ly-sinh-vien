package com.quanlysinhvien.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private long coursesId;
    private long semesterId;
    private long departmentId;
    private long teacherId;
    private long subjectId;
    private long totalClass;
    private String nameClass;
}

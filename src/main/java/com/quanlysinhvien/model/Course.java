package com.quanlysinhvien.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private long id;
    private String name;
    private Long departmentId;
    private Long subjectId;
    private Long semesterId;
}

package com.quanlysinhvien.model.respone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private String courses;
    private String semester;
    private String department;
    private String teacher;
    private String subject;
    private long totalClass;
    private String nameClass;
}

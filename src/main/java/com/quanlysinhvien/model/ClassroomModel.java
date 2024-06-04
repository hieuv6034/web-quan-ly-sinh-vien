package com.quanlysinhvien.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class ClassroomModel extends AbstractModel<ClassroomModel>{
	private String code;
	private String name;
	private String subject_id;
	private String teacher_id;
	private String course_id;
	private String semester_id;

}

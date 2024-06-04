package com.quanlysinhvien.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TeacherModel extends AbstractModel<TeacherModel>{
	private String code;
	private String lname;
	private String fname;
	private String image;
	private Long department_id;
	private String gender;
	private String phone;
	private String dob;
	private String email;

}

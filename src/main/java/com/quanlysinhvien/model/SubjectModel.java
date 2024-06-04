package com.quanlysinhvien.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class SubjectModel extends AbstractModel<SubjectModel>{
	private String code; //Mã học phần
	private String name; // Tên môn
	private Integer alls; // Tổng số tiết
	private Integer theory; //Lý thuyết
	private Integer practice; //Thực hành
	private Integer exercise; //Bài tập
	private Long department_id;	//id Khoa
	private Integer course_load; // Tín chỉ
	private Integer semester;
}

package com.quanlysinhvien.model.respone;

import com.quanlysinhvien.model.AbstractModel;

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
public class SubjectRespone extends AbstractModel<SubjectRespone> {
	private String code; //Mã học phần
	private String name; // Tên môn
	private Integer alls; // Tổng số tiết
	private Integer theory; //Lý thuyết
	private Integer practice; //Thực hành
	private Integer exercise; //Bài tập
	private String department_name;	//id Khoa
	private Integer course_load; // Tín chỉ
}

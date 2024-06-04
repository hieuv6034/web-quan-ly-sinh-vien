package com.quanlysinhvien.service;

import java.util.List;

import com.quanlysinhvien.model.SubjectModel;
import com.quanlysinhvien.model.respone.SubjectRespone;
import com.quanlysinhvien.model.respone.TeacherRespone;

public interface ISubjectService extends IGenericService<SubjectModel>{
	List<SubjectRespone> findAll();
	List<SubjectRespone> search(Long department);
	List<SubjectModel> findByDeparment_id(Long deparmentid);
	SubjectModel findById(Long id);
	@Override
	Long insert(SubjectModel subjectModel);

	@Override
	void update(SubjectModel subjectModel);

	@Override
	void delete(Long id);
}

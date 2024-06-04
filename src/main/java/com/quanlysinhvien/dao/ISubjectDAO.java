package com.quanlysinhvien.dao;

import java.util.List;

import com.quanlysinhvien.model.SubjectModel;
import com.quanlysinhvien.model.TeacherModel;

public interface ISubjectDAO extends IAbstractDAO<SubjectModel>{

	SubjectModel findById(Long id);

	List<SubjectModel> findByDepartment_id(Long department_id);
	Long insert(SubjectModel subjectModel);
	void delete(Long id);
	void update(SubjectModel subjectModel);
	List<SubjectModel> search(Long department);
}

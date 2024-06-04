package com.quanlysinhvien.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;

import com.quanlysinhvien.dao.ISubjectDAO;
import com.quanlysinhvien.model.SubjectModel;
import com.quanlysinhvien.model.respone.SubjectRespone;
import com.quanlysinhvien.service.IDepartmentService;
import com.quanlysinhvien.service.ISubjectService;

public class SubjectService implements ISubjectService{
	@Inject
	private ISubjectDAO subjectDAO;
	@Inject
	private IDepartmentService departmentService;

	@Override
	public List<SubjectModel> findByDeparment_id(Long deparmentid) {
		// TODO Auto-generated method stub
		return subjectDAO.findByDepartment_id(deparmentid);
	}

	@Override
	public List<SubjectRespone> findAll() {
		// TODO Auto-generated method stub
		List<SubjectRespone> subjectRespones = new ArrayList<>();
		List<SubjectModel> subjectModels = subjectDAO.findAll();
		for (SubjectModel subjectModel : subjectModels) {
			SubjectRespone subjectRespone = new SubjectRespone();
			try {
				BeanUtils.copyProperties(subjectRespone, subjectModel);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				System.out.println("Lỗi ở SubjectService");
				e.printStackTrace();
			}
			subjectRespone.setDepartment_name(departmentService.findById(subjectModel.getDepartment_id()).getName());
			subjectRespones.add(subjectRespone);
		}
		return subjectRespones;
	}

	@Override
	public List<SubjectRespone> search(Long department) {
		List<SubjectRespone> subjectRespones = new ArrayList<>();
		List<SubjectModel> subjectModels = subjectDAO.search(department);
		for (SubjectModel subjectModel : subjectModels) {
			SubjectRespone subjectRespone = new SubjectRespone();
			try {
				BeanUtils.copyProperties(subjectRespone, subjectModel);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				System.out.println("Lỗi ở SubjectService");
				e.printStackTrace();
			}
			subjectRespone.setDepartment_name(departmentService.findById(subjectModel.getDepartment_id()).getName());
			subjectRespones.add(subjectRespone);
		}
		return subjectRespones;
	}


	@Override
	public Long insert(SubjectModel subjectModel) {
		// TODO Auto-generated method stub
		 subjectDAO.insert(subjectModel);
		return null;
	}

	@Override
	public void delete(Long id) {
		 subjectDAO.delete(id);
	}

	@Override
	public void update(SubjectModel subjectModel) {
		// TODO Auto-generated method stub
		 subjectDAO.update(subjectModel);
	}

	@Override
	public SubjectModel findById(Long id) {
		// TODO Auto-generated method stub
		return subjectDAO.findById(id);
	}




}

package com.quanlysinhvien.service.impl;

import com.quanlysinhvien.dao.IStudentDAO;
import com.quanlysinhvien.dao.impl.StudentDAO;
import com.quanlysinhvien.model.StudentModel;
import com.quanlysinhvien.model.respone.StudentResponse;
import com.quanlysinhvien.model.respone.ScheduleResponse;
import com.quanlysinhvien.service.IStudentService;
import com.quanlysinhvien.service.ISubjectService;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    @Inject
    private IStudentDAO studentDAO;

    @Override
    public List<StudentResponse> findAll() {
        List<StudentResponse> studentResponses = new ArrayList<>();
        List<StudentModel> studentModels = studentDAO.findAll();
        for(StudentModel studentModel : studentModels){
            StudentResponse studentResponse = new StudentResponse();
            try{
                BeanUtils.copyProperties(studentResponse, studentModel);
            }catch (IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
            if(studentModel.getGender().equals("1")){
                studentResponse.setGender("Nam");
            }
            else if(studentModel.getGender().equals("2")){
                studentResponse.setGender("Nữ");
            }
            studentResponses.add(studentResponse);
        }
        return studentResponses;
    }

    @Override
    public List<StudentResponse> search(String code, String name) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        List<StudentModel> studentModels = studentDAO.search(code, name);
        for(StudentModel studentModel : studentModels){
            StudentResponse studentResponse = new StudentResponse();
            try{
                BeanUtils.copyProperties(studentResponse, studentModel);
            }catch (IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
            if(studentModel.getGender().equals("1")){
                studentResponse.setGender("Nam");
            }
            else if(studentModel.getGender().equals("2")){
                studentResponse.setGender("Nữ");
            }
            studentResponses.add(studentResponse);
        }
        return studentResponses;
    }


    @Override
    public Long insert(StudentModel studentModel) {
        return studentDAO.insert(studentModel);
    }

    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public void update(StudentModel studentModel) {
        studentDAO.update(studentModel);
    }


}

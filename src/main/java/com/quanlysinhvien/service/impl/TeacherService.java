package com.quanlysinhvien.service.impl;

import com.quanlysinhvien.dao.ITeacherDAO;
import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.model.respone.TeacherRespone;
import com.quanlysinhvien.service.IDepartmentService;
import com.quanlysinhvien.service.ITeacherService;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService {
    @Inject
    private ITeacherDAO teacherDAO;
    @Inject
    private IDepartmentService departmentService;

    @Override
    public List<TeacherRespone> findAll() {
        List<TeacherRespone> teacherRespones = new ArrayList<>();
        List<TeacherModel> teacherModels = teacherDAO.findAll();
            for(TeacherModel teacherModel : teacherModels){
            TeacherRespone teacherRespone = new TeacherRespone();
            try{
                    BeanUtils.copyProperties(teacherRespone, teacherModel);
                }catch (IllegalAccessException | InvocationTargetException e){
                    e.printStackTrace();
                }
                teacherRespone.setDepartment_name(departmentService.findById(teacherModel.getDepartment_id()).getName());
            if(teacherModel.getGender().equals("1")){
                teacherRespone.setGender("Nam");
            }
            else if(teacherModel.getGender().equals("2")){
                teacherRespone.setGender("Nữ");
            }

                teacherRespones.add(teacherRespone);
            }
        return teacherRespones;
    }

    @Override
    public List<TeacherRespone> search(Long department, String code) {
        List<TeacherRespone> teacherRespones = new ArrayList<>();
        List<TeacherModel> teacherModels = teacherDAO.search(department, code);
        for(TeacherModel teacherModel : teacherModels){
            TeacherRespone teacherRespone = new TeacherRespone();
            try{
                BeanUtils.copyProperties(teacherRespone, teacherModel);
            }catch (IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
            teacherRespone.setDepartment_name(departmentService.findById(teacherModel.getDepartment_id()).getName());
            if(teacherModel.getGender().equals("1")){
                teacherRespone.setGender("Nam");
            }
            else if(teacherModel.getGender().equals("2")){
                teacherRespone.setGender("Nữ");
            }

            teacherRespones.add(teacherRespone);
        }
        return teacherRespones;
    }

    @Override
    public Long insert(TeacherModel teacherModel) {

        return teacherDAO.insert(teacherModel);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(TeacherModel teacherModel) {

    }
}

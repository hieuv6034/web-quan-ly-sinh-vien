package com.quanlysinhvien.controller.admin.qldt.tkb;

import com.quanlysinhvien.dao.impl.*;
import com.quanlysinhvien.model.Schedule;
import com.quanlysinhvien.model.respone.ScheduleResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/qldt/tkb/dstkb"})
public class ListScheduleController extends HttpServlet {
    private SemesterDAO semesterDAO = new SemesterDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Schedule> schedules = scheduleDAO.findAll();
        List<ScheduleResponse> scheduleResponseList = new ArrayList<>();

        for (Schedule schedule : schedules){
            scheduleResponseList.add(new ScheduleResponse(
                    courseDAO.findById(schedule.getCoursesId()) == null ? null : courseDAO.findById(schedule.getCoursesId()).getName(),
                    semesterDAO.findById(schedule.getSemesterId()) == null ? null : semesterDAO.findById(schedule.getSemesterId()).getName(),
                    departmentDAO.findById(schedule.getDepartmentId()) == null ? null : departmentDAO.findById(schedule.getDepartmentId()).getName(),
                    teacherDAO.findById(schedule.getTeacherId()) == null  ? null: teacherDAO.findById(schedule.getTeacherId()).getFname() + " " + teacherDAO.findById(schedule.getTeacherId()).getLname(),
                    subjectDAO.findById(schedule.getSubjectId()) == null ? null : subjectDAO.findById(schedule.getSubjectId()).getName(),
                    schedule.getTotalClass(),schedule.getNameClass()
            ));
        }

        req.setAttribute("schedules", scheduleResponseList);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/tkb/list-tkb.jsp");
        rd.forward(req, resp);

    }
}

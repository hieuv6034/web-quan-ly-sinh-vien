package com.quanlysinhvien.controller.admin.qldt.tkb;

import com.quanlysinhvien.dao.impl.*;
import com.quanlysinhvien.model.Schedule;
import com.quanlysinhvien.model.respone.ScheduleResponse;
import com.quanlysinhvien.model.respone.TeacherRespone;
import com.quanlysinhvien.service.ITeacherService;
import com.quanlysinhvien.util.ExcelExporterSchedule;
import com.quanlysinhvien.util.ExcelExporterTeacher;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/qldt/tkb/export-schedule"})
public class ExportScheduleController extends HttpServlet {
    private SemesterDAO semesterDAO = new SemesterDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Schedule> schedules = scheduleDAO.findAll();
        List<ScheduleResponse> scheduleResponseList = new ArrayList<>();

        for (Schedule schedule : schedules){
            scheduleResponseList.add(new ScheduleResponse(
                    courseDAO.findById(schedule.getCoursesId()) == null ? null : courseDAO.findById(schedule.getCoursesId()).getName(),
                    semesterDAO.findById(schedule.getSemesterId()) == null ? null : semesterDAO.findById(schedule.getSemesterId()).getName(),
                    departmentDAO.findById(schedule.getDepartmentId()) == null ? null : departmentDAO.findById(schedule.getDepartmentId()).getName(),
                    teacherDAO.findById(schedule.getTeacherId()) == null ? null : teacherDAO.findById(schedule.getTeacherId()).getFname() + " " + teacherDAO.findById(schedule.getTeacherId()).getLname(),
                    subjectDAO.findById(schedule.getSubjectId()) == null ? null :subjectDAO.findById(schedule.getSubjectId()).getName(),
                    schedule.getTotalClass(), schedule.getNameClass()
            ));
        }
        resp.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=schedule_" + currentDateTime + ".xlsx";
        resp.setHeader(headerKey, headerValue);

        ExcelExporterSchedule excelExporter = new ExcelExporterSchedule(scheduleResponseList);
        excelExporter.export(resp);
    }
}

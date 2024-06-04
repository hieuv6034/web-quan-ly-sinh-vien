package com.quanlysinhvien.controller.admin.qldt.tkb;

import com.quanlysinhvien.dao.impl.*;
import com.quanlysinhvien.model.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/qldt/tkb/ltkb"})
public class LapLich_LtkbController extends HttpServlet{
	private SemesterDAO semesterDAO = new SemesterDAO();
	private DepartmentDAO departmentDAO = new DepartmentDAO();
	private CourseDAO courseDAO = new CourseDAO();
	private TeacherDAO teacherDAO = new TeacherDAO();
	private ScheduleDAO scheduleDAO = new ScheduleDAO();
	private SubjectDAO subjectDAO = new SubjectDAO();

	/**
	 * 
	 */
	private static final long serialVersionUID = 3461613811928964367L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		List<Semester> semesters = semesterDAO.findAll();
		req.setAttribute("semesters", semesters);
		List<DepartmentModel> departmentModels = departmentDAO.findAll();
		req.setAttribute("departments", departmentModels);
		List<Course> courses = courseDAO.findAll();
		req.setAttribute("courses", courses);
		List<TeacherModel> teacherModels = teacherDAO.findAll();
		req.setAttribute("teachers", teacherModels);
		List<SubjectModel> subjectModels = subjectDAO.findAll();
		req.setAttribute("subjects", subjectModels);
    	RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/tkb/ltkb.jsp");
		rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		Long courseId = Long.parseLong(req.getParameter("courses_id"));
		Long departmentId = Long.parseLong(req.getParameter("department_id"));
		Long semesterId = Long.parseLong(req.getParameter("semester_id"));
		Long teacherId = Long.parseLong(req.getParameter("teacher_id"));
		Long totalClass = Long.parseLong(req.getParameter("total_class"));
		Long subjectId = Long.parseLong(req.getParameter("subject_id"));
 		String nameClass = req.getParameter("name_class");
		Schedule schedule = new Schedule(courseId,semesterId,departmentId,teacherId,subjectId, totalClass, nameClass);
		scheduleDAO.insert(schedule);
		resp.sendRedirect(req.getContextPath() + "/admin/qldt/tkb/dstkb");
    }
    
}
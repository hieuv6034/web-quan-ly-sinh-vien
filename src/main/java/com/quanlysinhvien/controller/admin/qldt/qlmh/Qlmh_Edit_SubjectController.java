package com.quanlysinhvien.controller.admin.qldt.qlmh;

import com.quanlysinhvien.constant.SystemConstant;
import com.quanlysinhvien.dao.impl.DepartmentDAO;
import com.quanlysinhvien.model.SubjectModel;
import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.model.respone.SubjectRespone;
import com.quanlysinhvien.service.ISubjectService;
import com.quanlysinhvien.util.FormUtil;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/qldt/qlmh/edit-subject"})
public class Qlmh_Edit_SubjectController extends HttpServlet{
 	@Inject
	private ISubjectService subjectService;
	private DepartmentDAO departmentDAO = new DepartmentDAO();
	/**
	 * 
	 */
	private static final long serialVersionUID = 3461613811928964367L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		req.setAttribute("subject",subjectService.findById(id));
		req.setAttribute("departments", departmentDAO.findAll());
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/qlm/edit-subject.jsp");
		rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		SubjectModel subjectModel = FormUtil.toModel(SubjectModel.class, req);
		subjectService.update(subjectModel);
		resp.sendRedirect(req.getContextPath() + "/admin/qldt/qlmh/list-subject");
    }
    
}
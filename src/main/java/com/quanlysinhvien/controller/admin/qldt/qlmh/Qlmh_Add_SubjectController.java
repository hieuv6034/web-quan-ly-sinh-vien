package com.quanlysinhvien.controller.admin.qldt.qlmh;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quanlysinhvien.constant.SystemConstant;
import com.quanlysinhvien.model.DepartmentModel;
import com.quanlysinhvien.model.SubjectModel;
import com.quanlysinhvien.service.IDepartmentService;
import com.quanlysinhvien.service.ISubjectService;
import com.quanlysinhvien.util.FormUtil;

@WebServlet(urlPatterns = {"/admin/qldt/qlmh/add-subject"})
public class Qlmh_Add_SubjectController extends HttpServlet{

	@Inject
	private ISubjectService subjectService;
	@Inject
	private IDepartmentService departmentService;
	
	private static final long serialVersionUID = 3461613811928964367L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	DepartmentModel departmentModel = new DepartmentModel();
    	departmentModel.setListResult(departmentService.findAll());
    	req.setAttribute(SystemConstant.MODEL+"department",departmentModel );
    	RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/qlm/add-subject.jsp");
		rd.forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
    	SubjectModel subjectModel = FormUtil.toModel(SubjectModel.class, req);
    	Long status = subjectService.insert(subjectModel);
		if(status == null){
			req.setAttribute("status", "faile");
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/qlm/add-subject.jsp");
			rd.forward(req, resp);
			return;
		}
		req.setAttribute("status", "success");
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/qlm/add-subject.jsp");
		rd.forward(req, resp);
    	resp.sendRedirect(req.getContextPath() + "admin/qldt/qlm/add-subject.jsp");
    }
    
}
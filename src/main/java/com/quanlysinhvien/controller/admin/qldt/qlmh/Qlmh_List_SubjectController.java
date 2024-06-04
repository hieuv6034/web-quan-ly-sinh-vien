package com.quanlysinhvien.controller.admin.qldt.qlmh;

import java.io.IOException;
import java.util.List;

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
import com.quanlysinhvien.model.respone.SubjectRespone;
import com.quanlysinhvien.service.IDepartmentService;
import com.quanlysinhvien.service.ISubjectService;
import com.quanlysinhvien.util.FormUtil;

@WebServlet(urlPatterns = {"/admin/qldt/qlmh/list-subject"})
public class Qlmh_List_SubjectController extends HttpServlet{
	@Inject
	private ISubjectService subjectService;
	@Inject
	private IDepartmentService departmentService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3461613811928964367L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		DepartmentModel departmentModel = new DepartmentModel();
		departmentModel.setListResult(departmentService.findAll());
		req.setAttribute(SystemConstant.MODEL + "department", departmentModel);
		Long department = req.getParameter("department_id") == null ? null : Long.parseLong(req.getParameter("department_id"));


		SubjectRespone subjectRespone = FormUtil.toModel(SubjectRespone.class, req);
		subjectRespone.setListResult(subjectService.search(department));
		req.setAttribute(SystemConstant.MODEL+"subject",subjectRespone );
    	RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/qlm/list-subject.jsp");
		rd.forward(req, resp);
    }
}
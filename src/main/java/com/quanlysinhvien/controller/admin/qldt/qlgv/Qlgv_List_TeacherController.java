package com.quanlysinhvien.controller.admin.qldt.qlgv;

import com.quanlysinhvien.constant.SystemConstant;
import com.quanlysinhvien.dao.impl.TeacherDAO;
import com.quanlysinhvien.model.DepartmentModel;
import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.model.respone.TeacherRespone;
import com.quanlysinhvien.service.IDepartmentService;
import com.quanlysinhvien.service.ITeacherService;
import com.quanlysinhvien.util.FormUtil;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/qldt/qlgv/list-teacher"})
public class Qlgv_List_TeacherController extends HttpServlet {
    @Inject
    private ITeacherService teacherService;
    @Inject
    private IDepartmentService departmentService;
    private TeacherDAO teacherDAO = new TeacherDAO();
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
        String code = req.getParameter("code");

        TeacherRespone teacherRespone = FormUtil.toModel(TeacherRespone.class, req);
        teacherRespone.setListResult(teacherService.search(department, code));
        req.setAttribute(SystemConstant.MODEL + "teacher", teacherRespone);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/qlgv/list-teacher.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
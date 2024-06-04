package com.quanlysinhvien.controller.admin.qldt.pqht;

import com.quanlysinhvien.constant.SystemConstant;
import com.quanlysinhvien.dao.impl.UserDAO;
import com.quanlysinhvien.model.RoleModel;
import com.quanlysinhvien.model.UserModel;
import com.quanlysinhvien.model.respone.TeacherRespone;
import com.quanlysinhvien.service.impl.UserService;
import com.quanlysinhvien.util.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-pq/qldt/pqht/list-qht"})
public class ListPhanquyenController extends HttpServlet {
    @Inject
    private UserDAO userDAO;

    @Inject
    private UserService userService;
    /**
     *
     */
    private static final long serialVersionUID = 3461613811928964367L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        UserModel userModel = FormUtil.toModel(UserModel.class, req);
        userModel.setListResult(userService.findAll());
        req.setAttribute(SystemConstant.MODEL + "user", userModel);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/pqht/list-qht.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
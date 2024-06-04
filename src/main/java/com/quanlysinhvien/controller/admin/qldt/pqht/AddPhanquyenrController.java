package com.quanlysinhvien.controller.admin.qldt.pqht;

import com.quanlysinhvien.dao.impl.UserDAO;
import com.quanlysinhvien.model.UserModel;
import com.quanlysinhvien.util.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-pq/qldt/pqht/add-qht"})
public class AddPhanquyenrController extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    /**
     *
     */
    private static final long serialVersionUID = 3461613811928964367L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/pqht/add-qht.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        UserModel userModel = FormUtil.toModel(UserModel.class, req);
        userDAO.insert(userModel);
        resp.sendRedirect(req.getContextPath() + "/admin-pq/qldt/pqht/add-qht");
    }

}
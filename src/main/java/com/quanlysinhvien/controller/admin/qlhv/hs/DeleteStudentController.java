package com.quanlysinhvien.controller.admin.qlhv.hs;

import com.quanlysinhvien.dao.impl.StudentDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/qlhv/hs/delete-student"})
public class DeleteStudentController extends HttpServlet {
    @Inject
    private StudentDAO studentDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        studentDAO.delete(id);
        resp.sendRedirect(req.getContextPath() + "/admin/qlhv/hs/list-student");
    }

}

package com.quanlysinhvien.controller.admin.qldt.qlmh;

import com.quanlysinhvien.dao.impl.TeacherDAO;
import com.quanlysinhvien.service.ISubjectService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/qldt/qlmh/delete-subject"})
public class DeleteSubjectController extends HttpServlet {
    @Inject
    private ISubjectService subjectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        subjectService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/admin/qldt/qlmh/list-subject");
    }
}

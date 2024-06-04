package com.quanlysinhvien.controller.admin.qlhv.hs;

import com.quanlysinhvien.dao.impl.StudentDAO;
import com.quanlysinhvien.model.StudentModel;
import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.util.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/qlhv/hs/edit-student"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class Hoso_Edit_studentController extends HttpServlet {
    @Inject
    private StudentDAO studentDAO;

    private static final String LOCATION_RELATIVE_SAVE = "\\template\\upload\\student\\";
    private static final String LOCATION_ROOT_SAVE = "C:\\Users\\HUY\\Desktop\\cdcs\\src\\main\\webapp";
    /**
     *
     */
    private static final long serialVersionUID = 3461613811928964367L;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Long id = Long.parseLong(req.getParameter("id"));
        StudentModel studentModel = studentDAO.findById(id);
        req.setAttribute("student", studentModel);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qlsv/hs/edit-student.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        StudentModel studentModel = FormUtil.toModel(StudentModel.class, req);
        if (req.getPart("file") != null && req.getPart("file").getSize() > 0) {
            Part filePart = req.getPart("file");
            String fileName = LOCATION_RELATIVE_SAVE + filePart.getSubmittedFileName();
            for (Part part : req.getParts()) {
                part.write(LOCATION_ROOT_SAVE + fileName);
            }

            studentModel.setImage(fileName);
        }

        studentDAO.update(studentModel);
        resp.sendRedirect(req.getContextPath() + "/admin/qlhv/hs/list-student");
    }

}

package com.quanlysinhvien.controller.admin.qlhv.hs;

import com.quanlysinhvien.dao.IStudentDAO;
import com.quanlysinhvien.dao.impl.StudentDAO;
import com.quanlysinhvien.model.StudentModel;
import com.quanlysinhvien.model.TeacherModel;
import com.quanlysinhvien.service.IStudentService;
import com.quanlysinhvien.service.ITeacherService;
import com.quanlysinhvien.util.FormUtil;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/admin/qlhv/hs/add-student"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class Hoso_Add_studentController extends HttpServlet{
	private static final String LOCATION_RELATIVE_SAVE = "\\template\\upload\\student\\";
	private static final String LOCATION_ROOT_SAVE = "C:\\Users\\HUY\\Desktop\\cdcs\\src\\main\\webapp";
	@Inject
	private IStudentService studentService;


	private static final long serialVersionUID = 3461613811928964367L;



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qlsv/hs/add-student.jsp");
		rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if (req.getPart("file") == null || req.getPart("file").getSize() == 0) {
			req.setAttribute("status", "faile");
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qlsv/hs/add-student.jsp");
			rd.forward(req, resp);
			return;
		}
		Part filePart = req.getPart("file");
		String fileName = LOCATION_RELATIVE_SAVE + filePart.getSubmittedFileName();
		for (Part part : req.getParts()) {
			part.write(LOCATION_ROOT_SAVE + fileName);
		}

		StudentModel studentModel = FormUtil.toModel(StudentModel.class, req);
		studentModel.setImage(fileName);
		Long status = studentService.insert(studentModel);
		if(status == null){
			req.setAttribute("status", "faile");
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qlsv/hs/add-student.jsp");
			rd.forward(req, resp);
			return;
		}
		req.setAttribute("status", "success");
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qlsv/hs/add-student.jsp");
		rd.forward(req, resp);
    }
    
}

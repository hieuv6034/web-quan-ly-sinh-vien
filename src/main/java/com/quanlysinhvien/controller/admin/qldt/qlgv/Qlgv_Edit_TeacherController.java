package com.quanlysinhvien.controller.admin.qldt.qlgv;

import com.quanlysinhvien.dao.impl.DepartmentDAO;
import com.quanlysinhvien.dao.impl.TeacherDAO;
import com.quanlysinhvien.model.TeacherModel;
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

@WebServlet(urlPatterns = {"/admin/qldt/qlgv/edit-teacher"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class Qlgv_Edit_TeacherController extends HttpServlet{
	private TeacherDAO teacherDAO;
	private DepartmentDAO departmentDAO;

	private static final String LOCATION_RELATIVE_SAVE = "\\template\\upload\\student\\";
	private static final String LOCATION_ROOT_SAVE = "C:\\Users\\HUY\\Desktop\\cdcs\\src\\main\\webapp";

	@Override
	public void init() throws ServletException {
		this.teacherDAO = new TeacherDAO();
		this.departmentDAO = new DepartmentDAO();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3461613811928964367L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		TeacherModel teacherModel = teacherDAO.findById(id);
		req.setAttribute("teacher", teacherModel);
		req.setAttribute("departments", departmentDAO.findAll());
    	RequestDispatcher rd = req.getRequestDispatcher("/views/admin/qldt/qlgv/edit-teacher.jsp");
		rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub

		req.setCharacterEncoding("UTF-8");
		TeacherModel teacherModel = FormUtil.toModel(TeacherModel.class, req);
		if (req.getPart("file") != null && req.getPart("file").getSize() > 0) {
			Part filePart = req.getPart("file");
			String fileName = LOCATION_RELATIVE_SAVE + filePart.getSubmittedFileName();
			for (Part part : req.getParts()) {
				part.write(LOCATION_ROOT_SAVE + fileName);
			}

			teacherModel.setImage(fileName);
		}

		teacherDAO.update(teacherModel);
		resp.sendRedirect(req.getContextPath() + "/admin/qldt/qlgv/list-teacher");
    }
    
}
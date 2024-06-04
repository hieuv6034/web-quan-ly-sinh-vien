package com.quanlysinhvien.controller.dangnhap;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quanlysinhvien.constant.SystemConstant;
import com.quanlysinhvien.model.UserModel;
import com.quanlysinhvien.service.IRoleService;
import com.quanlysinhvien.service.IUserService;
import com.quanlysinhvien.util.FormUtil;
import com.quanlysinhvien.util.SessionUtil;

@WebServlet(urlPatterns = { "/dang-nhap", "/dang-xuat" })
public class LoginController extends HttpServlet {

	@Inject
	private IUserService userService;

	@Inject
	private IRoleService roleService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3461613811928964367L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			req.getSession().removeAttribute("USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/trangchu");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		String remember = req.getParameter("remember");
		UserModel userModel = FormUtil.toModel(UserModel.class, req);
		userModel = userService.findByUserEmailAndPassword(userModel.getEmail(), userModel.getPassword());
		if (userModel != null) {
			// Lưu account đăng nhập lên sesion
			req.getSession().setAttribute("USERMODEL", userModel);
			// Lưu user và password lên cookie
			Cookie email = new Cookie("email", userModel.getEmail());
			Cookie pass = new Cookie("password", userModel.getPassword());
			email.setMaxAge(150);
			if (remember != null) {
				pass.setMaxAge(60);
			} else {
				pass.setMaxAge(0);
			}
			resp.addCookie(email);
			resp.addCookie(pass);
			if (roleService.findByRoleId(userModel.getRolesid()).getRole_name().equals(SystemConstant.DAO_TAO)) {
				resp.sendRedirect(req.getContextPath() + "/admin");
			}
			else if(roleService.findByRoleId(userModel.getRolesid()).getRole_name().equals(SystemConstant.ADMIN)){
				resp.sendRedirect(req.getContextPath() + "/admin-pq/qldt/pqht");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
		}
	}

}
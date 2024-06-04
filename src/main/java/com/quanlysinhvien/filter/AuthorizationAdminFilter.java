package com.quanlysinhvien.filter;

import com.quanlysinhvien.constant.SystemConstant;
import com.quanlysinhvien.model.UserModel;
import com.quanlysinhvien.service.IRoleService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = { "/admin-pq/*" })
public class AuthorizationAdminFilter implements Filter{
	@Inject
	private IRoleService roleService;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (request.getSession().getAttribute("USERMODEL") != null) {
			UserModel userModel = (UserModel) request.getSession().getAttribute("USERMODEL");
			if(roleService.findByRoleId(userModel.getRolesid()).getRole_name().equals(SystemConstant.ADMIN))
				chain.doFilter(request, response);
			else response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
		}
		else response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
	}

	@Override
	public void destroy() {

	}

}
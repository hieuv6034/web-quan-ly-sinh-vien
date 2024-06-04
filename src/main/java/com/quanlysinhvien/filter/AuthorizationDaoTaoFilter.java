package com.quanlysinhvien.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quanlysinhvien.constant.SystemConstant;
import com.quanlysinhvien.model.UserModel;
import com.quanlysinhvien.service.IRoleService;

@WebFilter(urlPatterns = { "/admin/*" })
public class AuthorizationDaoTaoFilter implements Filter{
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
			if(roleService.findByRoleId(userModel.getRolesid()).getRole_name().equals(SystemConstant.DAO_TAO))
				chain.doFilter(request, response);
			else response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
		}
		else response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
	}

	@Override
	public void destroy() {

	}

}
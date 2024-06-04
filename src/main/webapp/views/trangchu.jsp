<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/common/taglib.jsp"%>
	
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8" />
<title>Quản Lý Sinh Viên Mật Mã</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
</head>
<body>
	<div class="header">
		<div class="logo">
		            <img src="<c:url value='/template/trangchu/images/Logo-Hoc-Vien-Ky-Thuat-Mat-Ma-ACTVN-1.png'/>"  class="logo_kma">

		</div>

		<div class="text">
			<h4 class="header_text">Quản lý sinh viên</h4>
		</div>
		<div class="btn" >
		<a href="<c:url value='/dang-nhap?action=login'/>" styleV="text-decoration: none" class="btn_login">Đăng nhập</a>
			<%-- <button class="btn_login" src="<c:url value='/dang-nhap'/>">Đăng nhập</button> --%>
		</div>

	</div>

	<div class="slider">
		<div class="title_text">
			<h4 class="main_text">Trang web quản lý học viên KMA</h4>
		</div>
	</div>
</body>
</html>

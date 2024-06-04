<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Sidebar Start -->
    <div class="sidebar pe-4 pb-3">
      <nav class="navbar bg-light navbar-light">
        <a href="index.html" class="navbar-brand mx-3 mb-3">
          <h3 class="text-primary navbar-brand-name">Quản Lý Sinh Viên</h3>
        </a>
        <div class="d-flex align-items-center ms-4 mb-4">
          <div class="position-relative">
            <img class="rounded-circle" src="<c:url value='/template/admin/img/male.png'/>" alt="" style="width: 40px; height: 40px" />
            <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1">
            </div>
          </div>
          <div class="ms-3">
            <h6 class="mb-0">${USERMODEL.name}</h6>
            <c:if test="${USERMODEL.rolesid == 1}">
                <span>Admin</span>
            </c:if>
            <c:if test="${USERMODEL.rolesid == 2}">
              <span>Đào Tạo</span>
            </c:if>

          </div>
        </div>
        <div class="navbar-nav w-100">
          <a href="<c:url value='/admin/pldt/trangchu'/>" class="nav-item nav-link">
            <i class="fa fa-tachometer-alt me-2"></i>Trang Chủ</a>
          <div class="nav-item dropdown">
            <a href="<c:url value='/admin/qlhv'/>" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
              <i class="fa-solid fa-user-graduate"></i>Quản lý sinh viên</a>
            <div class="dropdown-menu bg-transparent border-0">
              <a href="<c:url value='/admin/qlhv/hs'/>" class="dropdown-item">
                <i class="fa-solid fa-circle-plus"></i>
                &nbsp;Hồ sơ</a>
              <a href="#" class="dropdown-item">
                <i class="fa-solid fa-calendar-days"></i>&nbsp;Báo cáo thống kê</a>
            </div>
          </div>
          <div class="nav-item dropdown">
            <a href="<c:url value='/admin/qldt'/>" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
              <i class="fa-solid fa-person"></i>Quản lý đào tạo</a>
            <div class="dropdown-menu bg-transparent border-0">
              <a href="<c:url value='/admin/qldt/qlmh'/>" class="dropdown-item">
                <i class="fa-solid fa-circle-plus"></i>
                &nbsp;Quản lý môn học</a>
              <a href="<c:url value='/admin/qldt/qlgv'/>" class="dropdown-item">
                <i class="fa-solid fa-circle-plus"></i>
                &nbsp;Quản lý giảng viên</a>
              <a href="<c:url value='/admin/qldt/tkb'/>" class="dropdown-item">
                <i class="fa-solid fa-circle-plus"></i>
                &nbsp;Lập lịch</a>
              <a href="#" class="dropdown-item">
                <i class="fa-solid fa-calendar-days"></i>&nbsp;Xử lý học vụ</a>
              <a href="#" class="dropdown-item">
                <i class="fa-solid fa-list"></i>&nbsp;Xét duyệt tốt nghiệp
              </a>
              <a href="<c:url value='/admin-pq/qldt/pqht'/>" class="dropdown-item">
                <i class="fa-solid fa-list"></i>&nbsp;Khác
              </a>
            </div>
          </div>
        </div>
      </nav>
    </div>
    <!-- Sidebar End -->
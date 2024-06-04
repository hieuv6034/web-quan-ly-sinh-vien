<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>

<html lang="vi">

<head>
    <meta charset="utf-8"/>
    <title>Thêm Giảng Viên - Quản Lý Sinh Viên Mật Mã</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
</head>

<body>
<div class="container-fluid position-relative bg-white d-flex p-0">
    <!-- Spinner Start -->
    <div id="spinner"
         class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary"
             style="width: 3rem; height: 3rem" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->
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
                    <a href="#" class="nav-link " data-bs-toggle="dropdown">
                        <i class="fa-solid fa-person"></i>Quản lý người dùng</a>
                    <div class="dropdown-menu bg-transparent border-0">
                        <a href="#" class="dropdown-item">
                            <i class="fa-solid fa-circle-plus"></i>
                            &nbsp;Phân quyền hệ thống</a>

                    </div>
                </div>
            </div>
        </nav>
    </div>
    <!-- Sidebar End -->
    <!-- Content Start -->
    <div class="content">
        <!-- Section Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded h-50 p-4">
                <div class="row g-4">
                    <h3>Phân quyền</h3>
                </div>
            </div>
        </div>
        <form action="<c:url value='/admin-pq/qldt/pqht/add-qht'/>" method="post">
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded h-50 p-4">
                    <div class="row g-4">
                        <div class="col-sm-6">
                        <div class="form-group mb-3">
                            <label for="lname" class="form-label">Tên</label> <input
                                type="text" class="form-control" id="lname" name="name"
                                autocomplete="off"/>
                        </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-3">
                                <label for="email" class="form-label">Email</label> <input
                                    type="email" class="form-control" id="email" name="email"
                                    autocomplete="off"/>
                            </div>
                        </div>
                    </div>
                    <div class="row g-4">
                        <div class="col-sm-6">
                            <div class="form-group mb-3">
                                <label class="form-label">Mật khẩu</label> <input
                                    type="password" class="form-control" name="password"
                                    autocomplete="off"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-3">
                                <label class="form-label">Vị trí</label>
                                <select
                                        class="form-select" name="rolesid">
                                    <option value="1" name="rolesid">ADMIN
                                    </option>
                                    <option value="2" name="rolesid">DAO TAO
                                    </option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <button type="submit" value="add-subject" id="action" name="action" class="btn btn-primary">
                        Thêm User
                    </button>
                </div>
            </div>
        </form>
        <!-- Section End -->

        <!-- Footer Start -->
        <div class="container-fluid pt-4 px-4 ">
            <div class="bg-light rounded-top p-4">
                <div class="row">
                    <div class="col-12 col-lg-4 text-center">
                        &copy; <a href="#">Site Name</a>, All Right Reserved.
                    </div>
                    <div class="col-12 col-lg-4 text-center">
                        Designed By Nguyễn Quang Huy <a href="#">Laravel Team</a>
                    </div>
                    <div class="col-12 col-lg-4 text-center">
                        <a href="#"> <i class="bi bi-github"></i>
                        </a> <a href="#"> <i class="bi bi-facebook"></i>
                    </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->
    </div>
    <!-- Content End -->
</div>

</body>
</html>
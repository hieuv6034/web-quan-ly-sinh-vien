<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html lang="vi">

<head>
    <meta charset="utf-8" />
    <title>Quản lý đào tạo -n Quản Lý Sinh Viên Mật Mã</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
</head>

<body>
    <div class="container-fluid position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner"
            class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

    <!-- Content Start -->
    <div class="content">
       
        <!-- Section Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded h-50 p-4">
                <div class="row g-4">
                    <h3>Quản lý đào tạo</h3>
                </div>
            </div>
        </div>

        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded h-50 p-4">
                <div class="row mb-5">
                    <div class="col-lg-6 col-sm-6 col-xs-6">
                        <a href="<c:url value='/admin/qldt/qlgv/add-teacher'/>" type="button" class="btn btn-block btn-primary btn-lg"
                            style="width: 70%; height: 70px">Thêm giảng viên</a>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-xs-6">
                        <a href="<c:url value='/admin/qldt/qlgv/list-teacher'/>" type="button" class="btn btn-block btn-primary btn-lg"
                            style="width: 70%; height: 70px">Danh sách giảng viên</a>
                    </div>
                </div>

            </div>
        </div>

        <!-- Section End -->

        <!-- Footer Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded-top p-4">
                <div class="row">
                    <div class="col-12 col-lg-4 text-center">
                        &copy; <a href="#">Site Name</a>, All Right Reserved.
                    </div>
                    <div class="col-12 col-lg-4 text-center">Designed By Nguyễn Quang Huy <a href="#">Laravel Team</a></div>
                    <div class="col-12 col-lg-4 text-center">
                        <a href="#">
                            <i class="bi bi-github"></i>
                        </a>
                        <a href="#">
                            <i class="bi bi-facebook"></i>
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
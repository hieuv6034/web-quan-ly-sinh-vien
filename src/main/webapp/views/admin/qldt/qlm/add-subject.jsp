<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="vi">

<head>
    <meta charset="utf-8"/>
    <title>Thêm Môn Học - Quản Lý Sinh Viên Mật Mã</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
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

</div>
<!-- Content Start -->
<div class="content">
    <!-- Section Start -->
    <div class="container-fluid pt-4 px-4">
        <div class="bg-light rounded h-50 p-4">
            <div class="row g-4">
                <h3>Thêm Môn Học</h3>
            </div>
        </div>
    </div>
    <c:choose>
        <c:when test="${status=='success'}">
            <div class="alert alert-success">
                <strong>Success!</strong> Bạn đã thêm thành công!
            </div>
        </c:when>
        <c:when test="${status=='faile'}">
            <div class="alert alert-danger">
                <strong>Faile!</strong> Bạn đã thêm thất bại!

            </div>
        </c:when>
    </c:choose>
    <form action="<c:url value='/admin/qldt/qlmh/add-subject'/>" id="add-subject" method="post">
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded h-50 p-4">
                <div class="row g-4">
                    <div class="col-sm-6">
                        <div class="form-group mb-3">
                            <label for="name" class="form-label">Tên môn</label>
                            <input type="text" class="form-control" id="name" name="name" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group mb-3">
                            <label for="code" class="form-label">Mã học phần</label>
                            <input type="text" class="form-control" id="code" name="code"
                                   autocomplete="off"/>
                        </div>
                    </div>
                    <div class="col"><label class="form-label" for="alls">Tổng số tiết</label><input
                            placeholder="Nhập Tổng số tiết" name="alls" type="number" id="alls" class="form-control">
                    </div>
                    <div class="col"><label class="form-label" for="theory">Số tiết lý thuyết</label><input
                            placeholder="Nhập Số tiết lý thuyết" name="theory" type="number" id="theory"
                            class="form-control"></div>
                    <div class="col"><label class="form-label" for="practice">Số tiết thực hành</label><input
                            placeholder="Nhập Số tiết thực hành" name="practice" type="number" id="practice"
                            class="form-control"></div>
                    <div class="col"><label class="form-label" for="exercise">Số tiết bài tập</label><input
                            placeholder="Nhập Số tiết bài tập" name="exercise" type="number" id="exercise"
                            class="form-control"></div>
                </div>
                <div class="row g-4">
                    <div class="col-sm-4">
                        <div class="form-group mb-3">
                            <label for="course_load" class="form-label">Số tín chỉ</label>
                            <input type="number" class="form-control" id="course_load" name="course_load"
                                   autocomplete="off"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group mb-3">
                            <label for="department_id" class="form-label">Khoa</label>
                            <select class="form-select"  name="department_id"  >
                                <option value="0"  id="department_id" name ="department_id" selected="selected">Chọn</option>
                                <c:forEach var="item" items="${modeldepartment.listResult}">
                                	<option value="${item.id}" id="department_id" name ="department_id" selected="selected">${item.name}</option>
                                </c:forEach>

                            </select>
                        </div>
                    </div>
                </div>

                <button type="submit" value="add-subject" id="action" name="action" class="btn btn-primary">
                    Thêm Môn Học
                </button>
            </div>
        </div>
    </form>

<!-- Footer Start -->
<div class="container-fluid pt-4 px-4 ">
    <div class="bg-light rounded-top p-4">
        <div class="row">
            <div class="col-12 col-lg-4 text-center">
                &copy; <a href="#">Site Name</a>, All Right Reserved.
            </div>
            <div class="col-12 col-lg-4 text-center">
                Designed By Nguyễn Quang Huy<a href="#">Laravel Team</a>
            </div>
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


</body>

</html>
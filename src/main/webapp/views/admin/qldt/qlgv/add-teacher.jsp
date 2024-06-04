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

    <!-- Content Start -->
    <div class="content">
        <!-- Section Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded h-50 p-4">
                <div class="row g-4">
                    <h3>Thêm Giảng Viên</h3>
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

        <form action="<c:url value='/admin/qldt/qlgv/add-teacher'/>" id="add-teacher" method="post"
              enctype="multipart/form-data">
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded h-50 p-4">
                    <div class="row g-4 mb-3">
                        <div class="col-sm-6 mb-3">
                            <div class="row g-4 mb-3">
                                <div class="form-group mb-3">
                                    <label for="fname" class="form-label">Họ đệm</label> <input
                                        type="text" class="form-control" id="fname" name="fname"
                                        autocomplete="off"/>
                                </div>
                            </div>
                            <div class="row g-4">
                                <div class="form-group mb-3">
                                    <label for="lname" class="form-label">Tên</label> <input
                                        type="text" class="form-control" id="lname" name="lname"
                                        autocomplete="off"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 d-flex justify-content-center">
                            <div class="form-group">
                                <label class="required">Ảnh:&ensp;</label>
                                <input type="file" name="file">
                            </div>
                        </div>
                    </div>
                    <div class="row g-4">
                        <div class="col-sm-6">
                            <div class="form-group mb-3">
                                <label for="code" class="form-label">Mã Giảng Viên</label> <input
                                    type="text" class="form-control" id="code" name="code"
                                    autocomplete="off"/>
                            </div>
                        </div>
                        <div class="col-sm-6 ">
                            <div class="form-group mb-3">
                                <label for="gender">Giới Tính</label>
                                <div class="form-check form-check-inline">

                                    <input class="form-check-input" type="radio" name="gender"
                                           id="gender" value="1" checked=""/> <label
                                        class="form-check-label" for="gender"> Nam </label>

                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender"
                                           value="2"/> <label class="form-check-label"
                                                              for="gender"> Nữ </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row g-4">
                        <div class="col-sm-6">
                            <div class="form-group mb-3">
                                <label for="department_id" class="form-label">Khoa</label>
                                <select
                                        class="form-select" name="department_id">
                                    <option value="0" id="department_id" name="department_id" selected="selected">Chọn
                                    </option>
                                    <c:forEach var="item" items="${modeldepartment.listResult}">
                                        <option value="${item.id}" id="department_id" name="department_id"
                                                selected="selected">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group mb-3">
                                <label for="phone" class="form-label">Số Điện Thoại</label> <input
                                    type="text" class="form-control" id="phone" name="phone"
                                    autocomplete="off"/>
                            </div>
                        </div>
                    </div>
                    <div class="row g-4">
                        <div class="col-sm-6">
                            <div class="form-group mb-3">
                                <label for="dob" class="form-label">Ngày Sinh</label>
                                <input type="date" class="form-control" id="dob"
                                       name="dob" autocomplete="off"/>
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
                    <button type="submit" value="add-subject" id="action" name="action" class="btn btn-primary">
                        Thêm Giảng Viên
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
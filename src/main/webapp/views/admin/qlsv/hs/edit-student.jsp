<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="utf-8"/>
    <title>Chỉnh Sửa Thông Tin Sinh Viên - Quản Lý Sinh Viên Mật Mã</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

</head>

<body>
<div class="container-xxl position-relative bg-white d-flex p-0">
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
                    <h3>Chỉnh Sửa Thông Tin Sinh Viên</h3>
                </div>
            </div>
        </div>
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded h-50 p-4">
                <form action="<c:url value='/admin/qlhv/hs/edit-student'/>" id="edit-student" method="post"
                      enctype="multipart/form-data">
                            <input type="hidden" name="id" value="${student.id}"/>
                            <input type="hidden" name="image" value="${student.image}"/>
                            <div class="row g-4 mb-3">
                                <div class="col-sm-6 mb-3">
                                    <div class="row g-4 mb-3">
                                        <div class="form-group mb-3">
                                            <label for="name" class="form-label">Họ và tên</label> <input
                                                type="text" class="form-control" id="name" name="name"
                                                value="${student.name}" autocomplete="off"/>
                                        </div>
                                    </div>
                                    <div class="row g-4">
                                        <div class="form-group mb-3">
                                            <label for="lop" class="form-label">Lớp</label> <input
                                                type="text" class="form-control" id="lop" name="lop"
                                                value="${student.lop}"
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
                                        <label for="code" class="form-label">Mã Sinh Viên</label> <input
                                            type="text" class="form-control" id="code" name="code"
                                            value="${student.code}"
                                            autocomplete="off"/>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group mb-3">
                                        <label>Giới Tính</label>
                                        <c:choose>
                                            <c:when test="${student.gender == '1' }">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gender"
                                                           value="1" checked=""/> <label
                                                        class="form-check-label"> Nam </label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gender"
                                                           value="2"/> <label class="form-check-label"> Nữ </label>
                                                </div>
                                            </c:when>

                                            <c:when test="${student.gender == '2' }">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gender"
                                                           value="1"/> <label
                                                        class="form-check-label"> Nam </label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gender" value="2"
                                                           checked=""/> <label class="form-check-label"> Nữ </label>
                                                </div>
                                            </c:when>

                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="row g-4">
                                <div class="col-sm-6">
                                    <div class="form-group mb-3">
                                        <label for="bank_number" class="form-label">Số tài khoản</label>
                                        <input type="text" class="form-control" id="bank_number"
                                               name="bank_number" autocomplete="off" value="${student.bank_number}"/>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group mb-3">
                                        <label for="bank" class="form-label">Ngân hàng</label> <select
                                            class="form-select" id="bank" >
                                        <option value="0" selected="selected">Chọn</option>
                                        <option value="A" selected="selected">Ngân hàng MB</option>
                                        <option value="B" selected="selected">Ngân hàng BIDV</option>
                                        <option value="C" selected="selected">Ngân hàng VIETCOMBANK</option>
                                        <option value="D" selected="selected">Ngân hàng TECHCOMBANK</option>
                                        <option value="E" selected="selected">Khác</option>
                                    </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row g-4">
                                <div class="col-sm-6">
                                    <div class="form-group mb-3">
                                        <label for="position" class="form-label">Chức vụ học
                                            viên</label> <select class="form-select" id="position" selected="selected">
                                        <option value="0">Chọn</option>
                                        <option value="1">Lớp trưởng</option>
                                        <option value="2">Lớp Phó</option>
                                        <option value="3">Bí thư</option>
                                        <option value="4">Không</option>
                                    </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group mb-3">
                                        <label for="school_year_id" class="form-label">Học kỳ
                                            nhập học</label> <input type="text" class="form-control"
                                                                    id="school_year_id" name="school_year_id"
                                                                    autocomplete="off" value="${student.school_year_id}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row g-4">
                                <div class="col-sm-4">
                                    <div class="form-group mb-3">
                                        <label for="identify_number" class="form-label">CCCD/CMND</label>
                                        <input type="text" class="form-control" id="identify_number"
                                               name="identify_number" autocomplete="off" value="${student.identify_number}"/>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group mb-3">
                                        <label for="identify_date" class="form-label">Ngày
                                            cấp</label> <input type="text" class="form-control"
                                                               id="identify_date" name="identify_date"
                                                               autocomplete="off" value="${student.identify_date}"/>
                                    </div>
                                </div>

                                <div class="col-sm-4">
                                    <div class="form-group mb-3">
                                        <label for="identify_address" class="form-label">Nơi
                                            cấp</label> <input type="text" class="form-control"
                                                               id="identify_address" name="identify_address"
                                                               autocomplete="off" value="${student.identify_address}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <fmt:parseDate value="${student.birthday}" pattern="yyyy-MM-dd" var="myDate"/>
                                <fmt:formatDate value="${myDate }" pattern="yyyy-MM-dd" var="strDate" />
                                <label for="birthday" class="form-label">Ngày sinh</label> <input
                                    type="text" class="form-control" id="birthday" name="birthday"
                                    autocomplete="off" value="${strDate}"/>
                            </div>
                            <div class="form-group mb-3">
                                <label for="address" class="form-label">Địa chỉ</label> <input
                                    type="text" class="form-control" id="address" name="address"
                                    autocomplete="off" value="${student.address}" />
                            </div>
                         <button type="submit" id="action" name="action" class="btn btn-primary" >Cập
                             nhật thông tin sinh viên
                         </button>
                    </form>
                </div>
            </div>


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
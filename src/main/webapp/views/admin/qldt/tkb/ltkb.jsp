<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <title>Lập danh sách môn cho kì học - Quản Lý Sinh Viên Mật Mã</title>
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

    <!-- Content Start -->
    <div class="content">
        <!-- Section Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded h-50 pt-4 pb-4">
                <div class="row g-4">
                    <h3>Lập danh sách môn cho kì học</h3>
                </div>
            </div>
        </div>
        <div class="container-fluid pt-4">
            <div class="bg-light rounded h-50 p-4">
                <form action="<c:url value='/admin/qldt/tkb/ltkb'/>" method="post">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="required">Khóa học: </label>
                                <select class="form-control" name="courses_id">
                                    <c:forEach items="${courses}" var="course">
                                        <option value="${course.id}">${course.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="required">Khoa: </label>
                                <select class="form-control" name="department_id">
                                    <c:forEach items="${departments}" var="department">
                                        <option value="${department.id}">${department.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="required">Kì học: </label>
                                <select class="form-control" name="semester_id">
                                    <c:forEach items="${semesters}" var="semester">
                                        <option value="${semester.id}">${semester.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="required">Giảng viên: </label>
                                <select class="form-control" name="teacher_id">
                                    <c:forEach items="${teachers}" var="teacher">
                                        <option value="${teacher.id}">${teacher.fname} ${teacher.lname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="required">Môn học: </label>
                                <select class="form-control" name="subject_id">
                                    <c:forEach items="${subjects}" var="subject">
                                        <option value="${subject.id}">${subject.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="required">Số lớp tín chỉ: </label>
                                <input type="number" name="total_class" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="required">Tên lớp học: </label>
                                <input type="text" name="name_class" class="form-control">
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary mt-3">Thêm lịch học</button>
                </form>

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
</div>

</body>

</html>
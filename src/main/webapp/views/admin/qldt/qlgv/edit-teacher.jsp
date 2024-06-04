<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html lang="vi">

<head>
<meta charset="utf-8" />
<title>Chỉnh Sửa Thông Tin Giảng Viên - Quản Lý Sinh Viên Mật Mã</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
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
						<h3>Chỉnh Sửa Thông Tin Giảng Viên</h3>
					</div>
				</div>
			</div>
			<div class="container-fluid pt-4 px-4">
				<div class="bg-light rounded h-50 p-4">
					<form action="<c:url value='/admin/qldt/qlgv/edit-teacher'/>" id="edit-teacher" method="post"
						  enctype="multipart/form-data">

						<input type="hidden" name="id" value="${teacher.id}" />
						<input type="hidden" name="image" value="${teacher.image}" />
						<div class="row g-4 mb-3">
							<div class="col-sm-6 mb-3">
								<div class="row g-4 mb-3">
									<div class="form-group mb-3">
										<label for="f-name" class="form-label">Họ đệm</label> <input
											type="text" class="form-control" id="f-name" name="fname" value="${teacher.fname}"
											autocomplete="off" />
									</div>
								</div>
								<div class="row g-4">
									<div class="form-group mb-3">
										<label for="l-name" class="form-label">Tên</label> <input
											type="text" class="form-control" id="l-name" name="lname" value="${teacher.lname}"
											autocomplete="off" />
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
										type="text" class="form-control" id="code" name="code" value="${teacher.code}"
										autocomplete="off" />
								</div>
							</div>
							<div class="col-sm-6 ">
								<div class="form-group mb-3">
									<label>Giới Tính</label>
									<c:choose>
										<c:when test="${teacher.gender == '1' }">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio" name="gender"
													   value="1" checked="" /> <label
													class="form-check-label"> Nam </label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio" name="gender" value="2" /> <label class="form-check-label"> Nữ </label>
											</div>
										</c:when>

										<c:when test="${teacher.gender == '2' }">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio" name="gender"
													   value="1" /> <label
													class="form-check-label"> Nam </label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio" name="gender" value="2" checked="" /> <label class="form-check-label"> Nữ </label>
											</div>
										</c:when>

									</c:choose>

								</div>
							</div>
						</div>
						<div class="row g-4">
							<div class="col-sm-6">
								<div class="form-group mb-3">
									<label for="department" class="form-label">Khoa</label> <select
										class="form-select" id="department" name="department_id">
									<option value="0" id="department_id" name="department_id">Chọn
									</option>
									<c:forEach var="item" items="${departments}">
										<c:choose>
											<c:when test="${item.id == teacher.department_id}">
												<option value="${item.id}" id="department_id" name="department_id"
														selected="selected">${item.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${item.id}" id="department_id" name="department_id">${item.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group mb-3">
									<label for="phone" class="form-label">Số Điện Thoại</label> <input
										type="text" class="form-control" id="phone" name="phone"
										autocomplete="off" value="${teacher.phone }"/>
								</div>
							</div>
						</div>
						<div class="row g-4">
							<div class="col-sm-6">
								<div class="form-group mb-3">
									<fmt:parseDate value="${teacher.dob}" pattern="yyyy-MM-dd" var="myDate"/>
									<fmt:formatDate value="${myDate }" pattern="yyyy-MM-dd" var="strDate" />
									<label for="date_of_birth" class="form-label">Ngày Sinh</label>
									<input type="date" class="form-control" id="date_of_birth"
										name="dob" autocomplete="off" value="${strDate}"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group mb-3">
									<label for="email" class="form-label">Email</label> <input
										type="email" class="form-control" id="email" name="email"
										autocomplete="off" value="${teacher.email }"/>
								</div>
							</div>
						</div>
						<button type="submit" id="action" name="action" class="btn btn-primary">
							Chỉnh Sửa Giảng Viên
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
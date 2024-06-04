<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="utf-8" />
<title>Danh Sách Sinh Viên - Quản Lý Sinh Viên Mật Mã</title>
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
						<h3>Danh Sách Sinh Viên</h3>
					</div>
				</div>
			</div>
			<div class="container-fluid pt-4 px-4">
				<div class="bg-light rounded p-4">
					<form action="<c:url value="/admin/qlhv/hs/list-student"/>"
						  method="get" id="form">
						<div class="row g-4" style="margin-right: 300px">
							<div class="col-sm-4">
								<div class="form-group mb-3">
									<label class="form-label">Mã sinh viên</label> <input
										type="text" class="form-control" id="code" name="code"
										autocomplete="off"/>
								</div>
							</div>
							<div class="col-sm-4">
							<div class="form-group mb-3">
								<label class="form-label">Họ và tên</label> <input
									type="text" class="form-control" id="name" name="name"
									autocomplete="off"/>
							</div>
							</div>
						</div>

						<button style="margin-bottom: 20px;" type="submit"
								class="btn btn-primary">Tra cứu</button>
						<a href="<c:url value="/admin/qlhv/hs/export-student"/>" class="btn btn-success" style="margin-bottom: 20px;">Export</a>
					</form>
					<div
						class="table-responsive table-wrapper-scroll-y my-custom-scrollbar">
						<table class="table table-hover table-striped mb-0">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Họ và Tên</th>
									<th scope="col">Giới tính</th>
									<th scope="col">Mã Sinh Viên</th>
									<th scope="col">Lớp</th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>
							 	<c:forEach var="item" items="${modelstudent.listResult}">
								<tr>
									<th scope="row">${item.id}</th>
									<td>${item.name}</td>
									<td>${item.gender}</td>
									<td>${item.code}</td>
									<td>${item.lop}</td>
									<td><a class="btn btn-primary btn-sm" href="<c:url value='/admin/qlhv/hs/edit-student?id=${item.id}'/>"> <i class="bi bi-pencil-square"></i>
									</a> <a href="<c:url value='/admin/qlhv/hs/delete-student?id=${item.id}'/>" class="btn btn-danger btn-sm"
											data-id="${item.id}" onclick="deleteStudent(this)"> <i
											class="bi bi-trash-fill"></i>
									</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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
	<script>
		function deleteStudent(element) {
			const id = element.getAttribute('data-id');
			const jsonData = { id: id};
			if (confirm('Xoá mà không thể khôi phục. Bạn có chắc chắn không ?')) {
				$.ajax({
					type: 'GET',
					url: '<c:url value="/admin/qlhv/hs/delete-student?"/>',
					data: JSON.stringify(jsonData),
					contentType: 'application/json;charset=UTF-8',
					success: function (result) {
						if (result.error === true) {
							alert(result.message);
							location.reload();
						} else {
							location.reload();
						}
					},
				});
			}
		}

	</script>
</body>
</html>

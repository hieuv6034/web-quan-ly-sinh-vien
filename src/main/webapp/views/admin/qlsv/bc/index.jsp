<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="utf-8" />
  <title>Báo cáo thống kê - Quản Lý Sinh Viên Mật Mã</title>
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
						<h3>Báo cáo thống kê</h3>
					</div>
				</div>
			</div>
			<div class="container-fluid pt-4 px-4">
				<div class="bg-light rounded h-50 p-4">
					<div class="row mb-5">
						<div class="col-lg-6 col-sm-6 col-xs-6">
							<a href="report1.html" type="button"
								class="btn btn-block btn-primary btn-lg"
								style="width: 70%; height: 70px">Báo cáo thống kê 1</a>
						</div>
						<div class="col-lg-6 col-sm-6 col-xs-6">
							<a href="report2.html" type="button"
								class="btn btn-block btn-primary btn-lg"
								style="width: 70%; height: 70px">Báo cáo thống kê 2</a>
						</div>
					</div>
					<div class="row mb-5 -bottom-3">
						<div class="col-lg-6 col-sm-6 col-xs-6">
							<a href="report3.html" type="button"
								class="btn btn-block btn-primary btn-lg"
								style="width: 70%; height: 70px">Báo cáo thống kê 3</a>
						</div>
						<div class="col-lg-6 col-sm-6 col-xs-6">
							<a href="report4.html" type="button"
								class="btn btn-block btn-primary btn-lg"
								style="width: 70%; height: 70px">Báo cáo thống kê 4</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Section End -->
		</div>
		<!-- Content End -->
	</div>

</body>

</html>

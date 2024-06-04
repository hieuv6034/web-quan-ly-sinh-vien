<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>Quản Lý Sinh Viên Mật Mã</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    </head>
<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->


		<!-- Sign In Start -->
		<div class="container-fluid">
			<div class="row h-100 align-items-center justify-content-center"
				style="min-height: 100vh;">
				<div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
					<div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
						<div
							class="d-flex align-items-center justify-content-between mb-3">
							<a href="index.html" class="">
								<h3 class="text-primary">Quản Lý Sinh Viên KMA</h3>
							</a>

						</div>
						<h3>Đăng Nhập</h3>
						<form action="<c:url value='/dang-nhap'/>" id ="login" method="post">
							<div class="form-floating mb-3">
								<input type="email" class="form-control"  name="email"
									placeholder="name@example.com"> <label for="email" id="email">Email</label>
							</div>
							<div class="form-floating mb-4">
								<input type="password" class="form-control" id="password" name ="password" 
									placeholder="Password"> <label for="password">Password</label>
							</div>
							<div
								class="d-flex align-items-center justify-content-between mb-4">
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="remeber-me">
									<label class="form-check-label" for="remeber-me">Remember me?</label>
								</div>
							</div>
							<button type="submit" value="login" id= "action" name= "action" class="btn btn-primary py-3 w-100 mb-4">Đăng Nhập</button>
						</form>
						
					</div>
				</div>
			</div>
		</div>
		<!-- Sign In End -->
	</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Favicon -->
<!-- <link href="../../img/logoico.png" rel="icon" /> -->
<link href="<c:url value='/template/admin/img/logoico.png'/>" rel="icon" />
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap"
	rel="stylesheet" />

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/f172ccfa7a.js"
	crossorigin="anonymous"></script>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<!-- <link href="../../css/bootstrap.min.css" rel="stylesheet" /> -->
<link href="<c:url value='/template/admin/css/bootstrap.min.css'/>"
	rel="stylesheet" />
<!-- DataTables -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js">
	
</script>
<!-- Template Stylesheet -->
<!-- <link href="../../css/style.css" rel="stylesheet" /> -->
<link href="<c:url value='/template/admin/css/style.css'/>"
	rel="stylesheet" />
<dec:head />
</head>
<body class="no-skin">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<!-- sidebar -->
	<%@ include file="/common/admin/sidebar.jsp"%>
	<!-- sidebar -->

	<dec:body />



	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<!-- Template Javascript -->
	<!-- <script src="../../js/main.js"></script> -->
	<script src="<c:url value='/template/admin/js/main.js'/>"></script>
	<!-- JavaScript Libraries -->

	<!-- Template Javascript -->
	<script src="../../js/main.js"></script>
</body>
</html>
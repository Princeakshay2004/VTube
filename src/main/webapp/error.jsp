<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Something went wrong !</title>
<%@include file="base.jsp"%>
<%@ include file="navbar.jsp"%>

</head>
<body style="margin-top: 5em; background-color: #181818">
	
		<div class="row mb-4">
			<div class="card-img-overlay">
				<div class="col-md-12 text-center"
					style="margin-top: 150px;">
					<img src="img/error.png" style="height: 200px">
					<h2 class="font-weight-bold text-white">404</h2>
					<h3 class="font-weight-bold text-white">Something went Wrong !</h3>
					<a class="btn btn-outline-primary font-weight-bold text-white outline-light" href="/">Home</a>
				</div>
			</div>

		</div>

</body>
</html>
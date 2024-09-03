<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.helper.Message"%>
	<%@page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Here</title>
<%@include file="base.jsp"%>
</head>
<%@include file="navbar.jsp"%>
<body style="margin-top: 5em">

<div class="container mt-5">
<div class="row ">
<div class="col-md-4 offset-md-4">
<div class="card">
	

  <div class="card-body">
  <h4 class="text-center fw-bold">Sign Up</h4>
   <!--Message-->
  <%
  Message msg=(Message) session.getAttribute("message");
  if(msg!=null)
  {
  %> 
<div class="alert <%=msg.getType() %>" role="alert" >
<p><%=msg.getContent() %></p>
</div>
  <%
  session.removeAttribute("message");
  }
  %>
  <!--Message end-->
  
   <form action="/saveUser" method="post" enctype="multipart/form-data">
    <div class="mb-2">
    <label for="name" class="form-label">Name</label>
    <input type="text" name="name" class="form-control" required="required" id="name" aria-describedby="name">
  </div>
   <div class="mb-2">
    <label for="email" class="form-label">Email address</label>
    <input type="email" name="email" required="required" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-2">
    <label for="number" class="form-label">Mobile No</label>
    <input type="text" name="number" required="required" class="form-control" id="mobile" aria-describedby="mobile">
  </div>
   <div class="mb-2">
    <label for="address" class="form-label">Gender : </label>
  	<input class="form-check-input" required="required" type="radio" name="gender" id="inlineRadio1" value="male"> Male
  	<input class="form-check-input" required="required" type="radio" name="gender" id="inlineRadio2" value="female"> Female</div>
  <div class="mb-2">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" required="required" class="form-control" id="exampleInputPassword1">
  </div>
  <div class=" mb-2">
  <label for="profile" class="form-label">Profile</label>
  <input type="file" name="profile" class="form-control" id="profile">
</div>
  <div class="mb-1 text-center">
      <button type="submit" class="btn btn-success">Submit</button>
      <p class="pt-1">If you have an account ? <a href="/login" style="text-decoration: none;"> Sign In</a></P>   
  </div>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>
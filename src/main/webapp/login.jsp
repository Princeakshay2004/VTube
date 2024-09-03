<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page errorPage="error.jsp" %>
 <%@page import="com.helper.Message" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Here</title>
<%@include file="base.jsp"%>
</head>
<%@include file="navbar.jsp"%>
<body style="margin-top: 10em">
<div class="container mt-5">
<div class="row ">
<div class="col-md-4 offset-md-4">
<div class="card">

	 <!--Message-->
  <%
  Message msg1=(Message) session.getAttribute("message");
  if(msg1!=null)
  {
  %> 
<div class="alert <%=msg1.getType() %>" role="alert" >
<p><%=msg1.getContent() %></p>
</div>
  <%
  session.removeAttribute("message");
  }
  %>
  <!--Message end-->
  
  <div class="card-body">
  <h4 class="text-center fw-bold">Sign In</h4>
   <!--Message-->
<%
  String log=request.getParameter("logout");
  Message msg=(Message)session.getAttribute("log");
  if(log!=null)
  {
  if(msg!=null)
  {
  %> 
<div class="container text-center " style="color: green"  >
<p><%=msg.getContent()%></p>
</div>
  <%
  }
  }
  session.removeAttribute("log");
%>
  
   <form action="/do_login" method="post">
  <div class="mb-2">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3 text-center">
      <button type="submit" class="btn btn-danger">Sign In</button>
      <p class="pt-1">Don't have an account yet? <a href="/signup" style="text-decoration: none;"> Create Account</a></P>   
  </div>
  <hr>
  <div class="mb-3 text-center">
  <a class="btn btn-light me-1" href="/oauth2/authorization/google"><img src="/img/google.png" style="width: 20px"> Google</a>
  <a class="btn btn-light me-1" href="/oauth2/authorization/facebook"><img src="/img/facebook.png" style="width: 20px"> Facebook</a>
  <a class="btn btn-light me-1" href="/oauth2/authorization/github"><img src="/img/github.png" style="width: 20px"> Github</a>
  </div>
</form>
   
  </div>
</div>
</div>
</div>
</div>
</body>
</html>
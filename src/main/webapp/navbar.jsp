<%@page import="com.entity.Video"%>
<%@ page import="com.entity.User" %>
<%
User user=(User)request.getAttribute("CurrentUser");

%>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid ps-5 pe-5">
    <a class="navbar-brand fw-bold" href="/"><img  src="/img/icon.png" style="height: 30px;width: 30px">  VTube</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse "id="navbarSupportedContent">
      <ul class="navbar-nav me-2 mb-2 mb-lg-0">
        <li class="nav-item me-2">
          <a class="nav-link active" aria-current="page" href="/"><i class="fa-solid fa-house"></i> Home</a>
        </li>
        <li class="nav-item me-2">
          <a class="nav-link active" aria-current="page" href="#"><i class="fa-solid fa-play"></i> Shorts</a>
        </li>
        <li class="nav-item dropdown me-5">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <i class="fa-solid fa-list"></i>
          </a>
          <ul class="dropdown-menu me-0" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item " href="#">Song</a></li>
            <li><a class="dropdown-item" href="#">Music</a></li>
             <li><a class="dropdown-item " href="#">Song</a></li>
            <li><a class="dropdown-item" href="#">Music</a></li> 
            <li><a class="dropdown-item " href="#">Song</a></li>
            <li><a class="dropdown-item" href="#">Music</a></li>
             <li><a class="dropdown-item " href="#">Song</a></li>
            <li><a class="dropdown-item" href="#">Music</a></li>
             <li><a class="dropdown-item " href="#">Song</a></li>
            <li><a class="dropdown-item" href="#">Music</a></li>
          </ul>
        </li>
      </ul>
      <%--Serch Box --%>
      <form class="d-flex col-md-5 ms-2" action="/video/result" method="get">
        <input class="form-control me-2" name="search" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-light" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
      </form>
      <ul class="navbar-nav me-2 mb-2 mb-lg-0">
      	<li class="nav-item">
          <a class="nav-link active ms-1" aria-current="page" href="#"><i class="fa-solid fa-microphone fa-lg"></i></a>
        </li>
       </ul>
        <%-- left Content --%>
         <ul class="navbar-nav ms-auto">
        <%
		if(user ==null)
		  {
		%>
		<li class="nav-item me-2">
          <a class="nav-link " aria-current="page" href="/login"><i class="fa-solid fa-clock"></i> Watch Later</a>
        </li>
        <li class="nav-item me-2">
          <a class="nav-link" aria-current="page" href="/login" ><i class="fa-solid fa-upload"></i> Upload</a>
        </li>
		<li class="nav-item me-2"><a class="nav-link active" aria-current="page" href="/login"><i class="fa-solid fa-user"></i> Login</a></li>
		<%
		} 
		else 
		{
		%>
		<li class="nav-item me-2">
          <a class="nav-link active" aria-current="page" href="#"><i class="fa-solid fa-clock"></i>  Watch Later</a>
        </li>
        <li class="nav-item me-2">
          <a class="nav-link active" aria-current="page" href="#" data-bs-toggle="modal" data-bs-target="#videoModal"><i class="fa-solid fa-upload"></i> Upload</a>
        </li>
		<li class="nav-item me-2">
		<a class="nav-link active" aria-current="page" href="#"data-bs-toggle="modal" data-bs-target="#profileModal"><img style="height: 25px;width: 25px;border-radius: 50%" src="<%=user.profileurl(user)%>"/></a>
		 </li>
		<%
		}
		%>
	</ul>
  </div>
 </div>
</nav>

<%@include file="models.jsp"%>
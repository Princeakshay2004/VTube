<%@page import="org.springframework.ui.Model"%>
<%@page import="com.service.impl.commentServiceImpl"%>
<%@page import="com.service.commentService"%>
<%@page import="com.entity.Comments"%>
<%@page import="com.entity.Video"%>
<%@page import="java.util.*" %>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@page errorPage="error.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VTube</title>
<%@include file="base.jsp" %>
<%@ include file="navbar.jsp"%>
</head>
<body style="margin-top: 5em; background-color: #181818">
<div class="ms-4 me-4">
<div class="row mb-2">
<% 
	// for get video from path variable
	Video video1=(Video)session.getAttribute("Videoview");	
			
			
%>
<%-- Main video frame --%>
	<div class="col-md-8 mb-1 ms-5">
		<div class="card border-0">
		 <div class="card-body text-white black">
			<video controls="controls" style="height: 35em; width: 60em;border-radius: 3%">
			<source src="https://res.cloudinary.com/dqg87xvqe/video/upload/v1723582392/<%=video1.getVideo()%>.mp4" type="video/mp4">
  			</video>
			<h5 class="fw-bold mt-1"><%=video1.getvTitle()%></h5>
			<p class="mb-0"><%=video1.getvDescription()%></p>
			<div class="d-flex justify-content-end">
				<a href="#" onclick="watchCount()" class="nav-link" style="width: 70px"><i class="fa fa-eye"></i> <span class="watch-counter">2.4K</span></a>
				<a href="#" onclick="doLike()" class="nav-link" style="width: 50px"><i class="fa fa-thumbs-up"></i> <span class="like-counter">10</span></a>
				<a href="#" onclick="doLike()" class="nav-link" style="width: 50px"><i class="fa fa-thumbs-down"></i> <span class="dislike-counter">10</span></a>
				<a href="#" onclick="addTowatch()" class="nav-link" style="width: 20px"><i class="fa-regular fa-bookmark"></i></a>
				<a href="#" onclick="removeFromWatch()" class="nav-link" style="width: 20px"><i class="fa-solid fa-bookmark"></i></a>
			</div>
		</div>
		</div>
		<div class="card "style="border:0 ;background-color:#212121">
		 <div class="card-body text-white ">
			<h5 class="fw-bold mt-1">Comments</h5>
			
			<%-- Comments Appear Here --%>
			<%
			List<Comments> comment=(List<Comments>)session.getAttribute("Comments");
	        Collections.shuffle(comment);	
	        for(Comments obj:comment)
	        {
			%>
			<p><%=obj.getComments() %></p>
			<%} %>
			<form action="/video/comment/<%=video1.getVid()%>" method="post" class=" d-flex align-items-inline">
			<input type="text" name="comment" class="form-control mt-3 " placeholder="Enter comment here">
      		<button type="submit" class="btn btn-primary mt-3 ms-2"><i class="fa-solid fa-paper-plane"></i></button>
			</form>
			
		</div>
		</div>
	</div>
<%-- Main video frame End --%>

<%-- Side video frame --%>
<div class="col-md-3 mt-3">
		<%
		List<Video> video=(List<Video>)session.getAttribute("Video");
        Collections.shuffle(video);	

        for (int i =1; i <=7 && i < video.size(); i++) {
            Video video2 = video.get(i);
			
		%>
		<a href="/video/view/<%=video2.getVid()%>" style="text-decoration: none;">
		<div class="container">
		 <div class="card-body text-white d-flex" >
		 <div>
			<video controls="controls" style="height: 8em; width: 13em;border-radius: 3%">
			<source src="https://res.cloudinary.com/dqg87xvqe/video/upload/v1723582392/<%=video2.getVideo()%>.mp4" type="video/mp4">
  			</video>
			</div>
			<div class="m-3 col-md-7">
				<h6 style="font-size: 0.8rem" class="mb-0"><%=video2.get20Words(video2.getvTitle())%></h6>
				<p style="font-size: 0.7rem"><%=video2.get20Words(video2.getvDescription())%></p>
			</div>
		</div>
		</div>
		</a>
		<%
		}%>
</div>


 <%--Side video frame End --%>
</div>
</div>
</body>
</html>
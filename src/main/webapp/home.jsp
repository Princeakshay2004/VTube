<%@page import="com.service.impl.videoServiceImpl"%>
<%@page import="com.service.videoService"%>
<%@page import="com.entity.Video"%>
<%@page import="java.util.*"%>
<%@page import="com.helper.Message"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page errorPage="error.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VTube</title>
<%@include file="base.jsp"%>
<%@ include file="navbar.jsp"%>

</head>
<body style="margin-top: 5em; background-color: #181818">
	<div class=" me-4">
		<div class="row mb-4 ms-2">
			<div class="container">
				<!--Message-->
				<%
				Message msg1 = (Message) session.getAttribute("videoUpload");
				if (msg1 != null) {
				%>
				<div class="alert <%=msg1.getType()%>" role="alert">
					<H5 class="fw-bold text-center"><%=msg1.getContent()%></h5>
				</div>
				<%
				session.removeAttribute("videoUpload");
				}
				%>
				<!--Message end-->
			</div>
			<%-- Home page Video showing  --%>
			<%
			List<Video> video = (List<Video>) session.getAttribute("Video");
	        Collections.shuffle(video);

			for (Video video1 : video) {
				
			%>
			<div class="col-md-3 pb-4 mt-1">
				<a href="/video/view/<%=video1.getVid()%>"
					style="text-decoration: none; color: white">
					<div class="card border-0">
						<div class="card-body text-white black p-0">
							<video controls="controls"
								style="height: 12em; width: 22em; border-radius: 1%; margin: 0em">
								<source src="https://res.cloudinary.com/dqg87xvqe/video/upload/v1723582392/<%=video1.getVideo()%>.mp4" type="video/mp4">
							</video>
							<h6 class="fw-bold mt-1"><%=video1.getvTitle()%></h6>
							<p class="mb-0"><%=video1.get10Words(video1.getvDescription())%></p>
							<div class="d-flex justify-content-end">
								<a href="#" onclick="watchCount()" class="nav-link me-3"><i
									class="fa fa-eye"></i> <span class="watch-counter">2.4K</span></a>
								<a href="#" onclick="doLike()" class="nav-link me-2"><i
									class="fa fa-thumbs-up"></i> <span class="like-counter">10.5K</span></a>
							</div>
						</div>
					</div>
				</a>
			</div>
			<% 
			
			}
			%>
		</div>
	</div>
</body>
</html>
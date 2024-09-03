<%@page import="com.entity.Video"%>
<%@page import="java.util.*"%>
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
	<div class="ms-4 me-4">
		<div class="row mb-4">
			<%-- result video frame --%>
			<div class="col-md-12 mt-3">
				<%
				List<Video> video = (List<Video>) session.getAttribute("SearchResult");
				for (Video video2 : video) {
				%>
				<a href="/video/view/<%=video2.getVid()%>"
					style="text-decoration: none;">
					<div class="container">
						<div class="card-body text-white d-flex mb-2">
							<div>
								<video controls="controls"
									style="height: 20em; width: 35em; border-radius: 3%">
  									<source src="https://res.cloudinary.com/dqg87xvqe/video/upload/v1723582392/<%=video2.getVideo()%>.mp4" type="video/mp4">
								</video>
							</div>
							<div class="m-3 col-md-6">
								<h6 style="font-size: 1.5rem" class="mb-3"><%=video2.getvTitle()%></h6>
								<p style="font-size: 1rem"><%=video2.getvDescription()%></p>
								<div class="d-flex justify-content-end">
									<p  class="nav-link" style="width: 70px"><i class="fa fa-eye"></i> <span class="watch-counter">2.4K</span></p>
									<p  class="nav-link" style="width: 70px"><i class="fa fa-thumbs-up"></i> <span class="like-counter">10K</span></p>
									<p  class="nav-link" style="width: 70px"><i class="fa fa-thumbs-down"></i> <span class="dislike-counter">10K</span></p>
								</div>
							</div>
						</div>
					</div>
				</a>
				<%
				}
				%>
			</div>
			<%--Result video frame End --%>
		</div>
	</div>
</body>
</html>
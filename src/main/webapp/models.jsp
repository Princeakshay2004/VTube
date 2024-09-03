<%@ page import="com.entity.User" %>
<%
User user1=(User)request.getAttribute("CurrentUser");
%>
<!-- Video Upload Modal -->
<div class="modal fade mt-5 pt-5" id="videoModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<h5 class="text-center fw-bold">Upload Video</h5>
					<form action="/video/upload" method="post" enctype="multipart/form-data">
				    <div class="mb-3">
				    <label for="name" class="form-label">Title</label>
				    <input type="text" name="Title" class="form-control" placeholder="Enter video Title" required="required" id="title" aria-describedby="title">
				  </div>
				   <div class=" mb-3">
				  <label for="profile" class="form-label mb-0">Video</label>
				  <p class="text-warning" style="font-size: 0.8rem">Upload Video Upto 100 MB *</p>
				  <input type="file" name="video" required="required" class="form-control"id="video">
				</div>
				   <div class="mb-3">
				    <label for="email" class="form-label">Description</label>
				    <textarea cols="5" rows="4" placeholder="Enter video Description" name="Description" required="required" class="form-control" id="description" aria-describedby="description"></textarea>
				  </div>
				  <div class="mb-3">
				    <label for="number" class="form-label">Category</label>
						<select id="Category" name="Category"class="form-control" inputmode="text">
							<option selected disabled="disabled">Choose...</option>
							<option>Song</option>
							<option>Motivational</option>
							<option>Film</option>
							<option>Study</option>
							<option>Serail</option>
							<option>Sports</option>
							<option>News</option>
							<option>Farming</option>
							<option>Programming</option>
							<option>90's songs</option>
						</select>
				  </div>
				  <div class="mb-1 text-center">
			      <button type="submit" class="btn btn-primary">Upload</button>
			      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				  </div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- Video Upload Modal End -->

<!-- Profile Modal -->
<div class="modal fade mt-5 bd-example-modal-sm" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="margin-left: 35em">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
			<div class="modal-body">
				<%if(user1!=null)
					{
					%>
					<div class="text-center mb-2">
						<img src="<%=user1.profileurl(user1)%>" style="border-radius: 50%;height: 5em;width: 5em">
					</div>
					<h5 class="text-center fw-bold"><%=user1.getName()%></h5>
					
					<div class="text-center">
					<p ><%=user1.getEmail()%></p>
					<hr>
					<h6>Profile</h6>
					<div class="d-flex justify-content-center mb-3">
					 <a class="btn btn-outline-success  me-4" aria-current="page" href="/login"><i class="fa-solid fa-plus"></i> Add</a>
					 <a class="btn btn-outline-danger ms-4 " aria-current="page" href="/logout"><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
					</div>
					
					</div>
				 <div class="mb-1 text-center">
				      <button type="button" class="btn btn-secondary"data-bs-dismiss="modal">Close</button>
				  </div>
				  <%} %>
			</div>
		</div>
	</div>
</div>
<!-- Profile Modal -->


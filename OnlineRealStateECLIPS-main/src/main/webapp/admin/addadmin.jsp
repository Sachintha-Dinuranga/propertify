<%@page import="bags.Signup"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.SignupDAO"%>
<%@page import="common.MyConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
<%@include file="../common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<%@include file="../addadminheader.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 sidebar-col">
				<%@include file="common/sidebar.jsp"%>
			</div>
			<div class="col-sm-9 main-col">
				<h3>Add Admin</h3>
				<h5 style="color: green">
					<%
                            if(request.getParameter("status")!=null && request.getParameter("status").equals("success")){
                                out.print("Added Successfully.....".toUpperCase());
                            
                        %>
				</h5>
				<h5 style="color: red;">
					<% }
                            else if(request.getParameter("status")!=null && request.getParameter("status").equals("failed")){
                                out.print("Error Try Again.....".toUpperCase());
                            }
                        %>
				</h5>
				<form method="post" action="../AddAdmin_controller"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-sm-4">
							<label>Name</label> <input class="form-control" type="text"
								name="name" required="" placeholder="enter name....">
						</div>
						<div class="col-sm-4">
							<label>Contact</label> <input class="form-control" type="text"
								name="contact" required="" placeholder="enter contact no....">
						</div>
						<div class="col-sm-4">
							<label for="file">Profile Photo</label> <input
								class="form-control" type="file" name="file" required="">
						</div>
					</div>
					<br>
					<br>
					<div class="row">
						<div class="col-sm-4">
							<label>Email</label> <input class="form-control" type="text"
								name="email" required="" placeholder="enter email....">
						</div>
						<div class="col-sm-4">
							<label>Password</label> <input class="form-control"
								type="password" name="password" required=""
								placeholder="enter password....">
						</div>
						<div class="col-sm-4">
							<br>
							<button type="submit" class="btn btn-success"
								style="width: 100px; padding-top: 8px; padding-bottom: 8px; padding-left: 60px; padding-right: 100px; color: white;">
								ADD</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

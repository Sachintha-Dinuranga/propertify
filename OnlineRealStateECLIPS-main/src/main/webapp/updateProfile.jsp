<%@page import="bags.Signup"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ORES</title>
<%@include file="common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<form method="post" action="updateProfile_controller"
		enctype="multipart/form-data">
		<div class="container" style="margin-top: 40px; margin-left: 50px;">
			<div class="row">
				<div class="col-sm-12" style="margin-left: 50px;">
					<a href="profile.jsp"><input type="button" value="< BACK"
						class="btn btn-success"
						style="background-color: #404040; color: white;"></a>
				</div>
			</div>
			<br>
			<br>
			<br>
			<br>
			<div class="row" style="align-content: center;">
				<div class="col-sm-2"></div>
				<div class="col-sm-8"
					style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 1); text-align: center; margin-left: 130px; margin-top: -60px;">
					<h1>Change Details</h1>
					<div class="row"></div>
					<%
                            if(session.getAttribute("Signup")!=null){
                                Signup ub=(Signup)session.getAttribute("Signup");
                            
                        %>
					<br>
					<div class="row">
						<div class="col-sm-6" style="text-align: center;">
							<img src="<%= ub.getPath() %>" class="profileimg"
								style="width: 150px; height: 150px; border: 1px solid #7952b3; border-radius: 180px;">
						</div>
						<div class="col-sm-6" style="padding: 15px; text-align: center;">
							<div class="row">
								<div class="col-sm-12" style="padding: 15px;">
									Change profile image?<br>You can upload here &#x2193;
								</div>
								<div class="col-sm-12" style="padding: 15px;">
									<input class="update-box" type="file" id="file" name="file"
										style="width: 260px; height: 35px;">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6" style="padding: 15px;">
							<input type="text" name="name" value="<%= ub.getName()%>"
								class="form-control" required="">
						</div>
						<div class="col-sm-3"></div>
					</div>
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6" style="padding: 15px;">
							<input type="text" name="contact" value="<%= ub.getContact() %>"
								class="form-control" required="">
						</div>
						<div class="col-sm-3"></div>
					</div>
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6" style="padding: 15px;">
							<input type="email" name="email" value="<%= ub.getEmail() %>"
								class="form-control" required="">
						</div>
						<div class="col-sm-3"></div>
					</div>
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6" style="padding: 15px;">
							Change <a href="changePassword.jsp">Password</a>
						</div>
						<div class="col-sm-3"></div>
					</div>
					<br>
					<%
                           }
                        %>
					<div class="row">
						<div class="col-sm-12">
							<button class="btn btn-success" type="submit">Update</button>
						</div>
					</div>
					<br>
					<br>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
	</form>
</body>
</html>

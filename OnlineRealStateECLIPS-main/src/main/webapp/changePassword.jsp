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
	<form method="post" action="changePassword">
		<div class="container" style="margin-top: 100px;">
			<div class="row">
				<div class="col-sm-12">
					<a href="updateProfile.jsp"><input type="button" value="< BACK"
						class="btn btn-success"
						style="background-color: #404040; color: white;"></a><br>
					<br>
				</div>
			</div>
			<%
                    if(session.getAttribute("Signup")!=null){
                        Signup s=(Signup) session.getAttribute("Signup");
                %>
			<div class="container">
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4"
						style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
						<div class="row">
							<br>
							<div class="col-sm-12" style="text-align: center;">
								<h1>Change Password</h1>
							</div>
						</div>
						<br>
						<br>
						<div class="row">
							<div class="col-sm-12" style="text-align: center;">
								<input type="text" value="<%= s.getEmail() %>"
									class="form-control" name="email" readonly="">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-12">
								<input type="password" name="cpassword" class="form-control"
									placeholder="current password.." required="">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-12">
								<input type="password" name="npassword" class="form-control"
									placeholder="new password.." required="">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-12" style="text-align: center;">
								<button class="btn btn-success">Submit</button>
							</div>
							<br>
							<br>
							<br>
						</div>
					</div>
					<div class="col-sm-4"></div>
				</div>
			</div>
			<%
                    }
                %>
		</div>
	</form>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up</title>
<%@include file="common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<%@include file="common/header.jsp"%>

	<div class="container signup">
		<h1>SIGN UP</h1>
		<%
                if(request.getParameter("info")!=null){
                    out.print("<h4>Check Contact and Email once again ! !</h4>");
                }
            %>
		<form method="post" action="Signup" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<label>Name</label> <input class="form-control" type="text"
						name="name" required="">
				</div>
				<div class="col-sm-6">
					<label>Contact</label> <input class="form-control" type="text"
						name="contact" required="">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label>Email</label> <input class="form-control" type="email"
						name="email" required="">
				</div>
				<div class="col-sm-6">
					<label>Password</label> <input class="form-control" type="password"
						name="password" required="">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label>Profile image</label> <input class="upload-box" type="file"
						id="file" name="file" required="">
				</div>
				<div class="col-sm-6" style="margin-top: 30px;">
					<button type="submit" class="btn btn-success">Submit</button>
					<b style="margin-left: 40px;">Click on Sign in if already have
						an account?</b> <a href="signin.jsp">Sign In</a>
				</div>
			</div>
		</form>
	</div>

	<%@include file="common/footer.jsp"%>
</body>
</html>

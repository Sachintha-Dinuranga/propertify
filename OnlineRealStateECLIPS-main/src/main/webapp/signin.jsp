<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in</title>
<%@include file="common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<%@include file="common/header.jsp"%>

	<div class="container signup">
		<h1>SIGN IN</h1>
		<%
                if(request.getParameter("info")!=null){
                    out.print("<h4><b style='color: red'>Email</b> is invalid</h4>");
                }
            %>
		<form method="post" action="Signin">
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
				<div class="col-sm-12">
					<button type="submit" class="btn btn-success">Login</button>
					<b>Click on Sign up if not registered?</b> <a href="signup.jsp">Sign
						up</a>
				</div>
			</div>
		</form>
	</div>

	<%@include file="common/footer.jsp"%>
</body>
</html>

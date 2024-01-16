<%@page import="bags.Signup"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ORES</title>
</head>
<body>
	<div class="container"
		style="margin-top: 30px; margin-left: 50px; padding: 10px;">
		<div class="row"
			style="margin-top: 30px; margin-left: 150px; padding: 10px;">
			<div class="col-sm-12">
				<a href="dashboard.jsp"><button class="btn btn-success"
						style="background-color: #404040; color: white; padding: 10px;"><
						Back</button></a>
			</div>
		</div>
		<%
                if(request.getAttribute("profile")!=null){
                    Signup s=(Signup)request.getAttribute("profile");
            %>
		<div class="row" style="text-align: center; padding: 20px;">
			<div class="col-sm-12">
				<img src="<%= s.getPath() %>"
					style="border: 1px solid #404040; border-radius: 180px;">
			</div>
		</div>
		<div class="row"
			style="text-align: center; padding: 10px; font-size: 20px;">
			<div class="col-sm-12">
				<%= s.getName()%>
			</div>
		</div>
		<div class="row"
			style="text-align: center; padding: 10px; font-size: 20px;">
			<div class="col-sm-12">
				<%= s.getContact()%>
			</div>
		</div>
		<div class="row"
			style="text-align: center; padding: 10px; font-size: 20px;">
			<div class="col-sm-12">
				<%= s.getEmail()%>
			</div>
		</div>
		<div class="row"
			style="text-align: center; padding: 10px; font-size: 20px;">
			<div class="col-sm-12">
				<%= s.getRole()%>
			</div>
		</div>
		<%
                }
            %>
	</div>
</body>
</html>

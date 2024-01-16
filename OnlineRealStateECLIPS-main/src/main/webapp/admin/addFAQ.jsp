<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	<%@include file="../header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 sidebar-col">
				<%@include file="common/sidebar.jsp"%>
			</div>
			<div class="col-sm-9 main-col">
				<form method="post" action="../addFAQ_controller">
					<h2>FAQ'S</h2>
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
					<div class="row">
						<div class="col-sm-4">
							<input type="text" class="form-control" name="faqtitle"
								placeholder="FAQ Title...">
						</div>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="faqs"
								placeholder="FAQ Solution...">
						</div>
						<div class="col-sm-4">
							<a href=""><button class="btn btn-success">Add</button></a>
						</div>
					</div>
				</form>
				<br>
				<hr>
				<br>
				<div class="row">
					<%
                        String sqld="select * from faq";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection connd=DriverManager.getConnection("jdbc:mysql://localhost:3306/ores","root","");
                        Statement std=connd.createStatement();
                        ResultSet rsd=std.executeQuery(sqld);
                        while(rsd.next()){
                            Signup s=new Signup();
                            s.setFaqtitle(rsd.getString("faqtitle"));
                            s.setFaqsolution(rsd.getString("faqsolution"));
                    %>
					<div class="col-sm-6">
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton" data-toggle="dropdown"
								aria-haspopup="true"
								style="background: #404040; color: white; font-size: 15px; padding: 10px;"><%= s.getFaqtitle() %>&nbsp;&nbsp;<b
									class="caret" style="background-color: #7952b3; color: white;"></b>
							</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<span class="dropdown-item"
									style="padding: 20px; font-size: 15px; text-align: left;"><%= s.getFaqsolution() %></span>
							</div>
						</div>
					</div>
					<%
                        }
                    %>
				</div>

			</div>
		</div>
	</div>
</body>
</html>

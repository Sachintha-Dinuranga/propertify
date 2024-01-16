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
				<h3>User List</h3>
				<div style="color: green">
					<%
                            if(request.getParameter("status")!=(null)){
                                out.print(" "+request.getParameter("status").toUpperCase());
                            }
                        %>
				</div>
				<table class="table table-bordered">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Contact</th>
						<th>Email</th>
						<th>Role</th>
						<th>View Profile</th>
						<th>Delete</th>
					</tr>
					<%
                        List lt =new SignupDAO(MyConnection.connectTo()).getAlldata();
                        ListIterator li=lt.listIterator();
                        while(li.hasNext()){
                            
                            Signup sb=(Signup)li.next();
                    %>
					<tr>
						<td><%= sb.getId() %></td>
						<td><%= sb.getName() %></td>
						<td><%= sb.getContact() %></td>
						<td><%= sb.getEmail() %></td>
						<td><%= sb.getRole() %></td>
						<td><a href="../viewProfile?id=<%= sb.getId() %>"><span
								class="glyphicon glyphicon-eye-open"></span></a></td>
						<td><a href="../signupDelete?id=<%= sb.getId() %>"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>

					<%
                        }
                    %>
				</table>
				<br>
				<br>
				<br>
				<br>
			</div>
		</div>
	</div>
</body>
</html>

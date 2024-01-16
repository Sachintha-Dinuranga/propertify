<%@page import="bags.property_bag"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.Property_DAO"%>
<%@page import="common.MyConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home Page</title>
<%@include file="../common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="container">
		<div class="row" style="padding-top: 20px;">
			<a href="#"><div class="col-sm-3"
					style="background-color: greenyellow; border: 1px solid green; border-radius: 10px; padding: 30px;">
					<%
                        Property_DAO pd=new Property_DAO(MyConnection.connectTo());
                        List l=pd.getCount();
                        Iterator iterator=l.iterator();
                        while(iterator.hasNext()){
                            property_bag pb=(property_bag)iterator.next();
                        
                    %>
					<div
						style="text-align: right; font-size: 25px; padding-bottom: 10px; color: green;">Total
						Properties</div>
					<div style="text-align: right; font-size: 50px; color: green;">
						<span class="glyphicon glyphicon-home"
							style="padding-right: 100px; font-size: 50px; color: green;"></span><%= pb.getPid()%></div>
					<% } %>
				</div></a>
			<div class="col-sm-1"></div>
			<a href="dashboard.jsp"><div class="col-sm-3"
					style="background-color: pink; border: 1px solid purple; border-radius: 10px; padding: 30px;">
					<%
                        Property_DAO pduser=new Property_DAO(MyConnection.connectTo());
                        List luser=pduser.getCountUser();
                        Iterator iuser=luser.iterator();
                        while(iuser.hasNext()){
                            property_bag pbuser=(property_bag)iuser.next();
                        
                    %>
					<div
						style="text-align: right; font-size: 25px; padding-bottom: 10px; color: purple;">Total
						Users</div>
					<div style="text-align: right; font-size: 50px; color: purple;">
						<span class="glyphicon glyphicon-user"
							style="padding-right: 100px; font-size: 50px; color: purple;"></span><%= pbuser.getId() %></div>
					<% } %>
				</div></a>

			<div class="col-sm-1"></div>
			<a href="SideAllAdmin.jsp"><div class="col-sm-3"
					style="background-color: lightskyblue; border: 1px solid blue; border-radius: 10px; padding: 30px;">
					<div
						style="text-align: right; font-size: 25px; padding-bottom: 10px; color: blue;">Total
						Admins</div>
					<%
                        Property_DAO pdadmin=new Property_DAO(MyConnection.connectTo());
                        List ladmin=pdadmin.getCountAdmin();
                        Iterator iadmin=ladmin.iterator();
                        while(iadmin.hasNext()){
                            property_bag pbadmin=(property_bag)iadmin.next();
                        
                    %>

					<div style="text-align: right; font-size: 50px; color: blue;">
						<span class="glyphicon glyphicon-user"
							style="padding-right: 100px; font-size: 50px; color: blue;"></span><%= pbadmin.getId() %></div>
					<% } %>
				</div></a>


		</div>
	</div>
	<%@include file="common/footer.jsp"%>
</body>
</html>

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
<title>Farmhouses</title>
<%@include file="common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<%@include file="common/header.jsp"%>
	<div class="container-fluid">
		<section class="property-section">
			<h1 style="text-align: center">Farmhouses</h1>
			<div class="row">
				<%
                        Property_DAO pd=new Property_DAO(MyConnection.connectTo());
                        if(session.getAttribute("Signup")!=null){
                            Signup sb=(Signup) session.getAttribute("Signup");
                        System.err.println("Go in getMyProperty:---");
                        List lia=pd.getFarmhouse(sb);
                        System.err.println("lia first-- "+lia);
                        Iterator iter1=lia.iterator();
                        while(iter1.hasNext()){
                            property_bag pb=(property_bag)iter1.next();
                            
                    %>
				<div class="col-sm-3" style="padding: 30px;">
					<div class="property_wrapper" style="text-align: center;">
						<img src="<%= pb.getPath()%>" class="pimg"
							style="width: 300px; height: 260px; display: inline; border: 1px solid black; border-radius: 5px;"><br>
						<br>

						<div class="property_pname">
							<h4 style="font-weight: bold; display: inline;">Property
								Name:</h4>
							<h4 style="display: inline;"><%= pb.getPname() %></h4>
						</div>
						<br>
						<div class="property_price">
							<h4 style="font-weight: bold; display: inline">Price:</h4>
							<h4 style="display: inline;"><%= pb.getPrice() %>
								<span>&#8377;</span>
							</h4>
						</div>
						<br>
						<div class="property_cityname">
							<h4 style="font-weight: bold; display: inline">City name:</h4>
							<h4 style="display: inline;"><%= pb.getCityname() %></h4>
						</div>
						<br>
						<div class="property_srproperty">
							<h4 style="font-weight: bold; display: inline">Property
								status:</h4>
							<h4 style="display: inline;"><%= pb.getSrproperty() %></h4>
						</div>
						<br>
						<div class="property_ptype">
							<h4 style="font-weight: bold; display: inline">Type:</h4>
							<h4 style="display: inline;"><%= pb.getPtype() %></h4>
						</div>
						<br>
						<div class="property_psubtype">
							<h4 style="font-weight: bold; display: inline">Sub-Type:</h4>
							<h4 style="display: inline;"><%= pb.getPsubtype() %></h4>
						</div>
						<br> <a href="checkOut?pid=<%= pb.getPid()%>"><button
								class="userbutton">Check Out</button></a><br>
						<br>
					</div>
					<br>
					<br>
				</div>
				<%
                        }}
                    %>
			</div>
		</section>
	</div>
	<%@include file="common/footer.jsp"%>
</body>
</html>

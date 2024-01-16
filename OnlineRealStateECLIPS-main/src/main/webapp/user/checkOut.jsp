<%@page import="bags.Signup"%>
<%@page import="DAO.SignupDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.Property_DAO"%>
<%@page import="common.MyConnection"%>
<%@page import="bags.property_bag"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ORES</title>
<%@include file="../common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<div class="container-fluid"
		style="margin-top: 50px; margin-left: 100px;">
		<div class="row">
			<div class="col-sm-12">
				<a href="../index.jsp"><input type="button" value="< BACK"
					class="btn btn-success"
					style="background-color: #404040; color: white;"></a>
			</div>
		</div>
	</div>
	<br>
	<%
            if(session.getAttribute("checkOut")!=null){
                property_bag pb=(property_bag)session.getAttribute("checkOut");
        %>
	<form>
		<div class="container" style="text-align: center;">
			<div class="row">
				<div class="col-sm-6">
					<img src="../<%= pb.getPath() %>" width="500" height="500"
						style="border: 3px solid #404040; border-radius: 30px;">
				</div>
				<div class="col-sm-6">
					<br>
					<div class="row">
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Area</label><br>
							<h5><%= pb.getArea()%>&nbsp;<%= pb.getAreasq() %></h5>
						</div>
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Bathroom</label><br>
							<h5><%= pb.getBathroom()%></h5>
						</div>
					</div>
					<br>
					<br>
					<div class="row">
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Price</label>
							<h5>
								<span>&#8360;&nbsp;</span><%= pb.getPrice() %></h5>
						</div>
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Bedroom</label>
							<h5><%= pb.getBedroom()%></h5>
						</div>
					</div>
					<br>
					<br>
					<div class="row">
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Type</label>
							<h5><%= pb.getPtype()%></h5>
						</div>
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Status</label>
							<h5><%= pb.getSrproperty()%></h5>
						</div>
					</div>
					<br>
					<br>
					<div class="row">
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>City</label>
							<h5><%= pb.getCityname()%></h5>
						</div>
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Pin-code</label>
							<h5><%= pb.getPincode()%></h5>
						</div>
					</div>
					<br>
					<br>
					<div class="row">
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Sub-type</label>
							<h5><%= pb.getPsubtype()%></h5>
						</div>
						<div class="col-sm-6"
							style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
							<label>Contact</label>
							<h5><%= pb.getContact()%></h5>
						</div>
					</div>
					<br>
					<br>
				</div>
			</div>
			<br>
			<br>
			<div class="row"
				style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
				<div class="col-sm-6" style="text-align: left;">
					<h2>About property</h2>
					<br> <label>Address</label>
					<h4><%= pb.getAddress() %></h4>
					<br> <label>Details</label>
					<h4><%= pb.getDetails() %></h4>
				</div>
				<div class="col-sm-6" style="text-align: center;">
					<%= pb.getLocation() %>
				</div>
				<br>
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col-sm-12"
					style="box-shadow: 0 20px 50px 0 rgba(68, 88, 144, 0.1);">
					<div class="row">
						<%
                                            SignupDAO sd=new SignupDAO(MyConnection.connectTo());
                                            Signup s=sd.getProfile(pb.getId());
                                            
                                        %>

						<div class="col-sm-6">
							<div class="row" style="padding: 10px;">
								<h3>Owner details</h3>
								<br>
								<div class="col-sm-6">
									<img src="../<%= s.getPath() %>" width="200" height="200"
										style="border: 1px solid #404040; border-radius: 20px;">
								</div>
								<div class="col-sm-6" style="text-align: left;">
									<h4><%= s.getName() %></h4>
									<h4><%= s.getEmail() %></h4>
									<h4><%= s.getContact() %></h4>
								</div>
							</div>
						</div>
						<%
            }
        %>
						<div class="col-sm-6">
							<h3>Send enquiry to Owner</h3>
							<br> <input type="text" name="name" class="form-control"
								placeholder="Name"><br> <input type="email"
								name="email" class="form-control" placeholder="Email"><br>
							<textarea placeholder="I am interested in this Property."
								style="width: 200; height: 400;" class="form-control"
								maxlength="400"></textarea>
							<br> <input type="button" class="btn btn-success"
								style="color: white;" value="Send Email">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<form>
		<div class="container">
			<div class="row">
				<h1 style="text-align: center;">Similar Properties</h1>
				<%
                    Property_DAO pd=new Property_DAO(MyConnection.connectTo());
                    List lia=pd.getAlldata2();
                    Iterator iter1=lia.iterator();
                    while(iter1.hasNext()){
                        property_bag pb2=(property_bag)iter1.next();
                        %>
				<div class="col-sm-3" style="padding: 20px;">
					<div class="property_wrapper" style="text-align: center;">
						<img src="../<%= pb2.getPath()%>" class="pimg"
							style="width: 185px; height: 185px; display: inline; border: 1px solid black; border-radius: 5px;"><br>
						<br>

						<div class="property_pname">
							<h5 style="font-weight: bold; display: inline;">Property
								Name:</h5>
							<h5 style="display: inline;"><%= pb2.getPname() %></h5>
						</div>
						<div class="property_price">
							<h5 style="font-weight: bold; display: inline">Price:</h5>
							<h5 style="display: inline;"><%= pb2.getPrice() %>
								<span>&#8360;</span>
							</h5>
						</div>
						<div class="property_cityname">
							<h5 style="font-weight: bold; display: inline">City name:</h5>
							<h5 style="display: inline;"><%= pb2.getCityname() %></h5>
						</div>
						<div class="property_srproperty">
							<h5 style="font-weight: bold; display: inline">Property
								status:</h5>
							<h5 style="display: inline;"><%= pb2.getSrproperty() %></h5>
						</div>
						<div class="property_ptype">
							<h5 style="font-weight: bold; display: inline">Type:</h5>
							<h5 style="display: inline;"><%= pb2.getPtype() %></h5>
						</div>
						<div class="property_psubtype">
							<h5 style="font-weight: bold; display: inline">Sub-Type:</h5>
							<h5 style="display: inline;"><%= pb2.getPsubtype() %></h5>
						</div>
						<a href="../../checkOut?pid=<%= pb2.getPid()%>"><button
								class="userbutton">Check Out</button></a><br>
						<br>
					</div>
					<br>
				</div>
				<%
                    }
                    %>
			</div>

		</div>
	</form>

</body>
</html>

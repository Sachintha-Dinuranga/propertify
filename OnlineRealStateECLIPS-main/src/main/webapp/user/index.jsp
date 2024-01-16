
<%@page import="bags.property_bag"%>
<%@page import="java.util.Iterator"%>
<%@page import="DAO.Property_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home Page</title>
<%@include file="../common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">



</head>
<body>
	<%@include file="common/header.jsp"%>
	<div class="container-fluid">



		<!-----------property section------------>
		<section class="property-section">
			<h1 style="text-align: center">Latest Properties</h1>
			<div class="row">
				<%
                    Property_DAO pd=new Property_DAO(MyConnection.connectTo());
                    List lia=pd.getAlldata();
                    Iterator iter1=lia.iterator();
                    while(iter1.hasNext()){
                        property_bag pb=(property_bag)iter1.next();
                        %>
				<div class="col-sm-3">
					<div class="property_wrapper">
						<img
							src="img\house.jpg"
							class="pimg">
						<div class="property_pname">
							Property Name:
							<%= pb.getPname() %></div>
						<div class="property_price">
							Price:
							<%= pb.getPrice() %>
							Rs
						</div>
						<div class="property_cityname">
							City name:
							<%= pb.getCityname() %></div>
						<div class="property_srproperty">
							To:
							<%= pb.getSrproperty() %></div>
						<div class="property_ptype">
							Type:
							<%= pb.getPtype() %></div>
						<div class="property_psubtype">
							Sub-Type:
							<%= pb.getPsubtype() %></div>
						<br> <input type="button" class="userbutton"
							value="CHECK OUT">
					</div>
				</div>
				<%
                    }
                    %>
			</div>
		</section>
		<!---------property section----------->


		<!---------banner section---------->
		<section class="banner-section">
			<div class="row">
				<div class="col-sm-12">
					<img
						src="img\propertybanner1.jpg">
				</div>
			</div>
		</section>

		<!---------banner section---------->



		<!-----------property section------------>
		<section class="property-section">
			<h1 style="text-align: center">Properties for Rent</h1>
			<div class="row">
				<%
                    
                    List lrent=pd.getAlldataRent();
                    Iterator irent=lrent.iterator();
                    while(irent.hasNext()){
                        property_bag pb=(property_bag) irent.next();
                        %>
				<div class="col-sm-3">
					<div class="property_wrapper">
						<img
							src="img\house.jpg"
							class="pimg">
						<div class="property_pname">
							Property Name:
							<%= pb.getPname() %></div>
						<div class="property_price">
							Price:
							<%= pb.getPrice() %>
							Rs
						</div>
						<div class="property_cityname">
							City name:
							<%= pb.getCityname() %></div>
						<div class="property_srproperty">
							To:
							<%= pb.getSrproperty() %></div>
						<div class="property_ptype">
							Type:
							<%= pb.getPtype() %></div>
						<div class="property_psubtype">
							Sub-Type:
							<%= pb.getPsubtype() %></div>
						<br> <input type="button" class="userbutton"
							value="CHECK OUT">
					</div>
				</div>
				<%
                    }
                    %>
			</div>
		</section>
		<!---------property section----------->

		<!---------banner section---------->
		<section class="banner-section">
			<div class="row">
				<div class="col-sm-12">
					<img
						src="img\propertybanner21.jpg">
				</div>
			</div>
		</section>

		<!---------banner section---------->



		<!-----------property section------------>
		<section class="property-section">
			<h1 style="text-align: center">Properties for Sell</h1>
			<div class="row">
				<%
                    
                    List lsell=pd.getAlldataSell();
                    Iterator isell=lsell.iterator();
                    while(isell.hasNext()){
                        property_bag pb=(property_bag) isell.next();
                        %>
				<div class="col-sm-3">
					<div class="property_wrapper">
						<img
							src="img\banner3.jpg"
							class="pimg">
						<div class="property_pname">
							Property Name:
							<%= pb.getPname() %></div>
						<div class="property_price">
							Price:
							<%= pb.getPrice() %>
							Rs
						</div>
						<div class="property_cityname">
							City name:
							<%= pb.getCityname() %></div>
						<div class="property_srproperty">
							To:
							<%= pb.getSrproperty() %></div>
						<div class="property_ptype">
							Type:
							<%= pb.getPtype() %></div>
						<div class="property_psubtype">
							Sub-Type:
							<%= pb.getPsubtype() %></div>
						<br> <input type="button" class="userbutton"
							value="CHECK OUT">
					</div>
				</div>
				<%
                    }
                    %>
			</div>
		</section>
		<!---------property section----------->

		<!---------banner section---------->
		<section class="banner-section">
			<div class="row">
				<div class="col-sm-12">
					<img
						src="img\Properties\villa_200.jfif">
				</div>
			</div>
		</section>

		<!---------banner section---------->


	</div>
	<%@include file="common/footer.jsp"%>
</body>
</html>

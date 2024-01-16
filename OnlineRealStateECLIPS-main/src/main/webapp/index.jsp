<%@page import="bags.property_bag"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.Property_DAO"%>
<%@page import="common.MyConnection"%>
<%@include file="admin/common/login_check.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@include file="common/cdn.jsp" %>
        <link rel="stylesheet" href="css/common.css">
    </head>
    <body>
        <%@include file="common/header.jsp" %>
        <header class="masthead">
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">WELCOME TO PROPERTYFY ! !</div>
                <div class="intro-heading text-uppercase">Your dream property, just a click away<br></div>
            </div>
        </div>
        </header>
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
                        <div class="col-sm-2" style="padding: 20px;">
                            <div class="property_wrapper" style="text-align: center;">
                                <img src="<%= pb.getPath()%>" class="pimg" style="width: 175px; height: 185px; display: inline; border: 1px solid black; border-radius: 5px;"><br><br>
                                
                                <div class="property_pname">
                                    <h5 style="font-weight: bold; display: inline;">Property Name: </h5>
                                    <h5 style="display: inline;"><%= pb.getPname() %></h5>
                                </div>
                                <div class="property_price">
                                    <h5 style="font-weight: bold; display: inline">Price: </h5>
                                    <h5 style="display: inline;"><span>&#8360;&nbsp;</span><%= pb.getPrice() %></h5>
                                </div>
                                <div class="property_cityname">
                                    <h5 style="font-weight: bold; display: inline">City name: </h5>
                                    <h5 style="display: inline;"><%= pb.getCityname() %></h5>
                                </div>
                                <div class="property_srproperty">
                                    <h5 style="font-weight: bold; display: inline">Property status: </h5>
                                    <h5 style="display: inline;"><%= pb.getSrproperty() %></h5>
                                </div>
                                <div class="property_ptype">
                                    <h5 style="font-weight: bold; display: inline">Type: </h5>
                                    <h5 style="display: inline;"><%= pb.getPtype() %></h5>
                                </div>
                                <div class="property_psubtype">
                                    <h5 style="font-weight: bold; display: inline">Sub-Type: </h5>
                                    <h5 style="display: inline;"><%= pb.getPsubtype() %></h5>
                                </div><br>
                                    <a href="checkOut?pid=<%= pb.getPid()%>"><button class="userbutton">Check Out</button></a><br><br>
                            </div><br>
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
                    <img src="img\banner1.png">
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
                        <div class="col-sm-3" style="padding: 30px;">
                            <div class="property_wrapper" style="text-align: center;">
                                <img src="<%= pb.getPath()%>" class="pimg" style="width: 300px; height: 260px; display: inline; border: 1px solid black; border-radius: 5px;"><br><br>
                                
                                <div class="property_pname">
                                    <h4 style="font-weight: bold; display: inline;">Property Name: </h4>
                                    <h4 style="display: inline;"><%= pb.getPname() %></h4>
                                </div><br>
                                <div class="property_price">
                                    <h4 style="font-weight: bold; display: inline">Price: </h4>
                                    <h4 style="display: inline;"><span>&#8360;&nbsp;</span><%= pb.getPrice() %> </h4>
                                </div><br>
                                <div class="property_cityname">
                                    <h4 style="font-weight: bold; display: inline">City name: </h4>
                                    <h4 style="display: inline;"><%= pb.getCityname() %></h4>
                                </div><br>
                                <div class="property_srproperty">
                                    <h4 style="font-weight: bold; display: inline">Property status: </h4>
                                    <h4 style="display: inline;"><%= pb.getSrproperty() %></h4>
                                </div><br>
                                <div class="property_ptype">
                                    <h4 style="font-weight: bold; display: inline">Type: </h4>
                                    <h4 style="display: inline;"><%= pb.getPtype() %></h4>
                                </div><br>
                                <div class="property_psubtype">
                                    <h4 style="font-weight: bold; display: inline">Sub-Type: </h4>
                                    <h4 style="display: inline;"><%= pb.getPsubtype() %></h4>
                                </div><br>
                                <a href="checkOut?pid=<%= pb.getPid()%>"><button class="userbutton">Check Out</button></a><br><br>
                            </div><br><br>
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
                    <img src="img\banner2.png">
                </div>
            </div>
            </section>
            
             <!---------banner section---------->
             <!-----------property section------------>
             <section class="property-section">
                 <h1 style="text-align: center">Properties for Sale</h1>
            <div class="row">
                <%
                    
                    List lsell=pd.getAlldataSell();
                    Iterator isell=lsell.iterator();
                    while(isell.hasNext()){
                        property_bag pb=(property_bag) isell.next();
                        %>
                        <div class="col-sm-3" style="padding: 30px;">
                            <div class="property_wrapper" style="text-align: center;">
                                <img src="<%= pb.getPath()%>" class="pimg" style="width: 270px; height: 260px; display: inline; border: 1px solid black; border-radius: 5px;"><br><br>
                                
                                <div class="property_pname">
                                    <h4 style="font-weight: bold; display: inline;">Property Name: </h4>
                                    <h4 style="display: inline;"><%= pb.getPname() %></h4>
                                </div><br>
                                <div class="property_price">
                                    <h4 style="font-weight: bold; display: inline">Price: </h4>
                                    <h4 style="display: inline;"><span>&#8360;&nbsp;</span><%= pb.getPrice() %></h4>
                                </div><br>
                                <div class="property_cityname">
                                    <h4 style="font-weight: bold; display: inline">City name: </h4>
                                    <h4 style="display: inline;"><%= pb.getCityname() %></h4>
                                </div><br>
                                <div class="property_srproperty">
                                    <h4 style="font-weight: bold; display: inline">Property status: </h4>
                                    <h4 style="display: inline;"><%= pb.getSrproperty() %></h4>
                                </div><br>
                                <div class="property_ptype">
                                    <h4 style="font-weight: bold; display: inline">Type: </h4>
                                    <h4 style="display: inline;"><%= pb.getPtype() %></h4>
                                </div><br>
                                <div class="property_psubtype">
                                    <h4 style="font-weight: bold; display: inline">Sub-Type: </h4>
                                    <h4 style="display: inline;"><%= pb.getPsubtype() %></h4>
                                </div><br>
                                <a href="checkOut?pid=<%= pb.getPid()%>"><button class="userbutton">Check Out</button></a><br><br>
                            </div><br><br>
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
                    <img src="img\banner3.png">
                </div>
            </div>
            </section>
            
             <!---------banner section---------->
            
        </div>
        <%@include file="common/footer.jsp" %>
    </body>
</html>
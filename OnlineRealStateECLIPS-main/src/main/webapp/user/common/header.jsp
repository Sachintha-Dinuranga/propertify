<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.SignupDAO"%>
<%@page import="common.MyConnection"%>
<%@page import="bags.Signup"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp"><b class="o">O</b>RES</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="../index.jsp">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Properties<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="property.jsp">Sell</a></li>
						<li><a href="search.jsp">Buy</a></li>
						<li><a href="#">Rent</a></li>
					</ul></li>
				<li><a
					href="user\property.jsp">Post
						your Property</a></li>



				<%
         List list =new SignupDAO(MyConnection.connectTo()).getDBName();
         ListIterator literator=list.listIterator();
         while(literator.hasNext()){
             Signup sb=(Signup)literator.next();
         
      %>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><span
						class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<%= sb.getName() %><span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li><a href="#">My Properties</a></li>
						<li><a href="../mainindex.jsp">Logout</a></li>
						<%
              }
              %>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="search.jsp"><span
						class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;Search</a></li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
	</div>
</nav>


<%@page import="bags.Signup"%>
<nav class="navbar navbar-inverse"
	style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp"><img
				src="../img\ores logos\oresadminfinal.png
				width="135" height="80" style="margin-top: -28px;"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">HOME</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">PROPERTIES<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="Apartment.jsp">Apartment</a></li>
						<li><a href="Villa.jsp">Independent House/Villa</a></li>
						<li><a href="Floor.jsp">Independent/Builder Floor</a></li>
						<li><a href="Land.jsp">Land</a></li>
						<li><a href="Farmhouse.jsp">Farmhouse</a></li>
					</ul></li>
				<li class="dropdown">
					<%
                if(session.getAttribute("Signup") !=null){
                      Signup sb=(Signup) session.getAttribute("Signup");
                %> <a class="dropdown-toggle" data-toggle="dropdown"
					href="#"> <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;
						<b style="text-transform: uppercase; font-weight: normal;"> <%= sb.getName()%></b>
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<% 
                      if(sb.getRole().equals("admin")){
                          %>
						<li><a class="dropdown-item" href="profile.jsp"><span
								class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;&nbsp;PROFILE</a></li>
						<li><a class="dropdown-item" href="admin/dashboard.jsp"><span
								class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;&nbsp;&nbsp;DASHBOARD</a></li>
						<li><a class="dropdown-item" href="Logout_controller"><span
								class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;&nbsp;&nbsp;LOGOUT</a></li>

						<%
                      }
                      else if(sb.getRole().equals("user")){
                          %>
						<li><a class="dropdown-item" href="postproperty.jsp"><span
								class="glyphicon glyphicon-upload" style="font-size: 20px;"></span>&nbsp;&nbsp;&nbsp;&nbsp;POST
								YOUR PROPERTY</a></li>
						<li><a class="dropdown-item" href="profile.jsp"><span
								class="glyphicon glyphicon-user" style="font-size: 20px;"></span>&nbsp;&nbsp;&nbsp;&nbsp;PROFILE</a></li>
						<li><a class="dropdown-item" href="MyProperties.jsp"><span
								class="glyphicon glyphicon-king" style="font-size: 20px;"></span>&nbsp;&nbsp;&nbsp;&nbsp;MY
								PROPERTIES</a></li>
						<li><a class="dropdown-item" href="Logout_controller"><span
								class="glyphicon glyphicon-log-out" style="font-size: 20px;"></span>&nbsp;&nbsp;&nbsp;&nbsp;LOGOUT</a></li>
					</ul>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="user/search.jsp"><span
						class="glyphicon glyphicon-search"></span>&nbsp;Search</a></li>
				<li><a href="user/contact.jsp">CONTACT</a></li>
				<li><a href="user/faq.jsp">FAQs</a></li>
			</ul>
			<%
                        }
                        }
                        else
                        {
                     %>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="signup.jsp"><span
						class="glyphicon glyphicon-user"></span>&nbsp;SIGN UP</a></li>
				<li><a href="signin.jsp"><span
						class="glyphicon glyphicon-log-in"></span>&nbsp;LOGIN</a></li>
				<%
                            }
                         %>
			</ul>
		</div>
	</div>
</nav>


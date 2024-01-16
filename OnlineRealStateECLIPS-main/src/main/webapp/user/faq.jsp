<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
<%@include file="../common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<%@include file="../faq_header.jsp"%>
	<form>
		<div class="container signup">
			<div class="row">
				<div class="col-sm-12">
					<h1 style="text-align: center">FAQs</h1>
				</div>
			</div>
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
				<div class="col-sm-4">
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
	</form>
	<%@include file="common/footer.jsp"%>
</body>
</html>

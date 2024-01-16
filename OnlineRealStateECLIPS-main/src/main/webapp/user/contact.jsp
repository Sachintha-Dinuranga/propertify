
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
<%@include file="../common/cdn.jsp"%>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<%@include file="../contact_header.jsp"%>

	<div class="container signup">
		<h1 style="text-align: center">CONTACT</h1>
		<h3 style="padding-bottom: 20px;">Enter details</h3>
		<form method="post" action="../contact">
			<div class="row">
				<%
                        if(session.getAttribute("Signup")!=null){
                            Signup sb=(Signup) session.getAttribute("Signup");
                        %>

				<div class="col-sm-4">
					<label>Name</label> <input class="form-control" type="text"
						name="name" required="" placeholder="Enter name..."
						value="<%= sb.getName() %>">
				</div>
				<div class="col-sm-4">
					<label>Contact</label> <input class="form-control" type="text"
						name="contact" required="" placeholder="Enter phone number..."
						value="<%= sb.getContact() %>">
				</div>
				<div class="col-sm-4">
					<label>Email</label> <input class="form-control" type="email"
						name="email" required="" placeholder="Enter Registered Email..."
						value="<%= sb.getEmail() %>">
				</div>
				<% } %>
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col-sm-3">
					<label>Reason of Contact</label><br> <select name="intention"
						id="intention" class="intention" required="">
						<option value="Complain">Complain</option>
						<option value="Suggestion">Suggestion</option>
						<option value="Feedback" selected="">Feedback</option>
						<option value="Enquiry">Enquiry</option>
						<option value="Others">Others</option>
					</select>
				</div>
				<div class="col-sm-9">
					<label>Comment</label> <input class="form-control" type="text"
						name="comment" required="" placeholder="Enter Comment...">
				</div>
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col-sm-12">
					<button class="contactbtn">SUBMIT</button>
				</div>
			</div>
		</form>
	</div>

	<%@include file="common/footer.jsp"%>
</body>
</html>

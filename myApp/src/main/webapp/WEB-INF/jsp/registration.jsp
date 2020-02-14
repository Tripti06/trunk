<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body
	style="height: 500px; width: 500px; position: fixed; top: 50%; left: 50%; margin-top: -200px; margin-left: -300px;">
	<a type="button" class="btn btn-warning btn-sm"
		href="${pageContext.request.contextPath}/">Home</a>
	<br><br><br>
	<br><br><br>
	<div id="registerEmployee">
		<form:form action="/register" method="post" modelAttribute="user">
			<fieldset>
				<legend style="color: #FF1493">Register New User</legend>
				<p>
					<label>Enter Username</label>
					<form:input path="username" />
				</p>

				<p>
					<label>Enter Password</label>
					<form:input path="password" />
				</p>
				<p>
					<label>Select Authority</label>
					<form:checkbox path="authority" value="ROLE_ADMIN" />
					Admin
					<form:checkbox path="authority" value="ROLE_USER" />
					User
				</p>
				<input type="SUBMIT" value="Submit" class="btn btn-info btn-sm" />
			</fieldset>
		</form:form>

	</div>

</body>
</html>
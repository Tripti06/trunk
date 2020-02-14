<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="background-image: url('/coloured.jpg'); background-repeat: no-repeat;  background-size: 500px 500px;">
<div>
<table class = "table table-responsive" width='100%'>
	<tr>
		<th ><a type="button" class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/">Home</a></th>

		<th >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th ><a type="button" class="btn btn-warning btn-sm" onclick="document.forms['logoutForm'].submit()">Logout</a>
			<form id="logoutForm" method="POST" action="${contextPath}/logout"></form>
		</th>
	</tr>
	</table>
	<table class = "table table-responsive"><tr></tr><tr></tr><tr></tr><tr></tr></table>
    <table class = "table table-responsive" width='100%'>
	<tr>
		<td align='center'><a type="button" class="btn btn-info btn-sm" style="width:80%" href="${pageContext.request.contextPath}/getManagerName/empName/Subrat">Get Manager of Subrat</a></td>
	
		<td align='center'><a type="button" class="btn btn-info btn-sm" style="width:80%" href="${pageContext.request.contextPath}/getManagerName/empName/Tripti">Get Manager of Tripti</a></td>
	
		<td align='center'><a type="button" class="btn btn-info btn-sm" style="width:80%" href="${pageContext.request.contextPath}/getManagerName/empName/Amit">Get Manager of Amit</a></td>
	</tr>
	<tr></tr><tr></tr>
	<tr>
		<td align='center'><a type="button" class="btn btn-info btn-sm" style="width:80%" href="${pageContext.request.contextPath}/getNoOfEmployees/managerName/Pankaj">Get number of Employees under Pankaj</a>&nbsp;&nbsp;</td>
	
		<td align='center'><a type="button" class="btn btn-info btn-sm" style="width:80%" href="${pageContext.request.contextPath}/getNoOfEmployees/managerName/Subrat">Get number of Employees under Subrat</a>&nbsp;&nbsp;</td>
	
		<td align='center'><a type="button" class="btn btn-info btn-sm" style="width:80%" href="${pageContext.request.contextPath}/getNoOfEmployees/managerName/Nilesh">Get number of Employees under Nilesh</a>&nbsp;&nbsp;</td>
	</tr>
</table>
    <table class = "table table-responsive"><tr>
    <td><a type="button" class="btn btn-info btn-danger" href="${pageContext.request.contextPath}/register">Register Page</a>&nbsp;&nbsp;</td>
    </tr>
    </table>
</div>
</body></html>
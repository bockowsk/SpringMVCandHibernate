<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Save Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customer form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id="conatiner">
			<h3>Save Customer</h3>
			<!--  track customera -->
			<form:form action="saveCustomer" modelAttribute="newCustomer" method="POST">
				<form:hidden path="id"/>
				<table>
					<tbody>
							<tr><label>Fist Name</label></tr>
							<tr><form:input path="first_name" /></tr>
							<tr><label>Last Name</label></tr>
							<tr><form:input path="last_name" /></tr>
							<tr><label>Email</label></tr>
							<tr><form:input path="email" /></tr>
							<tr><label></label></tr>
							<tr><input type="submit" value="Save" class="save"/></tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear;both"></div>
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">back to list</a>
			</p>
		</div>
	</div>
</body>
</html>
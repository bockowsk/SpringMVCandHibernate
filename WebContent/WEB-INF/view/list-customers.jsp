<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>List Customers</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- add button -->
			<input type="button" value="add customer"
				onclick="window.location.href='showFormForAdd';return false;" />
			<table>
				<tr>
					<th>Fist Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${attributeCustomers}">
					<!-- update link z customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					<!-- delete link z customer id -->
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<tr>
						<td>${tempCustomer.first_name}</td>
						<td>${tempCustomer.last_name}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a></td>
						<td><a href="${deleteLink}" onclick="if (!(confirm('are you sure you want to delete this customer?'))) return false">KASOWANIE</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
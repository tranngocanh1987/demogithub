<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
b {
	color: navy;
	background-color: orange;
}
</style>
<title>Struts2-Spring-Tiles integration | anhtn12</title>
</head>
<body>

	<h2>Search User</h2>
	<s:form action="searchUserMenu">
		<s:textfield name="Username" key="user.username" />
		<s:submit key="Search" align="center" />
	</s:form>
	
	<s:if test="%{users.isEmpty()}">
	</s:if>
	<s:else>
		<b>List of Users</b>
		<table>
			<tr>
				<td><b>Username</b></td>
				<td><b>Password</b></td>
				<td><b>RecordStatus</b></td>
				<td><b>Action</b></td>
			</tr>
			<s:iterator value="users">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="status" /></td>
					<td>
						<s:url id="editURL" action="editUser">
							<s:param name="id" value="%{id}"></s:param>
						</s:url>
                			<s:a href="%{editURL}">Edit</s:a>
					</td>
					<td>
						<s:url id="deleteURL" action="deleteUser">
							<s:param name="id" value="%{id}"></s:param>
						</s:url>
                			<s:a href="%{deleteURL}">Delete</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
</body>
</html>
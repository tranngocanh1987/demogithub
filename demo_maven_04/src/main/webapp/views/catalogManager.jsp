<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalog Manager</title>
<script type="text/javascript">
	function confirmBox() {
		var answer;
		answer = window.confirm("Do you really want to perform this action");
		if (answer == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>

	<h2>All Catalogs</h2>

	<s:form action="saveOrUpdateCatalog">
		<s:bean name="com.develop.struts2.bean.CatalogBean" var="bean" />
		<s:push value="bean">
			<s:hidden name="id" />
			<s:textfield name="name" label="Catalog Name" value="%{bean.name}"/>
			<s:radio name="status" label="Status"
				list="#{'O':'Open','C': 'Close'}"  value="%{bean.status}" />
			<s:submit value="submit" name="submit" />
		</s:push>
	</s:form>


	<s:if test="beans.size() > 0">
		<table border="1px" cellpadding="8px">
			<tr>
				<th>Catalog Id</th>
				<th>Name</th>
				<th>Status</th>
			</tr>
			<s:iterator value="beans" status="catalogStatus">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="status" /></td>
					<td><s:url id="deleteURL" action="deleteCatalog">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{deleteURL}" onclick="return confirmBox();">Delete</s:a>
					</td>
					<td><s:url id="editURL" action="editCatalog">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}">Edit</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

</body>
</html>
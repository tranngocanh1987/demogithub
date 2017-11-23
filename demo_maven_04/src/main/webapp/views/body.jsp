<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
b{color:navy; background-color: orange;}  
</style>
<title>Struts2-Spring-Tiles integration | anhtn12</title>
</head>
<body>

 <h2>Add Customer</h2><b>
    <s:form  action="addCustomermenu">
    <s:textfield name="typeId" key="customer.type_id" />
    <s:textfield name="typeName" key="customer.type_name" value=""/>
    <s:textfield name="description" key="customer.description" value=""/>
    <s:submit key="submit" align="center"/>
 </s:form>
 </b>
 <s:if test="%{customers.isEmpty()}"> 
 </s:if>
 <s:else>
 	Size <s:property value ="customers.size()"/>
  <b>List of Customers</b>
   <table border="1">
       <tr>
          <td><b>TypeID</b></td>
          <td><b>TypeName</b></td>
          <td><b>Description</b></td>
          <td><b>RecordStatus</b></td>
       </tr>
   <s:iterator value="customers"> 
          <tr>
             <td><s:property value="typeID"/></td>
             <td><s:property value="typeName"/></td>
             <td><s:property value="description"/></td>
              <td><s:property value="recordStat"/></td>
            </tr>
       </s:iterator>
       </table>
       </s:else>
 </body>
</html>
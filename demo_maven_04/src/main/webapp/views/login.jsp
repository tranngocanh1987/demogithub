<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Greend Admin Page</h1> 
        <s:if test="%{#parameters.error != null}">
            <div style="color: red">Invalid User</div>
        </s:if>
       <form id="LoginForm" method="POST" action="<s:url value='j_spring_security_check'/>" > 
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Login"/> 
            
        </form>
    </body>
</html>
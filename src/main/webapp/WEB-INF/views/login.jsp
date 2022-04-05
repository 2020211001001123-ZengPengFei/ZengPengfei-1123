<%--
  Created by IntelliJ IDEA.
  User: 12585
  Date: 2022/4/5
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
if(!(request.getAttribute("message")==null)){
    out.println(request.getAttribute("message"));
    }
%>
<from method="post" action="login">
    Username :<input type="text" name="username"><br/>
    Password :<input type="password" name="password"><br/>
    <input type="submit" value="Submit"/>
</from>
<%@include file="footer.jsp"%>
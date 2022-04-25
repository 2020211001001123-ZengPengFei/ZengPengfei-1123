<%@ page import="com.zengpengfei.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 12585
  Date: 2022/4/5
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    Cookie[] allCookies=request.getCookies();
    for(Cookie c:allCookies){
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>
<%
    User u=(User)session.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
        <td>Password:</td><td><%=u.getPassword()%></td>
        <td>Email:</td><td><%=u.getEmail()%></td>
        <td>Gender:</td><td><%=u.getGender()%></td>
        <td>Birthdate:</td><td><%=u.getBithDate()%></td>

    </tr>
</table>
<%@include file="footer.jsp"%>

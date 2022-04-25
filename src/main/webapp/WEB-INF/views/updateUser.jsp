<%--
  Created by IntelliJ IDEA.
  User: 12585
  Date: 2022/4/25
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>

<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%u.getId()%>">
    Username:<input type="text" name="username" value="<%u.getUsername()%>"><br>
    Password:<input type="password" name="password" value="<%u.getPassword()%>"><br>
    Email:<input type="text" name="email" value="<%u.getEmail()%>"><br>

    Gender:<input type="radio" name="gender" value="male"<%="male".equals(u.getGender())?"checked" :""%>>Male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender())?"checked" :""%>>Female<br/>

    Date of birth:<input type="text" name="birthdate" value="<%=u.getBithDate()%>"><br/>
    <input type="submit" value="Save Change"/>
</form>
<%@include file="footer.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: 12585
  Date: 2022/3/16
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<a href="http://www.ecjtu.jx.cn/">go to ecjtu</a>
<form method="post" enctype="register">
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    Email:<input type="text" name="email"><br>

    Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="male">
    Date of birth:<input type="text" name="birthdate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp"%>

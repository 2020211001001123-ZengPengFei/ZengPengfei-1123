<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1><%="hello world"%></h1>
<br/>
<a herf="hello-servlet">hello servlet</a>
<form>
    <span style='...'>new user registration</span><br/><br/>
    <span style='...'>username</span><input type="text" name="name" required="true" style="..."><br/><br/>
    <span style='...'>password</span><input type="password" name="password" required="true" style="..."><br/><br/>
    <span style='...'>emil</span><input type="email" name="emil" required="true" style="..."><br/><br/>
    <span style='...'>Gender</span>
    <span style='...'>Male</span><input type="radio">
    <span style='...'>female</span><input type="radio"><br/><br/>
    <span style='...'>date of birth(yyyy-mm-dd)</span><input type="date" name="yyyy-mm-dd" required="true" style="..."><br/><br/>
    <input type="submit" value="register" style="...">
</form>
<%@include file="footer.jsp"%>
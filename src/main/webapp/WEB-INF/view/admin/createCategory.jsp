<%--
  Created by IntelliJ IDEA.
  User: Jaeyeop
  Date: 8/31/2020
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create</title>
</head>
<body>
<h2>create category</h2>
<div>
    name: <input type="text" name="name" required="required"> <br>
    tag: <input type="text" name="icon" required="required"> <br> <br>
    <input type="button" value="submit" onclick="">
    <input type="text" name="createdBy" value="${sessionScope.loginId}">
    <input type="hidden" name="type" value="category">
</div>
</body>
</html>

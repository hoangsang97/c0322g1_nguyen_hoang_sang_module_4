<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 14/07/2022
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>

<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>

<form action="index/validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 14/07/2022
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="post" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">EmployeeID: </form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee name: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Contact Number: </form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

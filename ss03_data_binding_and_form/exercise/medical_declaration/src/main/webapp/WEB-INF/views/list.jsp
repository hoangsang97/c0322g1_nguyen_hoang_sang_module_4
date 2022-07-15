<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 15/07/2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container-fluid">
    <h3>TỜ KHAI Y TẾ</h3>
    <a href="/person/showCreate" class="btn btn-primary mb-3">Create</a>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>yearOfBirth</th>
            <th>gender</th>
            <th>nationality</th>
            <th>idCard</th>
            <th>vehicle</th>
            <th>numberVehicle</th>
            <th>seats</th>
            <th>starDate</th>
            <th>endDate</th>
            <th>text</th>
            <th>addressContact</th>
            <th>address</th>
            <th>phone</th>
            <th>email</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${personList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.yearOfBirth}</td>
            <td>${item.gender}</td>
            <td>${item.nationality}</td>
            <td>${item.idCard}</td>
            <td>${item.vehicle}</td>
            <td>${item.numberVehicle}</td>
            <td>${item.seats}</td>
            <td>${item.starDate}</td>
            <td>${item.endDate}</td>
            <td>${item.text}</td>
            <td>${item.addressContact}</td>
            <td>${item.address}</td>
            <td>${item.phone}</td>
            <td>${item.email}</td>
            <td><a href="/person/showUpdate?id=${item.id}" class="btn btn-primary">Update</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

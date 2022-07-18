<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 16/07/2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h3 class="text-center">Create Student</h3>
    <form:form modelAttribute="student" method="post" action="create">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">ID</label>
            <div class="col-sm-10">
                <form:input path="id" class="form-control" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <form:input path="name" class="form-control" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Subject</label>
            <div class="col-sm-10">
                <div class="form-check">
                    <form:checkboxes items="${subject}" path="subject"/>
                </div>
            </div>
        </div>
        <input type="submit" value="Create" class="btn btn-primary">
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

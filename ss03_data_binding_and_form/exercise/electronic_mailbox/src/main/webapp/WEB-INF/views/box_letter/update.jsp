<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 15/07/2022
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Box Letter</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">
    <h1>box letter</h1>
    <form:form method="post" action="updateBox?id=${boxLetter.id}" modelAttribute="boxLetter">
        <div class="row mb-3">
            <form:label path="languages" class="col-sm-2 col-form-label">Languages: </form:label>
            <div class="col-sm-10">
                <form:select items="${languagesList}" path="languages" class="form-select"></form:select>
            </div>
        </div>
        <div class="row mb-3">
            <form:label path="size" class="col-sm-2 col-form-label">Page Size</form:label>
            <div class="col-sm-10">
                <Span>Show </Span>
                <form:select path="size" items="${sizeList}" class="form-select"></form:select>
                <Span> email per page</Span>
            </div>
        </div>
        <div class="row mb-3">
            <form:label path="filter" class="col-sm-2 col-form-label">Spams filter</form:label>
            <div class="col-sm-10">
                <div class="form-check">
                    <form:checkbox path="filter" class="form-check-input" value="filter" onclick="objCheck()"
                                   id="checkbox"/>
                    <label class="form-check-label">
                        Enable spams filter
                    </label>
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <form:label path="signature" class="col-sm-2 col-form-label">Signature</form:label>
            <div class="col-sm-10">
                <div class="form-floating">
                    <form:textarea path="signature" class="form-control" placeholder="Leave a comment here"
                                   id="floatingTextarea2" style="height: 100px"
                                   value="${boxLetter.signature}"></form:textarea>
                </div>
            </div>
        </div>
        <div class="">
            <button type="submit" class="btn btn-primary">Updates</button>
            <a href="/boxLetter/list" class="btn btn-primary">Close</a>
        </div>
    </form:form>
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

<script>
    function objCheck() {
        document.getElementById("checkbox").value = "filter";
    }
</script>
</body>
</html>

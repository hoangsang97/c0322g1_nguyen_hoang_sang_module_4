<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 13/07/2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <form action="" method="get">
        <div class="mb-3">
            <div class="col">
                English : <input type="text" class="form-control" placeholder="Nhập tiếng anh" name="english">
            </div>
        </div>
        <div>
            <div class="col">
                <input type="submit" class="btn btn-primary">
            </div>
        </div>
        <div class="mb-3">
            <div class="col">
                Tiếng Việt : ${result}
            </div>
        </div>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<%--<script>--%>
<%--    let eng = "";--%>

<%--    function convert() {--%>
<%--        eng = document.getElementById("english").value;--%>
<%--        switch (eng) {--%>
<%--            case "hello":--%>
<%--                document.getElementById("vietnam").innerHTML = "Xin chào";--%>
<%--                break;--%>
<%--            case "winter":--%>
<%--                document.getElementById("vietnam").innerHTML = "Mùa đông";--%>
<%--                break;--%>
<%--            case "summer":--%>
<%--                document.getElementById("vietnam").innerHTML = "Mùa hè";--%>
<%--                break;--%>
<%--            case "spring":--%>
<%--                document.getElementById("vietnam").innerHTML = "Mùa xuân";--%>
<%--                break;--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</html>

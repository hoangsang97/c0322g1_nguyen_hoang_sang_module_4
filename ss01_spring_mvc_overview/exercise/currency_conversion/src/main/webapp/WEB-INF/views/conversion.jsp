<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 13/07/2022
  Time: 08:41
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
<form action="" method="get">
<div class="container-fluid">
    <div class="mb-3">
        <label class="form-label">USD</label>
        <input type="text" class="form-control" placeholder="Input USD" name="usd">
    </div>
    <div class="row mb-3">
        <div class="col-sm-2">
            <input type="submit" class="form-control btn btn-primary" value="Convert">
        </div>
    </div>
    <span>Result: ${result}</span>
</div>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<%--<script>--%>
<%--    let usd = 0;--%>
<%--    function resultUsd() {--%>
<%--        usd = document.getElementById("usd").value;--%>
<%--        document.getElementById("resultVnd").innerHTML = usd * 23000;--%>
<%--    }--%>
<%--</script>--%>
</html>

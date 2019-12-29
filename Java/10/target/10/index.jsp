<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index lb10</title>
</head>
<body>
<form action="/QuerySelect" method="post">
    <h4>select query</h4>
    <button type="submit">click</button>
</form>
<form action="/QueryWhereSelect" method="post">
    <h4>select where</h4>
    <input type="text" name="whereValue" placeholder="value">
    <button type="submit">click</button>
</form>
<form action="/QueryProcedure" method="post">
    <h4>input procedure</h4>
    <input type="text" name="procedureValue" placeholder="value">
    <br/>
    <button type="submit">click</button>
</form>
</body>
</html>

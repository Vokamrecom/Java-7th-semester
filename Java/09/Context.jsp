<%@page import="Lab6.A"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            A param = (A)request.getAttribute("attribute");
            // String A = String.valueOf(param.GetA());
            // String B = String.valueOf(param.GetB());
            // String C = String.valueOf(param.GetC());
            int A =  -3;
            int B =  -3;
            int C =  -3;
            String error = "";
            if (param != null) {
                A = param.GetA();
                B = param.GetB();
                C = param.GetC();
            }
            %>
    </head>
    <body>
        <%= A%><br/>
        <%= B%><br/>
        <%= C%><br/>
        <%= error%><br/>
    </body>
</html>

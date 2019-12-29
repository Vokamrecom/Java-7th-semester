<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import= "cl.ChoiseXXX" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    String d = (String) config.getServletContext().getInitParameter("doc-dir");
    ChoiseXXX ch = new ChoiseXXX(d, "doc");
    String ll = null;
    for (int i = 0; i < ch.listxxx.length; i++) {
        ll = ch.listxxx[i];
%>
<br />
<a href="Msdoc?file=<%=ll%>"> <%=ll%> </a>
<%}%>
</body>
</html>
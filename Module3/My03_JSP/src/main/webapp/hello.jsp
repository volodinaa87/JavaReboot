<%-- 
    Document   : hello
    Created on : 27 февр. 2020 г., 20:58:23
    Author     : alex
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        Date now = new Date();
        //out.println("<h2>Current time is: "+now.toString() +"</h2>");
        %>
        <h2>Current time is: <%=now%></h2>
        <p>Here inserted code!</p>
    </body>
</html>

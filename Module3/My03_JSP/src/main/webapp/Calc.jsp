<%-- 
    Document   : Calc
    Created on : 27 февр. 2020 г., 21:10:52
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calc</title>
        <style>
            .pressed {
                background-color: pink;
            }
        </style>
            
    </head>
    <body>
        <h1>CalcSample</h1>
        <%
            int x = 0, y = 0, z = 0;
            String styleMinus = "";
            String stylePlus = "";
            if (request.getParameter("txtX") != null) {

                x = Integer.parseInt(request.getParameter("txtX"));
                y = Integer.parseInt(request.getParameter("txtY"));

                if (request.getParameter("btnPlus") != null) {

                    z = x + y;
                    stylePlus = "pressed";
                }
                else {
                    
                    z = x - y;
                    styleMinus = "pressed";
                }
            }
        %>

        <form method="POST">
            <input type="number" name="txtX" value="<%=x%>"/><br/>
            <input type="number" name="txtY" value="<%=y%>"/><br/>
            <input type="submit" name="btnPlus" class="<%=stylePlus%>" value="+">
            <input type="submit" name="btnMinus" class="<%=styleMinus%>" value="-"><br/>
            <input type="text" name="Result" value="<%=z%>"/><br/>
        </form>

    </body>
</html>

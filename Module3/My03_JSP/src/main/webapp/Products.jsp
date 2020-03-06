<%-- 
    Document   : Products
    Created on : 3 мар. 2020 г., 19:57:51
    Author     : alex
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="aw.data.Product"%>
<%@page import="aw.data.DataBuilder"%>
<%@page import="aw.data.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <h1>AW PriceList</h1>
        <table bordercolor="blue" border="1">
            <tr>
                <th>Product</th>
                <th>Price</th>
            </tr>
            <%
    //        DAO dao = new DAO();
                DataBuilder db = new DataBuilder();
                List<Product> products = db.getFullPriceList();
    //        List <String> str= new LinkedList<>();
                for (Product p : products) {
                    out.println("<tr>");
                    out.println("<td>" + p.getProductName() + "</td>"
                              + "<td>" + p.getPrice() + "</td>");
                    out.println("</tr>");

                }


            %>
        </table>
    </body>
</html>

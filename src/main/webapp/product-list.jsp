<%--
  Created by IntelliJ IDEA.
  User: Jarek
  Date: 20.09.2019
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="packModel.Product" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Products list</title>
</head>
<body>
<jsp:include page="/navigator.jsp"></jsp:include>

<table style="width: 60%">
    <tr>
        <th>Id.</th>
        <th>Name</th>
        <th>Price</th>
        <th>Tax</th>
        <th>Tax type</th>
        <th>Stock</th>
    </tr>

    <c:forEach var="product" items="${requestScope.lista_produktow_z_bazy_danych}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getTax()}</td>
            <td>${product.getTaxType()}</td>
            <td>${product.getStock()}</td>
            <td>
                <table>
                    <tr>
                        <td>
                            <a href="/product-delete?productId=${product.getId()}">Delete product</a>
                        </td>
                        <td>
                            <a href="/product-edit?productId=${product.getId()}">Edit product</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

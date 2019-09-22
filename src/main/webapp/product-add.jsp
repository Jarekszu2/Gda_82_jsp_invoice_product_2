<%--
  Created by IntelliJ IDEA.
  User: Jarek
  Date: 21.09.2019
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Product add</title>
</head>
<body>
<jsp:include page="/navigator.jsp"></jsp:include>

<form action="/product-add" method="post">
    <br/>
    <input type="hidden" name="invoice_to_whom_i_sholud_give_product_to" value="${requestScope.id_invoice_choosen_from_list}">
    <br/>
    <br/>
    Product name: <input type="text" name="product_name">
    <br/>
    <br/>
    Product price: <input type="number" name="product_price">
    <br/>
    <br/>
    Tax type: <select name="tax_type">
    <option value="PRODUCT">Product</option>
    <option value="SEEVICE">Service</option>
    </select>
    <br/>
    <br/>
    Product stock: <input type="number" name="product_stock">
    <br/>
    <br/>
    <input type="submit"><%--Guzik 'prześlij'--%>
</form>
</body>
</html>

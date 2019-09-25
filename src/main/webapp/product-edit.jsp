<%--
  Created by IntelliJ IDEA.
  User: Jarek
  Date: 22.09.2019
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Edit product</title>
</head>
<body>
<jsp:include page="/navigator.jsp"></jsp:include>

<form action="/product-edit" method="post">
    <br/>
    <input type="hidden" name="product_id" value="${requestScope.productId}">
    <br/>
    <br/>
    Product name: <input type="text" name="product_name" value="${requestScope.productName}">
    <br/>
    <br/>
    Product price: <input type="number" name="product_price" value="${requestScope.productPrice}">
    <br/>
    <br/>
    Tax type:
    <select name="tax_type" value="${requestScope.productTaxType}">
        <option value="PRODUCT">Product</option>
        <option value="SEEVICE">Service</option>
    </select>
    <br/>
    <br/>
    Product stock: <input type="number" name="product_stock" value="${requestScope.productStock}">
    <br/>
    <br/>
    <input type="hidden" name="invoice_id" value="${requestScope.productInvoiceId}">
    <br/>
    <br/>
    <input type="submit"><%--Guzik 'prześlij'--%>
</form>
</body>
</html>

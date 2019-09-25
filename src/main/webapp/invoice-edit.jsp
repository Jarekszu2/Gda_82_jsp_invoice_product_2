<%--
  Created by IntelliJ IDEA.
  User: Jarek
  Date: 22.09.2019
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Invoice edit</title>
</head>
<body>
<form action="/invoice-edit" method="post">
    <br/>
    <input type="hidden" name="invoice_id" value="${requestScope.invoiceId}">
    <br/>
    <input type="hidden" name="invoice_dateOfCreation" value="${requestScope.invoiceDateOfCreation}">
    <br/>
    <br/>
    Client name: <input type="text" name="invoice_clientName" value="${requestScope.clientName}">
    <br/>
    <br/>
    Client NIP: <input type="number" name="invoice_clientNip" value="${requestScope.clientNip}">
    <br/>
    <br/>
    Client address: <input type="text" name="invoice_clientAddress" value="${requestScope.clientAddress}">
    <br/>
    <br/>
    <input type="submit"><%--Guzik 'prześlij'--%>
</form>
</body>
</html>

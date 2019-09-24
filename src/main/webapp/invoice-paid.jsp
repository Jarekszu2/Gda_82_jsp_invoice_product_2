<%--
  Created by IntelliJ IDEA.
  User: Jarek
  Date: 24.09.2019
  Time: 01:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Paid invoice</title>
</head>
<body>
<form action="/invoice-paid" method="post">
    <br/>
    <input type="hidden" name="invoice_id" value="${requestScope.invoiceId}">
    <br/>
    <br/>
    <input type="hidden" name="invoice_dateOfCreation" value="${requestScope.invoiceDateOfCreation}">
    <br/>
    <br/>
    <input type="hidden" name="invoice_clientName" value="${requestScope.clientName}">
    <br/>
    <br/>
    <input type="hidden" name="invoice_clientNip" value="${requestScope.clientNip}">
    <br/>
    <br/>
    <input type="hidden" name="invoice_clientAddress" value="${requestScope.clientAddress}">
    <br/>
    <br/>
    <input type="hidden" name="invoice_dateOfRelease" value="${requestScope.invoiceDateOfRelease}">
    <br/>
    <br/>
    If paid: <input type="checkbox" name="invoice_if_paid">
    <br/>
    <br/>
    Date of payment: <input type="datetime-local" name="invoice_date_of_payment">
    <br/>
    <br/>
    <input type="submit"><%--Guzik 'prześlij'--%>
</form>
</body>
</html>

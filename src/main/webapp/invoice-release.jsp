<%--
  Created by IntelliJ IDEA.
  User: Jarek
  Date: 23.09.2019
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Release invoice</title>
</head>
<body>
<form action="/invoice-release" method="post">
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
    Date of release: <input type="datetime-local" name="invoice_dateOfRelease">
    <br/>
    <br/>
    <input type="submit"><%--Guzik 'prześlij'--%>
</form>
</body>
</html>

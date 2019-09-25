<%--
  Created by IntelliJ IDEA.
  User: Jarek
  Date: 17.09.2019
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Invoice Add</title>
</head>
<body>
<jsp:include page="/navigator.jsp"></jsp:include>
<%--jeśli w liście inwoiców zaciągniętej z bazy danych --%>
<%--if ( requestScope.studentId == null ) --%>
<%-- WSTAW W ACTION WARTOŚĆ : /student-add --%>
<%-- else --%>
<%-- WSTAW W ACTION WARTOŚĆ : /student-edit --%>
<%--<form action="${requestScope.invoiceId==null ? '/invoice-add' : '/invoice-edit'}" method="post">--%>
<form action="/invoice-add" method="post">
    <br/>
    <input type="hidden" name="invoice_id" value="${requestScope.invoiceId}">
    Client name: <input type="text" name="invoice_clientName" value="${requestScope.clientName}">
    <br/>
    <br/>
    Client NIP: <input type="text" minlength="10" maxlength="10" name="invoice_clientNip" value="${requestScope.clientNip}">
    <br/>
    <br/>
    Client address: <input type="text" name="invoice_clientAddress" value="${requestScope.clientAddress}">
    <br/>
    <br/>
    <input type="submit"><%--Guzik 'prześlij'--%>
</form>
</body>
</html>

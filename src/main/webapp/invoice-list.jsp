<%@ page import="packModel.Invoice" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <title>Invoices List</title>
</head>
<body>
<jsp:include page="/navigator.jsp"></jsp:include>

<table style="width: 80%">
    <tr>
        <th>Id.</th>
        <th>Date of creation</th>
        <th>Client name</th>
        <th>If paid</th>
        <th>Date of release</th>
        <th>Date of payment</th>
        <th>Client NIP</th>
        <th>Client Address</th>
        <th></th>
    </tr>

    <c:forEach var="invoice" items="${requestScope.lista_invoices_z_bazy_danych}">
        <tr>
            <td>${invoice.getId()}</td>
            <%--<td>${invoice.getDateOfCreation()}</td>--%>
            <td>${invoice.getDateOfCreation().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))}</td>
            <td>${invoice.getClientName()}</td>
            <td>${invoice.isIfPaid()}</td>
            <td>${invoice.getDateOfRelease()}</td>
            <td>${invoice.getDateOfPayment()}</td>
            <td>${invoice.getClientsNip()}</td>
            <td>${invoice.getClientsAddress()}</td>
            <td>
                <table>
                    <tr>
                        <td>
                            <a href="/invoice-delete?invoiceId=${invoice.getId()}">Delete</a>
                        </td>
                        <td>
                            <a href="/invoice-edit?invoiceId=${invoice.getId()}">Edit</a>
                        </td>
                        <td>
                            <a href="/product-list?invoiceId=${invoice.getId()}">List products</a>
                        </td>
                        <td>
                            <a href="/product-add?invoiceId=${invoice.getId()}">Add product</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

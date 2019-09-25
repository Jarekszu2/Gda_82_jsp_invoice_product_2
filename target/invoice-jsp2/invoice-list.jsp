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

<table style="width: 100%">
    <tr>
        <th>Id.</th>
        <th>Date of creation</th>
        <th>Client name</th>
        <th>If paid</th>
        <th>Date of release</th>
        <th>Date of payment</th>
        <th>Bill value</th>
        <th>Client NIP</th>
        <th>Client Address</th>
        <th>Number of products</th>
        <th></th>
    </tr>

    <c:forEach var="invoice" items="${requestScope.lista_invoices_nieoplaconych_z_bazy_danych}">
        <tr>
            <td>${invoice.getId()}</td>
            <%--<td>${invoice.getDateOfCreation()}</td>--%>
            <td>${invoice.getDateOfCreation().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))}</td>
            <td>${invoice.getClientName()}</td>
            <td>${invoice.isIfPaid()}</td>
            <td>${invoice.getDateOfRelease().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))}</td>
            <td>${invoice.getDateOfPayment().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))}</td>
            <td>${invoice.getBillValue()}</td>
            <td>${invoice.getClientsNip()}</td>
            <td>${invoice.getClientsAddress()}</td>
            <td>${invoice.getNumberOfProducts()}</td>
            <td>
                <table>
                    <tr>
                        <td>
                            <a href="/invoice-delete?invoiceId=${invoice.getId()}">Delete invoice</a>
                        </td>
                        <td>
                            <a href="/invoice-edit?invoiceId=${invoice.getId()}">Edit invoice</a>
                        </td>
                        <td>
                            <a href="/invoice-release?invoiceId=${invoice.getId()}">Release invoice</a>
                        </td>
                        <%--{% if fname == null or fname == '' %}We're so glad you visited our store!{% else %}{{fname}}, thanks for visiting our store!{% endif %}--%>
                        <%--{{% if (${invoice.isIfPaid()} == false) %}--%>
                        <td>
                            <a href="/invoice-paid?invoiceId=${invoice.getId()}">Paid invoice</a>
                        </td>
                        <%--{% endif %}}--%>

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
    <br/>
    <h2>???</h2>
    <br/>
    <c:forEach var="invoice" items="${requestScope.lista_invoices_oplaconych_z_bazy_danych}">
        <tr>
            <td>${invoice.getId()}</td>
                <%--<td>${invoice.getDateOfCreation()}</td>--%>
            <td>${invoice.getDateOfCreation().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))}</td>
            <td>${invoice.getClientName()}</td>
            <td>${invoice.isIfPaid()}</td>
            <td>${invoice.getDateOfRelease().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))}</td>
            <td>${invoice.getDateOfPayment().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))}</td>
            <td>${invoice.getBillValue()}</td>
            <td>${invoice.getClientsNip()}</td>
            <td>${invoice.getClientsAddress()}</td>
            <td>${invoice.getNumberOfProducts()}</td>
            <td>
                <table>
                    <tr>
                        <td>
                            <a href="/invoice-delete?invoiceId=${invoice.getId()}">Delete invoice</a>
                        </td>
                        <%--<td>--%>
                            <%--<a href="/invoice-edit?invoiceId=${invoice.getId()}">Edit invoice</a>--%>
                        <%--</td>--%>
                        <%--<td>--%>
                            <%--<a href="/invoice-release?invoiceId=${invoice.getId()}">Release invoice</a>--%>
                        <%--</td>--%>
                            <%--{% if fname == null or fname == '' %}We're so glad you visited our store!{% else %}{{fname}}, thanks for visiting our store!{% endif %}--%>
                        <%--{{% if (${invoice.isIfPaid()} == false) %}--%>
                        <%--<td>--%>
                            <%--<a href="/invoice-paid?invoiceId=${invoice.getId()}">Paid invoice</a>--%>
                        <%--</td>--%>
                        <%--{% endif %}}--%>

                        <td>
                            <a href="/product-list?invoiceId=${invoice.getId()}">List products</a>
                        </td>
                        <%--<td>--%>
                            <%--<a href="/product-add?invoiceId=${invoice.getId()}">Add product</a>--%>
                        <%--</td>--%>
                    </tr>
                </table>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

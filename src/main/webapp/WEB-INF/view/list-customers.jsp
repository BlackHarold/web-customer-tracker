<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang=ru>
<head>
    <title>List of customers</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="add"><input type="button"></div>

<div id="container">
    <div id="content">

        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>E-mail</th>
            </tr>
            <c:forEach var="temp" items="${customers}">
                <tr>
                    <td>${temp.firstName}</td>
                    <td>${temp.lastName}</td>
                    <td>${temp.email}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>


</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista kart paliwowych</title>
</head>
<body>
<h1>Lista aut</h1>
<table border="2">
    <tr>
        <td>Id</td>
        <td>Numer karty</td>
        <td>Numer telefonu</td>
        <td>Kod pin do karty</td>
        <td>Właściciel karty</td>
        <td>Numer rejestracyjny auta przypisanego do karty</td>
    </tr>
    <c:forEach items="${cards}" var="card">
        <tr>
            <td>${card.id}</td>
            <td>${card.cardNumber}</td>
            <td>${card.user.phoneNumber}</td>
            <td>${card.pinCard}</td>
            <td>${card.user.fullName}</td>
            <td>${card.car.carDetails.licensePlate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

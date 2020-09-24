<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszyscy użytkownicy</title>
</head>
<body>
<h1>Lista użytkowników</h1>
<table border="2">
    <tr>
        <td>Id</td>
        <td>Numer rejestracyjny</td>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>Numer telefonu</td>
        <td>Numer karty flotowej</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.car.carDetails.licensePlate}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.fleetCard.cardNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
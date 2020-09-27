<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rozliczenie paliwa</title>
</head>
<body>
<div>
    <h1>Rozliczenie paliwa</h1><br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Miesiąc</td>
        <td>Stan licznika (początek miesiąca)</td>
        <td>Stan licznika (koniec miesiąca)</td>
        <td>Przejechane kilometry</td>
        <td>Ilość kupionego paliwa</td>
        <td>Rzeczywiste zużycie paliwa</td>
        <td>Ilość zakupionego paliwa do użytku prywatnego</td>
        <td>Ilość dokumentów potwierdzających zakup</td>
        <td>Uwagi</td>

    </tr>
    <c:forEach items="${monthUse}" var="carDetails">
        <tr>
            <td>${carDetails.id}</td>
            <td>${carDetails.month}</td>
            <td>${carDetails.numbersOfKilometersOnStartOfMonth}</td>
            <td>${carDetails.numbersOfKilometersOnEndOfMonth}</td>
            <td>${carDetails.numbersOfKilometersTraveledInThisMonth}</td>
            <td>${carDetails.amountOfFuelBought}</td>
            <td>${carDetails.realFuelConsumption}</td>
            <td>${carDetails.amountOfFuelForPrivateUse}</td>
            <td>${carDetails.quantityOfDocuments}</td>
            <td>${carDetails.comments}</td>

        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>

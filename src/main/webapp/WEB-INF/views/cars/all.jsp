<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszystkie auta</title>
</head>
<body>
<h1>Lista aut</h1><br>
<a href="/cars/add">Dodaj auto</a>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Właściciel pojazdu</td>
        <td>Karty paliwowe</td>
        <td>Marka</td>
        <td>Numer Vin</td>
        <td>Numer rejestracyjny</td>
        <td>Numer nadwozia</td>
        <td>Numer silnika</td>
        <td>Rodzaj pojazdu</td>
        <td>Rodzaj paliwa</td>
        <td>Rok produkcji</td>
        <td>Pojemność silnika</td>
        <td>Ilość miejsc</td>
        <td>Czy auto ma GPS</td>
        <td>Data wygaśnięcia polisy OC</td>
        <td>Data wygaśnięcia polisy AC</td>
        <td>Zakład ubezpieczeń</td>
        <td>Zabezpieczenia pozjadu</td>
        <td>Rok pierwszej rejestracji</td>
        <td>Data następnego przeglądu</td>
        <td>Uwagi</td>
        <td>Akcję, Linki</td>

    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.user.fullName}</td>
            <td>
            <c:forEach items="${car.fleetCard}" var="card">
                ${card.cardNumber}
            </c:forEach>
            </td>
            <td>${car.carDetails.modelCar}</td>
            <td>${car.carDetails.vinNumber}</td>
            <td>${car.carDetails.licensePlate}</td>
            <td>${car.carDetails.chassisNumber}</td>
            <td>${car.carDetails.engineNumber}</td>
            <td>${car.carDetails.typeOfCar}</td>
            <td>${car.carDetails.fuelType}</td>
            <td>${car.carDetails.yearOfProduction}</td>
            <td>${car.carDetails.engineCapacity}</td>
            <td>${car.carDetails.numberOfSeats}</td>
            <td>${car.carDetails.hasGPS}</td>
            <td>${car.ocPolicyExpireDate}</td>
            <td>${car.acPolicyExpireDate}</td>
            <td>${car.carDetails.insuranceCompany}</td>
            <td>${car.carDetails.carSecurity}</td>
            <td>${car.carDetails.yearOfFirstRegistration}</td>
            <td>${car.nextTechnicalInspectionDate}</td>
            <td>${car.comments}</td>
            <td>
                <a href="/cars/connect/${car.id}">Dodaj/zmień użytkownika</a>
                <a href="/monthUses/add/${car.id}">Miesięczne zużycie paliwa auta</a>
                <a href="/cards/add/${car.id}">Dodaj zmień kartę paliwową</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszystkie auta</title>
</head>
<body>
<h1>Lista aut</h1>
<table border="1">
    <tr>
        <td>Id</td>
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

    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.modelCar}</td>
            <td>${car.vinNumber}</td>
            <td>${car.licensePlate}</td>
            <td>${car.chassisNumber}</td>
            <td>${car.engineNumber}</td>
            <td>${car.typeOfCar}</td>
            <td>${car.fuelType}</td>
            <td>${car.yearOfProduction}</td>
            <td>${car.engineCapacity}</td>
            <td>${car.numberOfSeats}</td>
            <td>${car.hasGPS}</td>
            <td>${car.ocPolicyExpireDate}</td>
            <td>${car.acPolicyExpireDate}</td>
            <td>${car.insuranceCompany}</td>
            <td>${car.carSecurity}</td>
            <td>${car.yearOfFirstRegistration}</td>
            <td>${car.nextTechnicalInspectionDate}</td>
            <td>${car.comments}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

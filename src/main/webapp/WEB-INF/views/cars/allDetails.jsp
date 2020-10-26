<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszystkie auta</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>
<section class="section">
        <div class="container has-text-centered">
<h1>Lista aut</h1><br>
<a class="button is-link - is-rounded" href="/cars/add">Dodaj auto</a>
        </div>
    <br>
    <div class="table-container">
<table border="1" class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
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
                <a class="button is-danger is-rounded" href="/cars/connect/${car.id}">Dodaj/zmień użytkownika</a><br>
                <a class="button is-warning is-rounded" href="/monthUses/add/${car.id}">Miesięczne zużycie paliwa auta</a><br>
                <a class="button is-success is-rounded" href="/cards/add/${car.id}">Dodaj zmień kartę paliwową</a><br>
            </td>
        </tr>
</table>
                </div>
            </div>
            </div>
        </div>
</section>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

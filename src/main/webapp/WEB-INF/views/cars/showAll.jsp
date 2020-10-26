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
        <h1><b>Lista aut</b></h1><br>
        <c:choose>
            <c:when test="${login =='Remek'}">
                <a class="button is-link is-rounded" href="/cars/add">Dodaj auto</a>
            </c:when>
        </c:choose>
    </div>
    <br>
    <div class="table-container">
        <table border="3" class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
            <tr>
                <td>Id</td>
                <td>Właściciel pojazdu</td>
                <td>Karty paliwowe</td>
                <td>Marka</td>
                <td>Numer rejestracyjny</td>
                <td>Szczegóły auta</td>
                <td>Uwagi</td>
                <td>Akcje, Linki</td>

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
                    <td>${car.carDetails.licensePlate}</td>
                    <td><a class="button is-link" href="/cars/allDetails/${car.id}">Dane auta z dowodu</a></td>
                    <td>${car.comments}</td>
                    <td>
                        <c:choose>
                            <c:when test="${login =='Remek'}">
                                <a class="button is-danger is-rounded" href="/cars/connect/${car.id}">Dodaj/zmień
                                    użytkownika</a><br>
                                <a class="button is-warning is-rounded" href="/monthUses/add/${car.id}">Miesięczne
                                    zużycie paliwa auta</a><br>
                                <a class="button is-success is-rounded" href="/cards/add/${car.id}">Dodaj zmień kartę
                                    paliwową</a><br>
                            </c:when>
                            <c:when test="${login != 'Remek'}">
                                <a class="button is-warning is-rounded" href="/monthUses/add/${car.id}">Miesięczne
                                    zużycie paliwa auta</a><br>
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

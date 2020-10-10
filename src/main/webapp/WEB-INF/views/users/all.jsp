<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszyscy użytkownicy</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>
<div class="container has-text-centered">
<h1>Lista użytkowników</h1>
    <div class="table-container">
        <table border="2" class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
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
</div>
</div>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>
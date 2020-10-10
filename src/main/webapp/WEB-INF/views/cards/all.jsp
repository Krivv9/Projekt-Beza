<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista kart paliwowych</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>

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

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>

</body>
</html>

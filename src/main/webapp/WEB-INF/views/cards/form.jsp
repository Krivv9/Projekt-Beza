<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz karty paliwowej</title>
    <style>
        .error {
            color: red;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>
<h1>Formularz dodawania karty paliwowej<br></h1><br>
<%--@elvariable id="card" type="pl.kamilracki.flota.models.entities.FleetCard"--%>
<form:form method="post" modelAttribute="card">
    <form:hidden path="id"/>
    Numer rejestracyjny auta, który chcesz przypisać do karty:
    <form:select path="car">
        <form:option value="0" label="wybierz auto"/>
        <form:options items="${cars}" itemValue="id" itemLabel="carDetails.licensePlate"/>
    </form:select><br>
    <form:errors path="car.carDetails.licensePlate" cssClass="error"/><br>
    Imię i nazwisko użytkownika karty/pojazdu:
    <form:select path="user">
        <form:option value="0" label="wybierz właściciela"/>
        <form:options items="${users}" itemValue="id" itemLabel="fullName"/>
    </form:select><br>
    <form:errors path="user" cssClass="error"/><br>
    Numer karty:
    <form:input path="cardNumber"/><br>
    <form:errors path="cardNumber" cssClass="error"/><br>
    Kod pin do karty:
    <form:input path="pinCard"/><br>
    <form:errors path="pinCard" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

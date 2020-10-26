<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie nowego auta</title>
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
<section class="section">
    <div class="container has-text-centered">
<h1>Formularz dodawania nowego auta do floty<br></h1><br>
<%--@elvariable id="car" type="pl.kamilracki.flota.models.entities.Car"--%>
<form:form method="post" modelAttribute="car">
    <form:hidden path="id"/>
    <h2>Dane z dowodu rejestracyjnego:</h2>
    <form:input placeholder="Numer rejestracyjny: " path="carDetails.licensePlate"/><br>
    <form:errors path="carDetails.licensePlate" cssClass="error"/><br>
    <form:input placeholder="Marka i model samochodu: " path="carDetails.modelCar"/><br>
    <form:errors path="carDetails.modelCar" cssClass="error"/><br>
    <form:input placeholder="Numer Vin: " path="carDetails.vinNumber"/><br>
    <form:errors path="carDetails.vinNumber" cssClass="error"/><br>
    <form:input placeholder="Numer nadwozia: " path="carDetails.chassisNumber"/><br>
    <form:errors path="carDetails.chassisNumber" cssClass="error"/><br>
    <form:input placeholder="Numer silnika: " path="carDetails.engineNumber"/><br>
    <form:errors path="carDetails.engineNumber" cssClass="error"/><br>
    <form:input placeholder="Pojemność silnika: " path="carDetails.engineCapacity"/><br>
    <form:errors path="carDetails.engineCapacity" cssClass="error"/><br>
    <form:input placeholder="Ilość miejsc: " path="carDetails.numberOfSeats"/><br>
    <form:errors path="carDetails.numberOfSeats" cssClass="error"/><br>
    Rodzaj pojazdu: <form:select path="carDetails.typeOfCar">
    <form:option value="Osobowy" label="Osobowy"/>
    <form:option value="Ciężarowy" label="Ciężarowy"/>
    </form:select><br>
    <form:errors path="carDetails.typeOfCar" cssClass="error"/><br>
    Rodzaj paliwa: <form:select path="carDetails.fuelType">
    <form:option value="Benzyna" label="Benzyna"/>
    <form:option value="ON" label="ON"/>
    </form:select><br>
    <form:errors path="carDetails.fuelType" cssClass="error"/><br>
    Czy auto posiada GPS: <form:select path="carDetails.hasGPS">
    <form:option value="Tak" label="Tak"/>
    <form:option value="Nie" label="Nie"/>
    </form:select><br>
    <form:errors path="carDetails.hasGPS" cssClass="error"/><br>
    Data wygaśnięcia polisy OC: <form:input path="ocPolicyExpireDate" placeholder="YYYY-MM-DD" type="date"/><br>
    <form:errors path="ocPolicyExpireDate" cssClass="error"/><br>
    Data wygaśnięcia polisy AC: <form:input path="acPolicyExpireDate" placeholder="YYYY-MM-DD" type="date"/><br>
    <form:errors path="acPolicyExpireDate" cssClass="error"/><br>
    Data następnego przeglądu: <form:input path="nextTechnicalInspectionDate" placeholder="YYYY-MM-DD" type="date"/><br>
    <form:errors path="nextTechnicalInspectionDate" cssClass="error"/><br>
    <form:input placeholder="Zakład ubezpieczeń: " path="carDetails.insuranceCompany"/><br>
    <form:errors path="carDetails.insuranceCompany" cssClass="error"/><br>
    <form:input placeholder="Zabezpieczenia pojazdu: " path="carDetails.carSecurity"/><br>
    <form:errors path="carDetails.carSecurity" cssClass="error"/><br>
    <form:input placeholder="Rok produkcji: " path="carDetails.yearOfProduction"/><br>
    <form:errors path="carDetails.yearOfProduction" cssClass="error"/><br>
    <form:input placeholder="Rok pierwszej rejestracji: " path="carDetails.yearOfFirstRegistration" type="number"/><br>
    <form:errors path="carDetails.yearOfFirstRegistration" cssClass="error"/><br>
    <form:textarea placeholder="Uwagi: " cols="15" rows="3" path="comments"/><br>
    <form:errors path="comments" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>
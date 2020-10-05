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
</head>
<body>
<h1>Formularz dodawania nowego auta do floty<br></h1><br>
<%--@elvariable id="car" type="pl.kamilracki.flota.models.Car"--%>
<form:form method="post" modelAttribute="car">
    <form:hidden path="id"/>
    <h2>Dane z dowodu rejestracyjnego:</h2>
    Numer rejestracyjny: <form:input path="carDetails.licensePlate"/><br>
    <form:errors path="carDetails.licensePlate" cssClass="error"/><br>
    Marka i model samochodu: <form:input path="carDetails.modelCar"/><br>
    <form:errors path="carDetails.modelCar" cssClass="error"/><br>
    Numer Vin: <form:input path="carDetails.vinNumber"/><br>
    <form:errors path="carDetails.vinNumber" cssClass="error"/><br>
    Numer nadwozia: <form:input path="carDetails.chassisNumber"/><br>
    <form:errors path="carDetails.chassisNumber" cssClass="error"/><br>
    Numer silnika: <form:input path="carDetails.engineNumber"/><br>
    <form:errors path="carDetails.engineNumber" cssClass="error"/><br>
    Pojemność silnika: <form:input path="carDetails.engineCapacity"/><br>
    <form:errors path="carDetails.engineCapacity" cssClass="error"/><br>
    Ilość miejsc: <form:input path="carDetails.numberOfSeats"/><br>
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
    Zakład ubezpieczeń: <form:input path="carDetails.insuranceCompany"/><br>
    <form:errors path="carDetails.insuranceCompany" cssClass="error"/><br>
    Data następnego przeglądu: <form:input path="nextTechnicalInspectionDate" placeholder="YYYY-MM-DD" type="date"/><br>
    <form:errors path="nextTechnicalInspectionDate" cssClass="error"/><br>
    Zabezpieczenia pojazdu: <form:input path="carDetails.carSecurity"/><br>
    <form:errors path="carDetails.carSecurity" cssClass="error"/><br>
    Rok produkcji: <form:input path="carDetails.yearOfProduction"/><br>
    <form:errors path="carDetails.yearOfProduction" cssClass="error"/><br>
    Rok pierwszej rejestracji: <form:input path="carDetails.yearOfFirstRegistration" type="number"/><br>
    <form:errors path="carDetails.yearOfFirstRegistration" cssClass="error"/><br>
    Uwagi: <form:textarea cols="15" rows="3" path="comments"/><br>
    <form:errors path="comments" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
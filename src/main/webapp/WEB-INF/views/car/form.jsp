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
<%--@elvariable id="car" type="pl.coderslab.superprojekt.model.Car"--%>
<form:form method="post" modelAttribute="car">
    <form:hidden path="id"/>
    Marka i model samochodu: <form:input path="modelCar"/><br>
    <form:errors path="modelCar" cssClass="error"/><br>
    Numer Vin: <form:input path="vinNumber"/><br>
    <form:errors path="vinNumber" cssClass="error"/><br>
    Numer rejestracyjny: <form:input path="licensePlate"/><br>
    <form:errors path="licensePlate" cssClass="error"/><br>
    Numer nadwozia: <form:input path="chassisNumber"/><br>
    <form:errors path="chassisNumber" cssClass="error"/><br>
    Numer silnika: <form:input path="engineNumber"/><br>
    <form:errors path="engineNumber" cssClass="error"/><br>
    Pojemność silnika: <form:input path="engineCapacity"/><br>
    <form:errors path="engineCapacity" cssClass="error"/><br>
    Ilość miejsc: <form:input path="numberOfSeats"/><br>
    <form:errors path="numberOfSeats" cssClass="error"/><br>
    Rodzaj pojazdu: <form:select path="typeOfCar">
    <form:option value="Osobowy" label="Osobowy"/>
    <form:option value="Ciężarowy" label="Ciężarowy"/>
    </form:select><br>
    <form:errors path="typeOfCar" cssClass="error"/><br>
    Rodzaj paliwa: <form:select path="fuelType">
    <form:option value="Benzyna" label="Benzyna"/>
    <form:option value="ON" label="ON"/>
    </form:select><br>
    <form:errors path="fuelType" cssClass="error"/><br>
    Czy auto posiada GPS: <form:select path="hasGPS">
    <form:option value="Tak" label="Tak"/>
    <form:option value="Nie" label="Nie"/>
    </form:select><br>
    <form:errors path="hasGPS" cssClass="error"/><br>
    Data wygaśnięcia polisy OC: <form:input path="ocPolicyExpireDate" placeholder="YYYY-MM-DD" type="date"/><br>
    <form:errors path="ocPolicyExpireDate" cssClass="error"/><br>
    Data wygaśnięcia polisy AC: <form:input path="acPolicyExpireDate" placeholder="YYYY-MM-DD" type="date"/><br>
    <form:errors path="acPolicyExpireDate" cssClass="error"/><br>
    Zakład ubezpieczeń: <form:input path="insuranceCompany"/><br>
    <form:errors path="insuranceCompany" cssClass="error"/><br>
    Data następnego przeglądu: <form:input path="nextTechnicalInspectionDate" placeholder="YYYY-MM-DD" type="date"/><br>
    <form:errors path="nextTechnicalInspectionDate" cssClass="error"/><br>
    Zabezpieczenia pojazdu: <form:input path="carSecurity"/><br>
    <form:errors path="carSecurity" cssClass="error"/><br>
    Rok produkcji: <form:input path="yearOfProduction"/><br>
    <form:errors path="yearOfProduction" cssClass="error"/><br>
    Rok pierwszej rejestracji: <form:input path="yearOfFirstRegistration"/><br>
    <form:errors path="yearOfFirstRegistration" cssClass="error"/><br>
    Uwagi: <form:input path="comments"/><br>
    <form:errors path="comments" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
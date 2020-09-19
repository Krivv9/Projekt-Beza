<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Karta misięczna</title>
</head>
<body>
<h1>Miesięczna karta kontroli zużycia paliwa</h1><br>
<%--@elvariable id="car" type="pl.coderslab.superprojekt.model.MonthUse"--%>
<form:form method="post" modelAttribute="monthUse">
    <form:hidden path="id"/>
    Miesiąc: <form:input path="month"/><br>
    <form:errors path="month" cssClass="error"/><br>
    Stan licznika (początek miesiąca): <form:input path="numbersOfKilometersOnStartOfMonth"/><br>
    <form:errors path="numbersOfKilometersOnStartOfMonth" cssClass="error"/><br>
    Ilość kilometrów na koniec miesiąca: <form:input path="numbersOfKilometersOnEndOfMonth"/><br>
    <form:errors path="numbersOfKilometersOnEndOfMonth" cssClass="error"/><br>
    Ilość kupionego paliwa: <form:input path="amountOfFuelBought"/><br>
    <form:errors path="amountOfFuelBought" cssClass="error"/><br>
    Rzeczywiste zużycie paliwa: <form:input path="realFuelConsumption"/><br>
    <form:errors path="realFuelConsumption" cssClass="error"/><br>
    Ilość zakupionego paliwa do użytku prywatnego: <form:input path="amountOfFuelForPrivateUse"/><br>
    <form:errors path="amountOfFuelForPrivateUse" cssClass="error"/><br>
    Ilość dokumentów potwierdzających zakup: <form:input path="quantityOfDocuments"/><br>
    <form:errors path="quantityOfDocuments" cssClass="error"/><br>
    Uwagi: <form:input path="comments"/><br>
    <form:errors path="comments" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>

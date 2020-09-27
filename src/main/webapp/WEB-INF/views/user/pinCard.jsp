<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz Użytkownika</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Formularz przypisania karty do użytkownika<br></h1><br>
<%--@elvariable id="user" type="pl.coderslab.superprojekt.model.User"--%>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <h3>Numer karty flotowej do przypisania ${user.fleetCard.cardNumber}<br></h3><br><br>
    Dane użytkownika podanej karty:
    Imię: <form:input path="firstName"/><br>
    <form:errors path="firstName" cssClass="error"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/><br>
    Numer telefonu: <form:input path="phoneNumber"/><br>
    <form:errors path="phoneNumber" cssClass="error"/><br>
    Hasło: <form:input path="password"/><br>
    <form:errors path="password" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
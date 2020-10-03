<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Przypisywanie użytkownika do auta</title>
</head>
<body>
<h1>Formularz dodawania nowego auta do floty<br></h1><br>
<%--@elvariable id="car" type="pl.coderslab.superprojekt.models.Car"--%>
<form:form method="post" modelAttribute="car">
    Użytkownik: <form:select path="user">
    <form:option value="0" label="wybierz właściciela"/>
    <form:options items="${users}" itemValue="id" itemLabel="fullName"/>
</form:select><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>

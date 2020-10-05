<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Administratora</title>
</head>
<body>
<br><h1>Panel Administratora ${name}</h1><br>
<a href="<c:url value="/cars/all"/>">Auta</a><br>
<a href="<c:url value="/users/all"/>">Użytkownicy</a><br>
<a href="<c:url value="/monthUses/all"/>">Zużycie miesięczne</a><br>
<a href="<c:url value="/cards/all"/>">Karty flotowe</a><br>
</body>
</html>

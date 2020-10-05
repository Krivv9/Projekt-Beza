<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Użytkownika</title>
</head>
<body>
Cześć ${name}. Wybierz co chcesz zrobić <br><br>
<a href="<c:url value="/cars/all"/>">Auta</a><br>
<a href="<c:url value="/admin/home"/>">Panel admina</a><br>
</body>
</html>

</body>
</html>

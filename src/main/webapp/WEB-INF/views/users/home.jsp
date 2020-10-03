<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Użytkownika</title>
</head>
<body>
Cześć ${user.fullName}. Wybierz co chcesz zrobić <br><br>
<a href="<c:url value="/cars/all"/>">Auta</a><br>
<a href="<c:url value="/monthUses/all"/>">Zużycie miesięczne</a><br>
<a href="<c:url value="/admin/home"/>">Panel admina</a><br>
</body>
</html>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Za niski poziom uprawnień</title>
</head>
<body>
<h1>Niestety masz za małe uprawnienia, żeby wejść na daną stronę</h1><br><br>

<h1><a href="<c:url value="/users/home"/>"> Spróbuj tu</a></h1>
</body>
</html>

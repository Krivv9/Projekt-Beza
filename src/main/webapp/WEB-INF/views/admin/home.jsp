<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Administratora</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>

<br><h1>Panel Administratora ${name}</h1><br>
<a href="<c:url value="/cars/all"/>">Auta</a><br>
<a href="<c:url value="/users/all"/>">Użytkownicy</a><br>
<a href="<c:url value="/monthUses/all"/>">Zużycie miesięczne</a><br>
<a href="<c:url value="/cards/all"/>">Karty flotowe</a><br>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

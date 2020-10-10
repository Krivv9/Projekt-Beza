<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Użytkownika</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>
<section class="section">
    <div class="container has-text-centered">
        <h1>Strona poświęcona zarządzaniu flotą aut. <br>
            Jeśli nie jesteś zalogowanym użytkownikiem <br>
            to to zmień lub zarejestruj konto. Konto Admina<br>
            jest zajęte.<br><br>

            <sec:authorize access="hasRole('USER')"> Informacja tylko dla zalogowanych </sec:authorize>
            Witaj ${userLogin}, co chcesz zrobić<br><br>
            <a href="<c:url value="/cars/all"/>">Auta</a><br>
            <a href="<c:url value="/monthUses/add/1"/>">Formularz miesięcznego zużycia paliwa</a><br>

            <sec:authorize access="hasRole('ADMIN')">
            <a href="<c:url value="/admin/home"/>">Panel admina</a><br>
            </sec:authorize>

            <footer class="footer">
                <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
            </footer>
</body>
</html>

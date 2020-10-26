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
        <h1><b>
            <c:if test="${login =='anonymousUser'}">Witaj jesteś nie zalogowany</c:if>
        </b></h1> <br><br>

            Strona poświęcona zarządzaniu flotą aut. <br>
            Jeśli nie jesteś zalogowanym użytkownikiem <br>
            to to zmień lub zarejestruj konto. Konto Admina<br>
            jest zajęte.<br><br>


            <a href="<c:url value="/admin/home"/>">Panel admina</a><br>

            <footer class="footer">
                <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
            </footer>
</body>
</html>

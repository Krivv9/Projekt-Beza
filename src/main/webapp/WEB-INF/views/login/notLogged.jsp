<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Błąd przy logowaniu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>

<h1>Nie jesteś zalogowanym użytkownikiem</h1>
<a href="/login">Spróbuj ponownie</a>
<a href="http://www.coderslab.pl">mam dość idę stąd</a>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Za niski poziom uprawnień</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>
<div class="columns is-centered">
    <div class="column is-5 is-4-desktop">
<h1>Niestety masz za małe uprawnienia, żeby wejść na daną stronę</h1><br><br>

<h1><a href="<c:url value="/"/>"> Spróbuj tu</a></h1>
    </div>
</div>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

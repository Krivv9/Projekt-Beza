<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Fleet Management - Potwierdź wylogowanie</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
</head>
<body>
<section class="navbar">
    <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
</section>

<section class="section">
    <div class="container is-fluid">
        <div class="notification">
            <h5 class="title is-5 has-text-centered">Potwierdź wylogowanie</h5>
            <form method="post" action="/logout">
                <div class="field is-grouped is-grouped-centered">
                    <p class="control">
                    <div class="buttons">
                        <button class="button is-success" type="submit">
                            <strong>Potwierdź</strong>
                        </button>
                        <a class="button is-light" href="/">
                            Anuluj
                        </a>
                    </div>
                    </p>
                </div>
                <sec:csrfInput/>
            </form>
        </div>
    </div>
</section>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>


</body>
</html>
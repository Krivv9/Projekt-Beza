<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz Logowania</title>
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
<h1>Logowanie Użytkownika<br></h1><br>
        <p>Podaj login i hasło zapisane w czasie rejestracji</p><br>
        <div class="columns is-centered">
            <div class="column is-5 is-4-desktop">
                <form method="post" action="/login">
                    <div class="container">
                        <div class="control">
                            <input class="input" type="text" name="login" placeholder="Login">
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <input class="input" type="password" name="password" placeholder="Hasło">
                        </div>
                    </div>
                    <div class="control">
                        <button type="submit" class="button is-link is-primary is-fullwidth">Loguj</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </div>
                    <a href="/registration">Jeszcze nie masz konta, Zarejstruj się</a>
                </form>
            </div>
        </div>
    </div>
</section>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja użytkownika</title>
        <style>
            .error {
                color: red;
            }
        </style>
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
<h1>Formularz dodawania nowego użytkownika<br></h1><br>
<%--@elvariable id="user" type="pl.kamilracki.flota.models.entities.User"--%>

        <div class="columns is-centered">
            <div class="column is-5 is-4-desktop">
        <form:form method="post" modelAttribute="userToAdd" action="/registration">
            <div class="container">
                <div class="control">
    Imię: <form:input path="firstName"/><br>
                </div>
            </div>
    <form:errors path="firstName" cssClass="error"/><br>
            <div class="container">
                <div class="control">
    Nazwisko: <form:input path="lastName"/><br>
            </div>
        </div>
    <form:errors path="lastName" cssClass="error"/><br>
            <div class="container">
                <div class="control">
    Login: <form:input path="login"/><br>
    </div>
    </div>
    <form:errors path="login" cssClass="error"/><br>
            <div class="container">
                <div class="control">
    Numer telefonu: <form:input path="phoneNumber"/><br>

    <form:errors path="phoneNumber" cssClass="error"/><br>
                    <div class="container">
                        <div class="control">
    Hasło: <form:input path="password" type="password"/><br>
    </div>
    </div>
    <form:errors path="password" cssClass="error"/><br>
                    <div class="container">
                        <div class="control">
    Powtórz hasło: <form:input path="doublePassword" type="password"/><br>
    </div>
    </div>
                    <div class="control">
        <form:errors path="doublePassword" cssClass="has-text-danger"/><br>
    <input type="submit" class="button is-link is-primary is-fullwidth" value="Wyślij">
                    </div>
            </form:form>
                </div>
            </div>
            </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>
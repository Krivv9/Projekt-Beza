<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz Użytkownika</title>
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
<h1>Formularz dodawania nowego auta do floty<br></h1><br>
<%--@elvariable id="user" type="pl.kamilracki.flota.models.entities.User"--%>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    Imię: <form:input path="firstName"/><br>
    <form:errors path="firstName" cssClass="error"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/><br>
    Numer telefonu: <form:input path="phoneNumber"/><br>
    <form:errors path="phoneNumber" cssClass="error"/><br>
    Hasło: <form:input path="password" type="password"/><br>
    <form:errors path="password" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

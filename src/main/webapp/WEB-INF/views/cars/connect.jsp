<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Przypisywanie użytkownika do auta</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">

</head>
<body>
<section>
    <section class="navbar">
        <jsp:include page="/WEB-INF/views/page/nav.jsp"/>
    </section>
</section>
<h1>Formularz dodawania nowego auta do floty<br></h1><br>
<%--@elvariable id="car" type="pl.kamilracki.flota.models.entities.Car"--%>
<form:form method="post" modelAttribute="car">
    Użytkownik: <form:select path="user">
    <form:option value="0" label="wybierz właściciela"/>
    <form:options items="${users}" itemValue="id" itemLabel="fullName"/>
</form:select><br>
    <input type="submit" value="Wyślij">
</form:form>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/page/footer.jsp"/>
</footer>
</body>
</html>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar has-text-centered">
        <div class="navbar-brand">
            <a class="navbar-burger" role="button" aria-label="menu" aria-expanded="false">
                <span aria-hidden="true">

                </span>
                <span aria-hidden="true"></span>
                <span aria-hidden="true">
            </span>
            </a>
        </div>
        <div class="navbar-menu">
            <div class="navbar-start">
                    <a class="navbar-item" href="/cars/all"> Auta</a>
                    <a class="navbar-item" href="/cards/all">Karty paliwowe</a>
                    <a class="navbar-item" href="/users/all">Użytkownicy</a>
                    <a class="navbar-item" href="/">Strona główna</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="<c:url value="/admin/home"/>">Panel admina</a><br>
                    </sec:authorize>
                </div>
                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <a class="button is-light" href="/login">Logowanie</a>
                            <a class="button is-primary" href="/registration">Rejestracja</a>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</nav>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar">
    <div class="container">
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
                <a class="navbar-item" href="/users/all">Uzytkownicy</a>
                <a class="navbar-item" href="/dashboard">Strona główna</a>
            </div>
            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="buttons">
                        <a class="button is-light" href="/login">Logowanie</a>
                        <a class="button is-primary" href="/registration">Rejestracja</a>
                        <a class="button is-light" href="/logout-confirm">Wylogowanie</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
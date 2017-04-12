
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <div id="title">
        <h1>NerdBook</h1>
    </div>

    <nav class="navLeft">
        <ul>
            <li><a class="sonoQui" href="bacheca.html">Bacheca</a></li>
            <li><a href="descrizione.html">Descrizione</a></li>
            <li><a href="profilo.html">Profilo</a></li>
        </ul>
    </nav>
    <nav class="navRight">
        <c:if test="${loggedIn == true}"><ul><li><a href="login.html?logout=true">LogOut</a></li></ul></c:if>
        <c:if test="${loggedIn != true}"><ul><li><a href="login.html">Login</a></li></ul></c:if>
    </nav>
</header>


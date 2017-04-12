<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>NerdBook: login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Campanile">
        <meta name="keywords" content="login NerdBook">

        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
    </head>
    <body>
        <div id="page">
            <header>
                <div id="title">
                    <h1>NerdBook</h1>
                </div>
                <nav id="navLogin">
                    <ul>
                        <li><a href="descrizione.html">Descrizione</a></li>
                        <li><a href="bacheca.html">Bacheca</a></li>
                        <li><a href="profilo.html">Profilo</a></li>
                    </ul>
                </nav>
            </header>

            <div id="contentLogin">
                <div id="login">

                    <form action="Login" method="post">
                        <div id="nome">
                            <label for="usName">Username</label>
                        </div>
                        <div>
                            <input type="text" name="username" id="usName" value="username"/>
                        </div>
                        <div id="pass">
                            <label for="pswd">Password</label>
                        </div>
                        <div>
                            <input type="password" name="pswd" id="pswd" value="oscurato" />
                        </div>
                        <div id="accedi">
                            <button type="submit">Accedi</button>
                        </div>
                        
                        <c:if test="${invalidData == true}">
                            <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook: Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Campanile">
        <meta name="keywords" content="profilo NerdBook">

        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </head>
    <body>
        <div id="page">

            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="header.jsp"/>

            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="sidebar.jsp"/>

            <div id="profContent">
                <div id="foto">
                    <c:if test="${not empty utente.urlFoto}"><img alt="Utente" src="${utente.urlFoto}" class="fotoProfilo"></c:if>
                    <c:if test="${empty utente.urlFoto}"><img alt="Utente" src="${foto}" class="fotoProfilo"></c:if>
                    <c:if test="${empty utente.urlFoto && flag == null}"><img alt="Utente" src="M3/immagini/Chris" class="fotoProfilo"></c:if>

                </div>
                <div id="infoo">
                    <form method="post" id='infoProfilo' action="Profilo?flag=true">
                        <div id="nome">
                            <label for="nomeUtente">Nome</label>
                            <c:if test="${not empty nome}">
                                <input type="text" name="nome" id="nomeUtente" value="${nome}"/>
                            </c:if>
                            <c:if test="${not empty utente.nome}">
                                <input type="text" name="nome" id="nomeUtente" value="${utente.nome}"/>
                            </c:if>
                        </div>

                        <div id="cognome">
                            <label for="cognomeUtente">Cognome</label>
                            <c:if test="${not empty cognome}">
                                <input type="text" name="cognome" id="cognomeUtente" value="${cognome}"/>
                            </c:if>
                            <c:if test="${not empty utente.cognome}">
                                <input type="text" name="cognome" id="cognomeUtente" value="${utente.cognome}"/>
                            </c:if>
                        </div>

                        <div id="picProfilo">
                            <label for="imgProfilo">URL immagine del profilo:</label>
                            <c:if test="${not empty foto}">
                                <input type="text" name="foto" id="imgProfilo" value="${foto}"/>
                            </c:if>
                            <c:if test="${not empty utente.urlFoto}">
                                <input type="text" name="foto" id="imgProfilo" value="${utente.urlFoto}"/>
                            </c:if>                            
                        </div>

                        <div id="frase">
                            <label for="frase">Inserisci una frase di presentazione</label>
                            <c:if test="${not empty frase}">
                                <textarea rows="5" cols="25" name="frase" id="frasePresentazione">${frase} </textarea>
                            </c:if>
                            <c:if test="${not empty utente.frasePresentazione}">
                                <textarea rows="5" cols="25" name="frase" id="frasePresentazione">${utente.frasePresentazione} </textarea>
                            </c:if>
                        </div>

                        <div id="dataNascita">
                            <label for="dataDiNascita">Data di nascita</label>
                            <c:if test="${not empty dataNascita}">
                                <input type="text" name="dataNascita" id="dataNascita" value="${dataNascita}" />
                            </c:if>
                            <c:if test="${not empty utente.dataNascita}">
                                <input type="text" name="dataNascita" id="dataNascita" value="${utente.dataNascita}" />
                            </c:if>
                        </div>

                        <div id="pass">
                            <label for="pswd">Password</label>
                            <c:if test="${not empty pswd}">
                                <input type="password" name="pswd" id="pswd" value="${pswd}" />
                            </c:if>
                            <c:if test="${not empty utente.password}">
                                <input type="password" name="pswd" id="pswd" value="${utente.password}" />
                            </c:if>
                        </div>

                        <div id="confPass">
                            <label for="cPswd">Conferma password</label>
                            <c:if test="${not empty pswd}">
                                <input type="password" name="pswd" id="pswd" value="${pswd}" />
                            </c:if>
                            <c:if test="${not empty utente.password}">
                                <input type="password" name="pswd" id="pswd" value="${utente.password}" />
                            </c:if>
                        </div>

                        <div id="aggiorna">
                            <button type="submit">Aggiorna</button>
                        </div>
                        <c:if test="${flag == true}">
                            <div id="flag">I dati sono stati inseriti correttamente</div>
                        </c:if>
                    </form>
                    <form id ="cancellaProfilo" action = "Profilo?cancella=true" method="post">
                        <button type ="submit">Cancella utente</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

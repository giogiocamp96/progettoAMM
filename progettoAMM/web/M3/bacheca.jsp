<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>NerdBook: bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Campanile">
        <meta name="keywords" content="NerdBook bacheca">

        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
    </head>
    
    <body>
        <div id="page">
            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="header.jsp"/>

            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="sidebar.jsp"/>

            <div id="content">
                <div class="nuovopost">
                    <form class="newpost" name="newpost" action="Bacheca?inviopost=true" method="post">
                        <h2>${utente.nome} ${utente.cognome}</h2>
                        <div class="contentnewpost">
                            <div class="newpost">
                                <p> Scrivi qualcosa...</p>
                                <div>
                                    <textarea class="newpost" name="testopost"></textarea>
                                </div>
                                <div>
                                    <p>URL immagine:</p> 
                                </div>
                                <div>
                                    <input class="newpost" type="text" name="immaginepost">
                                </div>
                                <div>
                                    <p>URL link:</p> 
                                </div>
                                <div>
                                    <input class="newpost" type="text" name="linkpost">
                                </div>
                                
                            </div>
                        </div>
                        <div id="iniviopost">
                            <button type="submit">Invio</button>
                        </div>
                    </form>
                </div>

                <div id="post">
                    <c:if test="${inviopost == null}">
                        <c:forEach var="post" items="${posts}">
                            <div class="post">
                                <c:if test="${not empty post.nomeUt}"><h2>${post.nomeUt}</h2></c:if>
                                <c:if test="${not empty post.imageUt}">
                                    <div class="picProfilo">
                                        <img alt="utente pic" src ="${post.imageUt}" height="100" width="100">
                                    </div>
                                </c:if>

                                <c:if test="${post.testo != null}">
                                    <p>${post.testo}</p>
                                </c:if>

                                <c:if test="${post.urlImmagine != null}">
                                    <img src="${post.urlImmagine}">
                                </c:if>

                                <c:if test="${post.link != null}">
                                    <p><a href = ${post.link}>${post.link}</a></p>
                                </c:if>
                            </div>
                        </c:forEach>                     
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>




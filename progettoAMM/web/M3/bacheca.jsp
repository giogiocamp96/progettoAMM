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
                <div id="post">
                    
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

                    
<!--                   <div id ="postSunny" class="post">
                        <h2>Sunny Baudelaire</h2>
                        <div class="picProfilo">
                            <img alt="Sunny Baudelaire pic" src ="immagini/sunny.jpg" height="100" width="100">
                        </div>
                        <p> Mi hanno appena regalato una trottola di legno, ma l'ho mangiata! ;) </p>
                    </div>
                    <div id="postViolet" class="post">
                        <h2>Violet Baudelaire</h2>
                        <div class="picProfilo">
                            <img alt="Violet Baudelaire pic" src="immagini/violet.jpg" height="100" width="100">
                        </div>
                        <p> Il Conte avrÃ  una sorpresina grazie alla mia nuova invenzione! Ahahah! </p>
                        <img alt="Immagine post Violet" src="immagini/olaf.jpg" height="200px" width="350px">
                    </div>
                    <div id="postKlaus" class="post">
                        <h2>Klaus Baudelaire</h2>
                        <div class="picProfilo">
                            <img alt="Klaus Baudelaire pic" src="immagini/klaus.jpg" height="100" width="100">
                        </div>
                        <p> Questa Ã¨ la brutta copia del mio cannocchiale speciale. #povery </p>
                        <a href="https://it.wikipedia.org/wiki/Cannocchiale">https://it.wikipedia.org/wiki/Cannocchiale</a>
                    </div>-->
                  
                </div>
            </div>
        </div>
    </body>
</html>

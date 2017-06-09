<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="sideBar">
    <div id="search">
            <input  id="campoRicerca" type="text" placeholder="cerca un tuo amico" value=""  onkeyup=ricercaDinamica()>
            <button  id="cercaUtente">Cerca</button>
    </div>
    <div id="people">
        <p class ="titolini">Persone</p>
        <ul>
            <c:forEach var="persona" items="${listaUtenti}">
                <li>
                    <div>
                        <img class="fotoprofilolato" title="profilo" alt="immagine profilo" src="${persona.urlFoto}">
                        <a href="bacheca.html?postvisualizzati=true&idUsers=${persona.idUtente}" class="conFoto">${persona.nome} ${persona.cognome}</a>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div id="groups">
        <p class="titolini">Gruppi</p>
        <ul>
            <c:forEach var="gruppi" items="${listaGruppi}">                
                <li><div class="botdiv"><a href="bacheca.html?postgruppivisualizzati=true&idGruppoSideBar=${gruppi.idGruppo}">
                            ${gruppi.nome}</a></div></li>                
            </c:forEach>
        </ul>
    </div>
</div>
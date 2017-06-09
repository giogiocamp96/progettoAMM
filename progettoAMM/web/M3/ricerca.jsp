<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<json:array>
    <c:forEach var="utente" items="${lista}">
      
            <json:object>
                <json:property name="nome" value="${utente.nome}"/>
                <json:property name="cognome" value="${utente.cognome}"/>
                <json:property name="idUtente" value="${utente.idUtente}"/>
                <json:property name="urlFoto" value="${utente.urlFoto}"/>
            </json:object>
      
    </c:forEach>
</json:array>
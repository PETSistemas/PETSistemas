<%-- 
    Document   : listarTutor
    Created on : 29/01/2013, 10:11:18
    Author     : Bruno Monteiro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
    <fieldset>
        <legend>Tutores do PET </legend>
        <c:if test="${empty tutoresAtivos}">
            <span>Não há tutores nessa categoria</span>
        </c:if>
       <c:forEach var="tutor" items="${tutoresAtivos}" varStatus="status" >
            <p>${status.count}: ${tutor.nome}</p>
            <p>Entrou no PET: ${tutor.dataEntrada}</p>
        </c:forEach>

    </fieldset>
    <br/><br/>
    <fieldset>
        <legend>Antigos Tutores</legend>
        <c:if test="${empty tutoresDesativos}">
            <span>Não há tutores nessa categoria</span>
        </c:if>
               <c:forEach var="tutor" items="${tutoresDesativos}" varStatus="status" >
            <p>${status.count}: ${tutor.nome}</p>
            <p>Entrou no PET: ${tutor.dataEntrada}</p>
            <p>Saiu do PET: ${tutor.dataSaida}</p>
        </c:forEach>
    </fieldset>
    <div><a href="${pageContext.request.contextPath}/tutor">Voltar</a></div>
</div>
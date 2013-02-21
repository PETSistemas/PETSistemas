<%-- 
    Document   : listarTutor
    Created on : 29/01/2013, 10:11:18
    Author     : Bruno Monteiro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
    <fieldset>
        <legend>Integrantes do PET </legend>
        <c:if test="${empty tutoresAtivos}">
            <span>Não há tutores nessa categoria</span><br>
        </c:if>
        <c:forEach var="tutor" items="${tutoresAtivos}" varStatus="status" >
            <div>Nome: ${tutor.nome}</div>
           
                <div>Entrou no PET: ${tutor.dataEntrada}</div><br>
        </c:forEach>

    </fieldset>
    <br/><br/>
    <fieldset>
        <legend>Antigos Integrantes</legend>
        <c:if test="${empty tutoresDesativos}">
            <span>Não há tutores nessa categoria</span>
        </c:if>
        <c:forEach var="tutor" items="${tutoresDesativos}" varStatus="status" >
            <div>Nome: ${tutor.nome}</div>
           
            <div>Entrou no PET: ${tutor.dataEntradaFormatada}</div>
            <div>Saiu no PET: ${tutor.dataSaidaFormatada}</div><br>
        </c:forEach>
    </fieldset>
    <br><div><a href="${pageContext.request.contextPath}/tutor">Voltar</a></div>
</div>

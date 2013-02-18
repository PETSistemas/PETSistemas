<%-- 
    Document   : listarColaborador
    Created on : 29/01/2013, 10:11:18
    Author     : Bruno Monteiro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
    <fieldset>
        <legend>Colaboradores do PET </legend>
        <c:if test="${empty colaboradoresAtivos}">
            <span>Não há colaboradores nessa categoria</span>
        </c:if>
        <c:forEach var="colaborador" items="${colaboradoresAtivos}" varStatus="status" >
            <p>${status.count}: ${colaborador.nome}</p>
        </c:forEach>

    </fieldset>
    <br/><br/>
    <fieldset>
        <legend>Antigos Colaboradores</legend>
        <c:if test="${empty colaboradoresDesativos}">
            <span>Não há colaboradores nessa categoria</span>
        </c:if>
        <c:forEach var="colaborador" items="${colaboradoresDesativos}" varStatus="status" >
            <p>${status.count}: ${colaborador.nome}</p>
        </c:forEach>
    </fieldset>
    <div><a href="${pageContext.request.contextPath}/colaborador">Voltar</a></div>
</div>
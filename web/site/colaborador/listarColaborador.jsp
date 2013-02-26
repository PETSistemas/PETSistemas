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
            <span>Não há colaboradores nessa categoria</span><br>
        </c:if>

        <c:forEach var="colaborador" items="${colaboradoresAtivos}" varStatus="status" >
            <div>Nome: ${colaborador.nome}</div>
            <div>Situação: <select name="situacao" disabled="true">
                    <option value=1 <c:if test="${colaborador.situacao=='1'}">selected</c:if>>Ativo</option>
                    <option value=2 <c:if test="${colaborador.situacao=='2'}">selected</c:if>>Desativo</option>
                    </select></div>
                <div>Entrou no PET: ${colaborador.dataEntrada}</div><br>
        </c:forEach>

    </fieldset><br/><br/>

    <fieldset>
        <legend>Antigos Colaboradores</legend>

        <c:if test="${empty colaboradoresDesativos}">
            <span>Não há colaboradores nessa categoria</span>
        </c:if>

        <c:forEach var="colaborador" items="${colaboradoresDesativos}" varStatus="status" >
            <div>Nome: ${colaborador.nome}</div>
            <div>Curso: <select name="situacao" disabled="true">
                    <option value=1 <c:if test="${colaborador.situacao=='1'}">selected</c:if>>Ativo</option>
                    <option value=2 <c:if test="${colaborador.situacao=='2'}">selected</c:if>>Desativo</option>
                    </select></div>
                <div>Entrou no PET: ${colaborador.dataEntradaFormatada}</div>
            <div>Saiu no PET: ${colaborador.dataSaidaFormatada}</div><br>
        </c:forEach>

    </fieldset>
    <br><div><a href="index">Voltar</a></div>
</div>

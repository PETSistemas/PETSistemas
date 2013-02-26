<%-- 
    Document   : listarPetiano
    Created on : 06/12/2012, 10:11:18
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
    <fieldset>
        <legend>Integrantes do PET </legend>

        <c:if test="${empty petianosAtivos}">
            <span>Não há petianos nessa categoria</span><br>
        </c:if>

        <c:forEach var="petiano" items="${petianosAtivos}" varStatus="status" >
            <div>Nome: ${petiano.nome}</div>
            <div>Curso: <select name="curso" disabled="true">
                    <option value=1 <c:if test="${petiano.curso=='1'}">selected</c:if>>Análise de Sistemas</option>
                    <option value=2 <c:if test="${petiano.curso=='2'}">selected</c:if>>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                    <option value=3 <c:if test="${petiano.curso=='3'}">selected</c:if>>Tecnologia em Redes de Computadores</option>
                </select></div>
            <div>Entrou no PET: ${petiano.dataEntrada}</div><br>
        </c:forEach>

    </fieldset><br/><br/>

    <fieldset>
        <legend>Antigos Integrantes</legend>

        <c:if test="${empty petianosDesativos}">
            <span>Não há petianos nessa categoria</span>
        </c:if>

        <c:forEach var="petiano" items="${petianosDesativos}" varStatus="status" >
            <div>Nome: ${petiano.nome}</div>
            <div>Curso: <select name="curso" disabled="true">
                    <option value=1 <c:if test="${petiano.curso=='1'}">selected</c:if>>Análise de Sistemas</option>
                    <option value=2 <c:if test="${petiano.curso=='2'}">selected</c:if>>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                    <option value=3 <c:if test="${petiano.curso=='3'}">selected</c:if>>Tecnologia em Redes de Computadores</option>
                </select></div>
            <div>Entrou no PET: ${petiano.dataEntradaFormatada}</div>
            <div>Saiu no PET: ${petiano.dataSaidaFormatada}</div><br>
        </c:forEach>
    
    </fieldset>
    <br><div><a href="index">Voltar</a></div>
</div>

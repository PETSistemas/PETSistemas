<%-- 
    Document   : exibirPetianoCPF
    Created on : 06/12/2012, 10:11:18
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <fieldset>
        <legend>Integrantes do PET </legend>
        <c:forEach var="petiano" items="${petianosAtivos}" varStatus="status" >
            <p>${status.count}: ${petiano.nome}</p>
            <p>Entrou no PET: ${petiano.dataEntrada}</p>
            <p>Curso: <select name="curso" disabled="true">
                    <option value=1 <c:if test="${petiano.curso=='1'}">selected</c:if>>Análise de Sistemas</option>
                    <option value=2 <c:if test="${petiano.curso=='2'}">selected</c:if>>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                    <option value=3 <c:if test="${petiano.curso=='3'}">selected</c:if>>Tecnologia em Redes de Computadores</option>
                    </select></p>
            </c:forEach>
    </fieldset>
    <br/><br/>
    <fieldset>
        <legend>Antigos Integrantes</legend>
        <c:forEach var="petiano" items="${petianosDesativos}" varStatus="status" >
            <p>${status.count}: ${petiano.nome}</p>
            <p>Entrou no PET: ${petiano.dataEntradaFormatada}</p>
            <p>Curso: <select name="curso" disabled="true">
                    <option value=1 <c:if test="${petiano.curso=='1'}">selected</c:if>>Análise de Sistemas</option>
                    <option value=2 <c:if test="${petiano.curso=='2'}">selected</c:if>>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                    <option value=3 <c:if test="${petiano.curso=='3'}">selected</c:if>>Tecnologia em Redes de Computadores</option>
                    </select></p>
                <p>Saiu no PET: ${petiano.dataSaidaFormatada}</p>
        </c:forEach>
    </fieldset>
    <p><a href="${pageContext.request.contextPath}/petiano">Voltar</a></p>
</div>

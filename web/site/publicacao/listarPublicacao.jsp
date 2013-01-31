<%-- 
    Document   : listarPublicacao
    Created on : 31/01/2013, 18:17:20
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <fieldset>
        <legend>Publicações</legend>
        <c:forEach var="publicacao" items="${publicacoes}" varStatus="status">
            <p>${status.count}</p>
            <p>Titulo: ${publicacao.titulo}</p>
            <p>Resumo: </p>
            <textarea name="resumo" rows="10" cols="50" disabled="true">
                ${publicacao.resumo}
            </textarea>
            <p>Data Publicação: ${publicacao.dataPublicacao}</p>
            <p>Data Inclusão: ${publicacao.dataInclusao}</p>
            <p>Tipo: <select name="tipo" disabled="true">
                    <option value=1 <c:if test="${publicacao.tipo=='1'}">selected</c:if>>Artigo</option>
                    <option value=2 <c:if test="${publicacao.tipo=='2'}">selected</c:if>>Relatório</option>
                    <option value=3 <c:if test="${publicacao.tipo=='3'}">selected</c:if>>Técnico</option>
                    <option value=4 <c:if test="${publicacao.tipo=='4'}">selected</c:if>>Tutorial</option>
                    <option value=5 <c:if test="${publicacao.tipo=='5'}">selected</c:if>>Manual</option>
                    <option value=6 <c:if test="${publicacao.tipo=='6'}">selected</c:if>>Outros</option>
                </select>
            </p>
            <br><br>
        </c:forEach>
    </fieldset>
    <p><a href="${pageContext.request.contextPath}/publicacao">Voltar</a></p>
</div>


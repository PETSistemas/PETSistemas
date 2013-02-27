<%-- 
    Document   : publicacao
    Created on : 26/01/2013, 19:43:14
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <h1>Publicação</h1>
    <c:forEach var="publicacao" items="${publicacoes}" varStatus="status" >
        <p>${status.count}: ${publicacao.titulo}</p>
    </c:forEach>

    <p><a href="${pageContext.request.contextPath}/novaPublicacao">Cadastrar Publicação</a></p>
    <p><a href="${pageContext.request.contextPath}/buscarPublicacao">Buscar Publicação</a></p>
    <p><a href="${pageContext.request.contextPath}/listarPublicacao">Listar Publicação</a></p>
</div>

<%-- 
    Document   : noticia
    Created on : 20/01/2013, 19:50:22
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <h1>Notícia</h1>
    <c:forEach var="noticia" items="${noticias}" varStatus="status" >
        <p>${status.count}: ${noticia.titulo}</p>
    </c:forEach>

    <p><a href="${pageContext.request.contextPath}/novaNoticia">Cadastrar Notícia</a></p>
    <p><a href="${pageContext.request.contextPath}/buscarNoticia">Buscar Notícia</a></p>
</div>

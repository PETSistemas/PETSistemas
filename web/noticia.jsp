<%-- 
    Document   : petiano
    Created on : 05/12/2012, 08:55:22
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notícia</title>
    </head>
    <body>
        <div>
            <h1>Notícia</h1>
            <c:forEach var="noticia" items="${noticias}" varStatus="status" >
                <p>${status.count}: ${noticia.titulo}</p>
            </c:forEach>

            <p><a href="${pageContext.request.contextPath}/novaNoticia">Cadastrar Notícia</a></p>
            <p><a href="${pageContext.request.contextPath}/buscarNotícia">Buscar Notícia</a></p>
        </div>
    </body>
</html>

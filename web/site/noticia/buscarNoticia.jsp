<%-- 
    Document   : buscarNoticia
    Created on : 06/12/2012, 10:08:30
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Notícia</title>
    </head>
    <body>
        <div>
            <form method="POST" action="${pageContext.request.contextPath}/exibirNoticiaTitulo">
                <p>Título: <input type="text" name="titulo" size="14"></p>
                <p><input type="submit" value="Pesquisar">
                    <input type="reset" value="Limpar"></p>
            </form>
        </div>
        <p><a href="${pageContext.request.contextPath}/noticia">Voltar</a></p>
    </body>
</html>

<%-- 
    Document   : buscarNoticia
    Created on : 06/12/2012, 10:08:30
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form method="POST" action="${pageContext.request.contextPath}/exibirNoticiaTitulo">
        <fieldset>
            <legend>Pesquisa de Notícia</legend>
            <p>Título: <input type="text" name="titulo" size="14"></p>
            <p><input type="submit" value="Pesquisar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
</div>
<p><a href="${pageContext.request.contextPath}/noticia">Voltar</a></p>

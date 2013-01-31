<%-- 
    Document   : buscarPublicacao
    Created on : 30/01/2013, 22:18:30
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form method="POST" action="${pageContext.request.contextPath}/exibirPublicacaoTitulo">
        <fieldset>
            <legend>Pesquisa de Publicação</legend>
            <p>Título: <input type="text" name="titulo" size="14"></p>
            <p><input type="submit" value="Pesquisar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
    <p><a href="${pageContext.request.contextPath}/publicacao">Voltar</a></p>
</div>

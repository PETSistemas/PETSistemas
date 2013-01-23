<%-- 
    Document   : exibirNoticiaTitulo
    Created on : 06/12/2012, 10:11:18
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
            <fieldset>
                <legend>Cadastro de Notícia</legend>
                <p>Título: ${titulo}</p>
                <p>Conteúdo: </p>
                <textarea name="conteudo" rows="10" cols="50" disabled="true">
                    ${conteudo}
                </textarea>
                <p>Data Inicial: ${dataInicial}</p>
                <p>Data Final: ${dataFinal}</p>
                <p>Tipo: <select name="tipo" disabled="true">
                        <option value=1 <c:if test="${tipo=='1'}">selected</c:if>>Interna</option>
                        <option value=2 <c:if test="${tipo=='2'}">selected</c:if>>Externa</option>
                    </select>
                </p>
                <p>Petiano: ${petiano}</p>
            </fieldset>
            <p><a href="${pageContext.request.contextPath}/noticia">Voltar</a></p>
        </div>
    </body>
</html>

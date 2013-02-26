<%-- 
    Document   : novaNoticia
    Created on : 05/12/2012, 09:11:39
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/salvarNoticia">
        <fieldset>
            <legend>Cadastro de Notícia</legend>
            <p>Título: <input type="text" name="titulo" size="60"></p>
            <p>Conteúdo: </p>
            <textarea name="conteudo" rows="10" cols="50"></textarea>
            <p>Data Inicial: <input type="text" class="data" name="dataInicial" size="10"></p>
            <p>Data Final: <input type="text" class="data" name="dataFinal" size="10"></p>
            <p>Tipo: <select name="tipo">
                    <option value=></option>
                    <option value=1>Interna</option>
                    <option value=2>Externa</option>
                </select>
            </p>
            <p>Petiano: <select id="petiano" name="petiano">
                    <option value=""></option>
                    <c:forEach var="petiano" items="${petianos}">
                        <option value="${petiano.id}">${petiano.nome}</option>
                    </c:forEach>
                </select>
            </p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
</div>
    <p><a href="${pageContext.request.contextPath}/noticia">Voltar</a></p>
  
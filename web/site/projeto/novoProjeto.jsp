<%-- 
    Document   : novoProjeto
    Created on : Jan 29, 2013, 11:24:48 PM
    Author     : daivid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="salvarProjeto" method="post">

    <label for="nome">Nome do Projeto:</label><br>
    <input type="text" id="nome" name="nome"/><br>
    <label for="tipo">Tipo de Projeto:</label><br>
    <input type="checkbox" name="tipo" id="tipo" value="Ensino">Ensino<br>
    <input type="checkbox" name="tipo" id="tipo" value="Pesquisa">Pesquisa<br>
    <input type="checkbox" name="tipo" id="tipo" value="Extensao">Extensão<br>

    <label for="resumo">Resumo do Projeto:</label><br>
    <textarea id="resumo" name="resumo" maxlength="100">Resumo do Projeto
    </textarea><br>

    <label for="data_inicio">Data de Início:</label><br>
    <input type="date" id="data_inicio" name="data_inicio" />

    <select id="pessoa" name="pessoa">
        <c:forEach var="pessoa" begin="0" items="${requestScope.pessoas}">
            <option value="${pessoa.id}">${pessoa.nome} - ${pessoa.class.name}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Salvar"/>
</form>

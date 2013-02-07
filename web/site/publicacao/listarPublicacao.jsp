<%-- 
    Document   : listaPublicacao
    Created on : 05/02/2013, 20:56:02
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <fieldset>
        <legend>Publicações</legend>
        <fieldset>
            <legend>Buscar</legend>
            <form action="" method="">
                <input type=search id="" name="" size="75" value="Pesquisar">
                <input type="submit" id="" name="" value="Buscar">
            </form>
        </fieldset>

        <br><br>

        <table border="1px">
            <tr>
                <th>Titulo</th>
                <th>Data de Publicação</th>
                <th>Data de Inclusão</th>
                <th>Tipo de Publicação</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach var="publicacao" items="${publicacoes}" varStatus="status">
                <tr>
                    <td>${publicacao.titulo}</td>
                    <td>${publicacao.dataPublicacao}</td>
                    <td>${publicacao.dataInclusao}</td>
                    <td>
                        <c:choose>
                            <c:when test="${publicacao.tipo == 1}">
                                Artigo
                            </c:when>
                            <c:when test="${publicacao.tipo == 2}">
                                Relatório
                            </c:when>
                            <c:when test="${publicacao.tipo == 3}">
                                Técnico
                            </c:when>
                            <c:when test="${publicacao.tipo == 4}">
                                Tutorial
                            </c:when>
                            <c:when test="${publicacao.tipo == 5}">
                                Manual
                            </c:when>
                            <c:when test="${publicacao.tipo == 6}">
                                Outros
                            </c:when>
                        </c:choose>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/alterarPublicacao">Editar</a></td>
                    <td><a href="${pageContext.request.contextPath}/publicacao">Remover</a></td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
    <p><a href="${pageContext.request.contextPath}/publicacao">Voltar</a></p>
</div>


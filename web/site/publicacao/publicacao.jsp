<%-- 
    Document   : publicacaoADM
    Created on : 07/02/2013, 19:32:42
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarPublicacao" />
    </c:when>
    <c:otherwise>
        <div>
            <a href="novaPublicacao" class="btn btn-large">Nova Publicação</a>
        </div>
        <!--<fieldset>
            <legend>Buscar</legend>
            <form action="" method="">
                <p>
                    Buscar: <input id="campo" name="campo" type="search" value="Pesquisar">
                    <input type="submit" value="Buscar">
                </p>
            </form>
        </fieldset>-->
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Data de Publicação</th>
                        <th>Data de Inclusão</th>
                        <th>Tipo</th>
                        <th colspan="2">Ações<th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="publicacao" items="${publicacoes}" varStatus="status">
                        <tr>
                            <td>${publicacao.titulo}</td>
                            <td>${publicacao.dataPublicacaoString}</td>
                            <td>${publicacao.dataInclusaoString}</td>
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
                            <td><a href="alterarPublicacao?id=${publicacao.id}">Editar</a></td>
                            <td><a href="removerPublicacao?id=${publicacao.id}">Remover</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>


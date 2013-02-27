<%-- 
    Document   : listarProjeto
    Created on : Feb 3, 2013, 8:03:25 PM
    Author     : daivid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <c:choose>
        <c:when test="${empty projetosAtivos}">
            <h2 class="help-block">Não há projetos ativos.</h2>
        </c:when>
        <c:otherwise>
            <h2 class="help-block">Projetos Ativos:</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Qt. Participantes</th>
                        <th>Resumo</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="projeto" varStatus="count" begin="0" items="${projetosAtivos}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${projeto.nome}</td>
                            <td>${projeto.pessoas.size()}</td>
                            <td>${projeto.resumo}</td>
                            <td><a href="listarParticipantes?id=${projeto.id}">Listar Participantes</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${empty projetosConcluidos}">
            <h2 class="help-block">Não há projetos concluídos.</h2>
        </c:when>
        <c:otherwise>
            <h2 class="help-block">Projetos Concluídos:</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Qt. Participantes</th>
                        <th>Resumo</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="projeto" varStatus="count" begin="0" items="${projetosConcluidos}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${projeto.nome}</td>
                            <td>${projeto.pessoas.size()}</td>
                            <td>${projeto.resumo}</td>
                            <td><a href="listarParticipantes?id=${projeto.id}">Listar Participantes</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>


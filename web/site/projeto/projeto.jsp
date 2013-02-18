<%-- 
    Document   : projeto
    Created on : Jan 29, 2013, 9:46:02 PM
    Author     : daivid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarProjeto" />
    </c:when>
    <c:otherwise>
        <div>
            <a href="novoProjeto" class="btn btn-large">Novo Projeto</a>
        </div>
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Qt. Participantes</th>
                        <th>Resumo</th>
                        <th colspan="2">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="projeto" varStatus="count" begin="0" items="${projetos}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${projeto.nome}</td>
                            <td>${projeto.pessoas.size()}</td>
                            <td>${projeto.resumo}</td>
                            <td><a href="alterarProjeto?id=${projeto.id}">Alterar</a></td>
                            <td><a href="apagarProjeto?id=${projeto.id}">Apagar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:forEach var="projeto" begin="0" items="${projetos}">
                
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

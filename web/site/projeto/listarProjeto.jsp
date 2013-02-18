<%-- 
    Document   : listarProjeto
    Created on : Feb 3, 2013, 8:03:25 PM
    Author     : daivid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
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
            <c:forEach var="projeto" varStatus="count" begin="0" items="${projetos}">
                <tr>
                    <td>${count.index+1}</td>
                    <td>${projeto.nome}</td>
                    <td>${projeto.pessoas.size()}</td>
                    <td>${projeto.resumo}</td>
                    <td><a>Listar Participantes</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:forEach var="projeto" begin="0" items="${projetos}">

    </c:forEach>
</div>


<%-- 
    Document   : tutor
    Created on : 18/02/2013, 08:55:22
    Author     : Bruno Monteiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarTutor" />
    </c:when>
    <c:otherwise>
        <div>
            <a href="novoTutor" class="btn btn-large">Novo Tutor</a>
        </div>
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>CPF</th>
                        <th>Nome</th>
                        <th colspan="2">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tutor" varStatus="count" begin="0" items="${tutores}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${tutor.cpf}</td>
                            <td>${tutor.nome}</td>
                            <td><a href="editarTutor?cpf=${tutor.cpf}">Alterar</a></td>
                            <td><a href="excluirTutor?cpf=${tutor.cpf}">Apagar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:forEach var="tutores" begin="0" items="${tutores}">

            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
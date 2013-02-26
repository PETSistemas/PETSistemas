<%-- 
    Document   : colaborador
    Created on : 18/02/2013, 08:55:22
    Author     : Bruno Monteiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarColaborador" />
    </c:when>

    <c:otherwise>
        <div>
            <a href="novoColaborador" class="btn btn-large">Novo Colaborador</a>
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
                    <c:forEach var="colaborador" varStatus="count" begin="0" items="${colaboradores}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${colaborador.cpf}</td>
                            <td>${colaborador.nome}</td>
                            <td><a href="editarColaborador?cpf=${colaborador.cpf}">Alterar</a></td>
                            <td><a href="excluirColaborador?cpf=${colaborador.cpf}">Apagar</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

            <c:forEach var="colaboradores" begin="0" items="${colaboradores}">

            </c:forEach>
        </div>

    </c:otherwise>
</c:choose>
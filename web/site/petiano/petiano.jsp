<%-- 
    Document   : petiano
    Created on : 05/12/2012, 08:55:22
    Author     : Rebecca Alves
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarPetiano" />
    </c:when>
    <c:otherwise>
        <div>
            <a href="novoPetiano" class="btn btn-large">Novo Petiano</a>
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
                    <c:forEach var="petiano" varStatus="count" begin="0" items="${petianos}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${petiano.cpf}</td>
                            <td>${petiano.nome}</td>
                            <td><a href="editarPetiano?cpf=${petiano.cpf}">Alterar</a></td>
                            <td><a href="excluirPetiano?cpf=${petiano.cpf}">Apagar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:forEach var="petianos" begin="0" items="${petianos}">

            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
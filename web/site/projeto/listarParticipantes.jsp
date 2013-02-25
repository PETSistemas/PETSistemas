<%-- 
    Document   : listarParticipantes
    Created on : Feb 25, 2013, 1:44:30 PM
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
                <th>Tipo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="participante" varStatus="count" begin="0" items="${pessoas}">
                <tr>
                    <td>${count.index+1}</td>
                    <td>${participante.nome}</td>
                    <td>${participante.tipoPessoa}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
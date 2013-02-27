<%-- 
    Document   : listarAutores
    Created on : 27/02/2013, 16:36:57
    Author     : Thiago
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
            <c:forEach var="autor" varStatus="count" begin="0" items="${pessoas}">
                <tr>
                    <td>${count.index+1}</td>
                    <td>${autor.nome}</td>
                    <td>${autor.tipoPessoa}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="listarPublicacao">Voltar</a>
</div>

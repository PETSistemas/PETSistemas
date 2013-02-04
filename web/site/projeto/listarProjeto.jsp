<%-- 
    Document   : listarProjeto
    Created on : Feb 3, 2013, 8:03:25 PM
    Author     : daivid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:forEach var="projeto" begin="0" items="${projetos}">
    <div>
        <p>Nome: ${projeto.nome}</p>
        <p>Tipo: ${projeto.tipo}</p>
        <p>Resumo:${projeto.resumo}</p>
        <p>Data: ${projeto.dataInicio}</p>
        <ul>
            <c:forEach begin="0" var="pessoa" items="${projeto.pessoas}">
                <li>${pessoa.nome}, ${pessoa.class.canonicalName}</li>
                </c:forEach>
        </ul>
    </div>
</c:forEach>

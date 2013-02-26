<%-- 
    Document   : download
    Created on : 27/01/2013, 14:36:58
    Author     : Lillydi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarDownload" />
    </c:when>
    <c:otherwise>
        <div>
            <a href="novoDownload" class="btn btn-large">Novo Download</a>
        </div>
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Titulo</th>
                        <th>Anexo</th>
                        <th colspan="2">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="download" varStatus="count" begin="0" items="${downloads}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${download.titulo}</td>
                            <td>${download.nome}</td>
                            <td><a href="alterarDownload?titulo=${download.titulo}">Alterar</a></td>
                            <td><a href="excluirDownload?titulo=${petiano.titulo}">Apagar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:forEach var="petianos" begin="0" items="${downloads}">

            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

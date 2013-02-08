<%-- 
    Document   : publicacaoADM
    Created on : 07/02/2013, 19:32:42
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <fieldset>
        <legend>Publicações</legend>
        
        <form action="POST" method="${pageContext.request.contextPath}/novaPublicacao">
            <input id="addPublicacao" name="addPublicacao" value="Cadastrar Nova Publicação">
        </form>
            
        <br>
        
        <fieldset>
            <legend>Buscar</legend>
            <form action="" method="">
                <p>
                    Buscar: <input id="campo" name="campo" type="search" value="Pesquisar">
                    <input type="submit" value="Buscar">
                </p>
            </form>
        </fieldset>
        
        <br><br>
        
        <table>
            <tr>
                <th>Título</th>
                <th>Data de Publicação</th>
                <th>Data de Inclusão</th>
                <th>Tipo</th>
                <th colspan="3">Ações<th>
            </tr>
        <c:forEach var="publicacao" items="${publicacoes}" varStatus="status">
            <tr>
                <td>${publicacao.titulo}</td>
                <td>${publicacao.dataPublicacao}</td>
                <td>${publicacao.dataInclusao}</td>
                <td>
                    <c:choose>
                        <c:when test="${publicacao.tipo == 1}">
                            Artigo
                        </c:when>
                        <c:when test="${publicacao.tipo == 2}">
                            Relatório
                        </c:when>
                        <c:when test="${publicacao.tipo == 3}">
                            Técnico
                        </c:when>
                        <c:when test="${publicacao.tipo == 4}">
                            Tutorial
                        </c:when>
                        <c:when test="${publicacao.tipo == 5}">
                            Manual
                        </c:when>
                        <c:when test="${publicacao.tipo == 6}">
                            Outros
                        </c:when>
                    </c:choose>
                </td>
                <td><a href="${pageContext.request.contextPath}/publicacao">Visualizar</a></td>
                <td><a href="${pageContext.request.contextPath}/publicacao">Editar</a></td>
                <td><a href="${pageContext.request.contextPath}/publicacao">Remover</a></td>
            </tr>
        </c:forEach>
        </table>
    </fieldset>
    <p><a href="${pageContext.request.contextPath}/publicacao">Voltar</a></p>
</div>


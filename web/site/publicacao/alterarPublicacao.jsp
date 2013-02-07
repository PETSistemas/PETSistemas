<%-- 
    Document   : alterarPublicacao
    Created on : 06/02/2013, 21:58:11
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form method="POST" action="${pageContext.request.contextPath}/salvarPublicacao">
        <fieldset>
            <legend>Alteração de Publicação</legend>
            <p>Id: <input type="text" name="id" value="${publicacao.id}"></p>
            <p>Título: <input type="text" name="titulo" size="60" value="${publicacao.titulo}"></p>
            <p>Resumo: </p>
            <textarea name="resumo" rows="10" cols="50">${publicacao.resumo}</textarea>
            <p>Tipo de publicação: 
                <select name="tipo">
                    <c:choose>
                        <c:when test="${publicacao.tipo == 1}">
                            <option value=1 selected="selected">Artigo</option>
                            <option value=2>Relatório</option>
                            <option value=3>Técnico</option>
                            <option value=4>Tutorial</option>
                            <option value=5>Manual</option>
                            <option value=6>Outros</option>
                        </c:when>
                        <c:when test="${publicacao.tipo == 2}">
                            <option value=1>Artigo</option>
                            <option value=2 selected="selected">Relatório</option>
                            <option value=3>Técnico</option>
                            <option value=4>Tutorial</option>
                            <option value=5>Manual</option>
                            <option value=6>Outros</option>
                        </c:when>
                        <c:when test="${publicacao.tipo == 3}">
                            <option value=1>Artigo</option>
                            <option value=2>Relatório</option>
                            <option value=3 selected="selected">Técnico</option>
                            <option value=4>Tutorial</option>
                            <option value=5>Manual</option>
                            <option value=6>Outros</option>
                        </c:when>
                        <c:when test="${publicacao.tipo == 4}">
                            <option value=1>Artigo</option>
                            <option value=2>Relatório</option>
                            <option value=3>Técnico</option>
                            <option value=4 selected="selected">Tutorial</option>
                            <option value=5>Manual</option>
                            <option value=6>Outros</option>
                        </c:when>
                        <c:when test="${publicacao.tipo == 5}">
                            <option value=1>Artigo</option>
                            <option value=2>Relatório</option>
                            <option value=3>Técnico</option>
                            <option value=4>Tutorial</option>
                            <option value=5 selected="selected">Manual</option>
                            <option value=6>Outros</option>
                        </c:when>
                        <c:when test="${publicacao.tipo == 6}">
                            <option value=1>Artigo</option>
                            <option value=2>Relatório</option>
                            <option value=3>Técnico</option>
                            <option value=4>Tutorial</option>
                            <option value=5>Manual</option>
                            <option value=6 selected="selected">Outros</option>
                        </c:when>
                    </c:choose>
                </select>
            </p>
            <p>Data de Publicação <input type="text" name="dataPublicacao" size="10" value="${publicacao.dataPublicacao}"></p>
            <p>Data de Inclusão: <input type="text" name="dataInclusao" size="10" value="${publicacao.dataInclusao}"></p>
            <p>Anexo: <input type="file" name="anexo" size="25"></p>
            <p>Autor: 

            </p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
    <p><a href="${pageContext.request.contextPath}/publicacao">Voltar</a></p>
</div>

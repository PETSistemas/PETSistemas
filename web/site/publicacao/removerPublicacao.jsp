<%-- 
    Document   : removerPublicacao
    Created on : 10/02/2013, 21:10:23
    Author     : Thiago
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form class="form-horizontal" action="executarRemocaoPublicacao" method="post">
    <fieldset>
        <legend>Apagar Publicação</legend>

        <div class="control-group">
            <label class="control-label" for="id">Id: </label>
            <div class="controls">
                <input class="input-xlarge" type="text" id="id" name="id" disabled="disabled" value="${publicacao.id}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="titulo">Título da Publição: </label>
            <div class="controls">
                <input class="input-xlarge" type="text" id="titulo" name="titulo" disabled="disabled" value="${publicacao.titulo}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="resumo">Resumo:</label>
            <div class="controls">
                <textarea class="input-xlarge" id="resumo" name="resumo" maxlength="100" disabled="disabled">${publicacao.resumo}</textarea>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="tipo">Tipo de Projeto: </label>
            <div class="controls">
                <select class="input-xlarge" name="tipo" disabled="disabled">
                    <option value="1" <c:if test="${publicacao.tipo == 1}">selected="selected"</c:if>>Artigo</option>
                    <option value="2" <c:if test="${publicacao.tipo == 2}">selected="selected"</c:if>>Relatório</option>
                    <option value="3" <c:if test="${publicacao.tipo == 3}">selected="selected"</c:if>>Técnico</option>
                    <option value="4" <c:if test="${publicacao.tipo == 4}">selected="selected"</c:if>>Tutorial</option>
                    <option value="5" <c:if test="${publicacao.tipo == 5}">selected="selected"</c:if>>Manual</option>
                    <option value="6" <c:if test="${publicacao.tipo == 6}">selected="selected"</c:if>>Outros</option>
                </select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="dataPublicacao">Data de Publicação:</label>
            <div class="controls">
                <input class="input-xlarge date" type="text" id="dataPublicacao" name="dataPublicacao" disabled="disabled" value="${publicacao.dataPublicacaoString}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="dataInclusao">Data de Inclusão:</label>
            <div class="controls">
                <input class="input-xlarge date" type="text" id="dataInclusao" name="dataInclusao" disabled="disabled" value="${publicacao.dataInclusaoString}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="pessoas_selecionadas">Autor(es):</label>
            <div class="controls">
                <select class="input-xlarge required" id="pessoas_selecionadas" name="pessoas_selecionadas" multiple="multiple">
                    <c:forEach var="pessoa" begin="0" items="${pessoas_selecionadas}">
                        <option selected="selected" value="${pessoa.id}">${pessoa.nome}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <input class="btn btn-danger" type="submit" value="Apagar" id="salvar"/>
            </div>
        </div>

        <input type="hidden" id="id" name="id" value="${publicacao.id}"/>
    </fieldset>
</form>
<a href="publicacao">Voltar</a>

<%-- 
    Document   : novaPublicacao
    Created on : 29/01/2013, 22:11:32
    Author     : Thiago
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form class="form-horizontal" method="POST" action="salvarPublicacao">
    <fieldset>
        <legend>Cadastro de Publicação</legend>

        <span class="info">Campos Marcados com (*) são obrigatórios</span>

        <div class="control-group">
            <label for="titulo" class="control-label">*Título da Publição: </label>
            <div class="controls">
                <input class="input-xlarge required" type="text" id ="titulo" name="titulo">
            </div>
        </div>

        <div class="control-group">
            <label for="resumo" class="control-label">*Resumo: </label>
            <div class="controls">
                <textarea class="input-xlarge required" id ="resumo" name="resumo" maxlength="100"></textarea>
            </div>
        </div>

        <div class="control-group">
            <label for="tipo" class="control-label">*Tipo de publicação: </label>
            <div class="controls">
                <select class="input-xlarge required" id="tipo" name="tipo">
                    <option value="1">Artigo</option>
                    <option value="2">Relatório</option>
                    <option value="3">Técnico</option>
                    <option value="4">Tutorial</option>
                    <option value="5">Manual</option>
                    <option value="6">Outros</option>
                </select>
            </div>
        </div>

        <div class="control-group">
            <label for="dataPublicacao" class="control-label">Data de Publicação:</label>
            <div class="controls">
                <input class="input-xlarge date" type="text" id="dataPublicacao" name="dataPublicacao"/>
            </div>
        </div>

        <div class="control-group">
            <label for="dataInclusao" class="control-label">*Data de Inclusão:</label>
            <div class="controls">
                <input class="input-xlarge date required" type="text" id="dataInclusao" name="dataInclusao"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="lista_pessoas">Pessoas:</label>
            <div class="controls">
                <select class="input-xlarge" id="lista_pessoas" multiple="multiple">
                    <c:forEach var="pessoa" begin="0" items="${requestScope.pessoas}">
                        <option value="${pessoa.id}">${pessoa.nome}</option>
                    </c:forEach>
                </select>    
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <button class="btn span1" type="button" id="inserir">&downarrow;</button>
                <button class="btn span1" type="button" id="remover">&uparrow;</button> 
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="pessoas_selecionadas">*Autor(es):</label>
            <div class="controls">
                <select class="input-xlarge required" id="pessoas_selecionadas" name="pessoas_selecionadas" multiple="multiple">
                </select>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <input class="btn btn-primary" type="submit" value="Salvar" id="salvar"/>
            </div>
        </div>
    </fieldset>
</form>
<a href="publicacao">Voltar</a>

<%-- 
    Document   : alterarPublicacao
    Created on : 17/02/2013, 20:54:12
    Author     : Thiago
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="salvarAlteracaoPublicacao" method="post">
    <fieldset>
        <legend>Alterar Publicação</legend>
        
        <label for="id">Id: </label>
        <input type="text" id="id" name="id" value="${publicacao.id}" readonly="readonly"/><br>

        <label for="titulo">Título da Publição: </label>
        <input type="text" id="titulo" name="titulo" value="${publicacao.titulo}"/><br>

        <label for="resumo">Resumo:</label>
        <textarea id="resumo" name="resumo" maxlength="100">${publicacao.resumo}</textarea><br>
        
        <label for="tipo">Tipo de Projeto: </label>
        <select name="tipo">
            <option value="1" <c:if test="${publicacao.tipo == 1}">selected="selected"</c:if>>Artigo</option>
            <option value="2" <c:if test="${publicacao.tipo == 2}">selected="selected"</c:if>>Relatório</option>
            <option value="3" <c:if test="${publicacao.tipo == 3}">selected="selected"</c:if>>Técnico</option>
            <option value="4" <c:if test="${publicacao.tipo == 4}">selected="selected"</c:if>>Tutorial</option>
            <option value="5" <c:if test="${publicacao.tipo == 5}">selected="selected"</c:if>>Manual</option>
            <option value="6" <c:if test="${publicacao.tipo == 6}">selected="selected"</c:if>>Outros</option>
        </select><br>

        <label for="dataPublicacao">Data de Publicação:</label>
        <input class="data" type="text" id="dataPublicacao" name="dataPublicacao" value="${publicacao.dataPublicacao}"/><br>

        <label for="dataInclusao">Data de Inclusão:</label>
        <input class="data" type="text" id="dataInclusao" name="dataInclusao" value="${publicacao.dataInclusao}"/><br>
        
        <label for="anexo">Anexo:</label>
        <input type="file" id ="anexo" name="anexo" size="25"><br>
        
        <label>Autor:</label>
        <div class="lista_dupla">
            <div>
                <label for="lista_pessoas">Pessoas</label>
                <select class="lista_dupla_box" id="lista_pessoas" multiple="multiple">
                    <c:forEach var="pessoa" begin="0" items="${lista_pessoas}">
                        <option value="${pessoa.id}">${pessoa.nome}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="lista_dupla_buttons">
                <button type="button" id="inserir">&rightarrow;</button>
                <button type="button" id="remover">&leftarrow;</button>
            </div>

            <div>
                <label for="pessoas_selecionadas">Pessoas Selecionadas</label>
                <select  class="lista_dupla_box" id="pessoas_selecionadas" name="pessoas_selecionadas" multiple="multiple">
                    <c:forEach var="pessoa" begin="0" items="${pessoas_selecionadas}">
                        <option selected="selected" value="${pessoa.id}">${pessoa.nome}</option>
                    </c:forEach>

                </select>
            </div>
        </div><br>
        
        <input type="hidden" name="id" value="${publicacao.id}"/>
        <input type="submit" value="Salvar" id="salvar" onsubmit="selecionar()"/>
    </fieldset>
</form>


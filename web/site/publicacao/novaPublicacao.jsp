<%-- 
    Document   : novaPublicacao
    Created on : 29/01/2013, 22:11:32
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form method="POST" action="${pageContext.request.contextPath}/salvarPublicacao">
        <fieldset>
            <legend>Cadastro de Publicação</legend>
            <p>Título: <input type="text" name="titulo" size="60"></p>
            <p>Resumo: </p>
            <textarea name="resumo" rows="10" cols="50"></textarea>
            <p>Tipo de publicação: <select name="tipo">
                    <option value=1>Artigo</option>
                    <option value=2>Relatório</option>
                    <option value=3>Técnico</option>
                    <option value=4>Tutorial</option>
                    <option value=5>Manual</option>
                    <option value=6>Outros</option>
                </select>
            </p>
            <p>Data de Publicação <input type="text" name="dataPublicacao" size="10"></p>
            <p>Data de Inclusão: <input type="text" name="dataInclusao" size="10"></p>
            <p>Anexo: <input type="file" name="anexo" size="25"></p>
            <p>Autor: 
            <div class="lista_dupla">
                <div>
                    <label for="lista_pessoas">Pessoas</label>
                    <select class="lista_dupla_box" id="lista_pessoas" multiple="multiple">
                        <c:forEach var="pessoa" begin="0" items="${requestScope.pessoas}">
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
                    <select class="lista_dupla_box" id="pessoas_selecionadas" name="pessoas_selecionadas" multiple="multiple">

                    </select>
                </div>
            </div>
            </p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
    <p><a href="${pageContext.request.contextPath}/publicacao">Voltar</a></p>
</div>

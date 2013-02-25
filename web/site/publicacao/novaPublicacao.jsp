<%-- 
    Document   : novaPublicacao
    Created on : 29/01/2013, 22:11:32
    Author     : Thiago
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form method="POST" action="${pageContext.request.contextPath}/salvarPublicacao">
        <fieldset>
            <legend>Cadastro de Publicação</legend>

            <label for="titulo">Título da Publição: </label>
            <input type="text" id ="titulo" name="titulo" size="60"><br>

            <label for="resumo">Resumo: </label>
            <textarea id ="resumo" name="resumo" maxlength="100"></textarea><br>

            <label for="tipo"> Tipo de publicação: </label>
            <select id="tipo" name="tipo">
                <option value="1">Artigo</option>
                <option value="2">Relatório</option>
                <option value="3">Técnico</option>
                <option value="4">Tutorial</option>
                <option value="5">Manual</option>
                <option value="6">Outros</option>
            </select><br>

            <label for="dataPublicacao">Data de Publicação:</label>
            <input class="data" type="text" id="dataPublicacao" name="dataPublicacao"/><br>

            <label for="dataInclusao">Data de Inclusão:</label>
            <input class="data" type="text" id="dataInclusao" name="dataInclusao"/><br>

            <label for="anexo">Anexo: </label>
            <input type="file" id="anexo" name="anexo" size="25"><br>

            <label>Autor: </label>
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
            </div><br>

            <input type="submit" value="Salvar">
            <input type="reset" value="Limpar">
        </fieldset>
    </form>
    <p><a href="${pageContext.request.contextPath}/publicacao">Voltar</a></p>
</div>

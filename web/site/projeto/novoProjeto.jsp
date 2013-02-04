<%-- 
    Document   : novoProjeto
    Created on : Jan 29, 2013, 11:24:48 PM
    Author     : daivid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="salvarProjeto" method="post">
    <fieldset class="box">
        <legend>Criar Projeto</legend>

        <label for="nome">Nome do Projeto:</label><br>
        <input type="text" id="nome" name="nome"/><br>

        <label for="tipo">Tipo de Projeto:</label><br>
        <input type="checkbox" name="tipo" id="tipo" value="1">Ensino |
        <input type="checkbox" name="tipo" id="tipo" value="2">Pesquisa |
        <input type="checkbox" name="tipo" id="tipo" value="4">Extensão <br>

        <label for="resumo">Resumo do Projeto:</label><br>
        <textarea id="resumo" name="resumo" maxlength="100">Resumo do Projeto
        </textarea><br>

        <label for="data_inicio">Data de Início:</label><br>
        <input type="text" id="data_inicio" name="data_inicio" /><br><br>
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
        <br>
        <input type="submit" value="Salvar"/>
    </fieldset>
</form>


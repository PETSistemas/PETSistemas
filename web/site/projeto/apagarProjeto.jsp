<%-- 
    Document   : apagarProjeto
    Created on : Feb 7, 2013, 10:28:13 AM
    Author     : daivid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${projeto != null}">
    <form action="efetivarRemocaoProjeto" method="post">
        <fieldset class="box">
            <legend>Apagar Projeto</legend>

            <label for="nome">Nome do Projeto:</label><br>
            <input type="text" id="nome"disabled="disabled" value="${projeto.nome}"/><br>

            <label for="tipo">Tipo de Projeto:</label><br>
            <input type="checkbox" id="tipo" disabled="disabled" value="1" <c:if test="${ensino == true}">checked="checked"</c:if>>Ensino |
            <input type="checkbox" id="tipo" disabled="disabled" value="2" <c:if test="${pesquisa == true}">checked="checked"</c:if>>Pesquisa |
            <input type="checkbox" id="tipo" disabled="disabled" value="4" <c:if test="${extensao == true}">checked="checked"</c:if>>Extensão <br>
            <label for="resumo">Resumo do Projeto:</label><br>
            <textarea id="resumo" maxlength="100" disabled="disabled">${projeto.resumo}</textarea><br>

            <label for="data_inicio">Data de Início:</label><br>
            <input class="data" type="text" id="data_inicio" disabled="disabled" value="${projeto.dataInicio}"/><br>

            <label for="data_termino">Data de Término:</label><br>
            <input class="data" type="text" id="data_termino" disabled="disabled"/><br><br>   
            <br>
            <div class="lista_dupla">
                <div>
                    <label for="pessoas_selecionadas">Pessoas Selecionadas</label>
                    <select  class="lista_dupla_box" disabled="disabled" name="pessoas_selecionadas" multiple="multiple">
                        <c:forEach var="pessoa" begin="0" items="${pessoas_selecionadas}">
                            <option value="${pessoa.id}">${pessoa.nome}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
            <br>
            <input type="hidden" name="id" value="${projeto.id}"/>
            <input type="submit" value="Apagar"/>
        </fieldset>
    </form>
</c:if>


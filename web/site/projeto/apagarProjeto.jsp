<%-- 
    Document   : apagarProjeto
    Created on : Feb 7, 2013, 10:28:13 AM
    Author     : daivid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${projeto != null}">

    <form class="form-horizontal" action="efetivarRemocaoProjeto" method="post">
        <fieldset>
            <legend>Apagar Projeto</legend>

            <div class="control-group">
                <label for="nome" class="control-label">Nome do Projeto:</label>
                <div class="controls">
                    <input class="input-xlarge required" disabled="disabled" type="text" id="nome" name="nome" value="${projeto.nome}"/>
                </div>
            </div>


            <div class="control-group">
                <label for="tipo" class="control-label">Tipo do Projeto:</label>
                <div class="controls">
                    <label class="checkbox">
                        <input type="checkbox" name="tipo" disabled="disabled" id="tipo" value="1" <c:if test="${ensino == true}">checked="checked"</c:if>>Ensino
                    </label>

                    <label class="checkbox">
                        <input type="checkbox" name="tipo" disabled="disabled" id="tipo" value="2" <c:if test="${pesquisa == true}">checked="checked"</c:if>>Pesquisa
                    </label>

                    <label class="checkbox">
                        <input type="checkbox" name="tipo" disabled="disabled" id="tipo" value="4" <c:if test="${extensao == true}">checked="checked"</c:if>>Extensão
                    </label>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="resumo">Resumo do Projeto:</label>
                <div class="controls">
                    <textarea class="input-xlarge required" disabled="disabled" id="resumo" name="resumo" rows="3" placeholder="Resumo do Projeto">${projeto.resumo}</textarea>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="data_inicio">Data de Início:</label>
                <div class="controls">
                    <input type="text" class="date required input-xlarge" disabled="disabled" id="data_inicio" name="data_inicio" value="${projeto.dataInicioString}"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="data_termino">Data de Término:</label>
                <div class="controls">
                    <input type="text" class="date input-xlarge" disabled="disabled" id="data_termino" name="data_termino" value="${projeto.dataTerminoString}"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="pessoas_selecionadas">Pessoas Selecionadas:</label>
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
        </fieldset>
        <input type="hidden" value="${projeto.id}" name="id" id="id"/>
    </form>

</c:if>


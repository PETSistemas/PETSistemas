<%-- 
    Document   : novoProjeto
    Created on : Jan 29, 2013, 11:24:48 PM
    Author     : daivid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${projeto != null}">

    <form class="form-horizontal" action="salvarAlteracaoProjeto" method="post">
        <fieldset>
            <legend>Alterar Projeto</legend>


            <span class="info">Campos Marcados com (*) são obrigatórios</span>

            <div class="control-group">
                <label for="nome" class="control-label">*Nome do Projeto:</label>
                <div class="controls">
                    <input class="input-xlarge required" type="text" id="nome" name="nome" value="${projeto.nome}"/>
                </div>
            </div>

            <div class="control-group">
                <label for="tipo" class="control-label">Tipo do Projeto:</label>
                <div class="controls">
                    <label class="checkbox">
                        <input type="checkbox" name="tipo" id="tipo" value="1" <c:if test="${ensino == true}">checked="checked"</c:if>/>Ensino
                        </label>

                        <label class="checkbox">
                            <input type="checkbox" name="tipo" id="tipo" value="2" <c:if test="${pesquisa == true}">checked="checked"</c:if>/>Pesquisa
                        </label>

                        <label class="checkbox">
                            <input type="checkbox" name="tipo" id="tipo" value="4" <c:if test="${extensao == true}">checked="checked"</c:if>/>Extensão
                        </label>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="resumo">*Resumo do Projeto:</label>
                    <div class="controls">
                        <textarea class="input-xlarge required" id="resumo" name="resumo" rows="3" placeholder="Resumo do Projeto">${projeto.resumo}</textarea>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="data_inicio">*Data de Início:</label>
                    <div class="controls">
                        <input type="text" class="date required input-xlarge" id="data_inicio" name="data_inicio" value="${projeto.dataInicioString}"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="data_termino">Data de Término:</label>
                <div class="controls">
                    <input type="text" class="date input-xlarge" id="data_termino" name="data_termino" value="${projeto.dataTerminoString}"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="lista_pessoas">Pessoas:</label>
                <div class="controls">
                    <select class="input-xlarge" id="lista_pessoas" multiple="multiple">
                        <c:forEach var="pessoa" begin="0" items="${requestScope.lista_pessoas}">
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
                <label class="control-label" for="pessoas_selecionadas">*Pessoas Selecionadas:</label>
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
                    <input class="btn btn-primary" type="submit" value="Salvar" id="salvar"/>
                </div>
            </div>

            <input type="hidden" id="id" name="id" value="${projeto.id}"/>
        </fieldset>
    </form>

</c:if>


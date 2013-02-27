<%-- 
    Document   : editarColaborador
    Created on : 15/02/2013, 09:11:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${colaboradorBusca != null}">
    <c:choose>
        <c:when test="${empty login}">
            <c:redirect url="listarColaborador" />
        </c:when>

        <c:otherwise>
            <form method="POST" action="atualizarColaborador" class="form-horizontal">
                <fieldset class="box">
                    <legend>Cadastro de Colaborador</legend>
                    <span class="info">Campos Marcados com (*) são obrigatórios</span><br><br>

                    <input type="hidden" name="id" size="60" value="${colaboradorBusca.id}">

                    <c:if test="${mensagemErroColaborador != null}">
                        <span class="mensagemErro">${mensagemErroColaborador}<br><br></span>
                        </c:if>

                    <div class="control-group">
                        <label for="nome" class="control-label">*Nome do Colaborador :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="nome" name="nome" size="60" value="${colaboradorBusca.nome}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="dataNascimento">*Data de Nascimento :</label>
                        <div class="controls">
                            <input type="text" class="date required input-xlarge" id="dataNascimento" name="dataNascimento"size="10" value="${colaboradorBusca.dataNascimentoFormatada}" />
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="email" class="control-label">*Email :</label>
                        <div class="controls">
                            <input class="input-xlarge email required" type="text" id="email" name="email" size="40" value="${colaboradorBusca.email}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="lattes" class="control-label">*Link do Lattes :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="lattes" name="lattes" size="40" value="${colaboradorBusca.linkLattes}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="situacao">*Situação :</label>
                        <div class="controls">
                            <select class="input-xlarge required" id="situacao" name="situacao">
                                <c:choose>
                                    <c:when test="${colaboradorBusca.situacao==1}">
                                        <option value=1 selected >Ativo</option>
                                        <option value=2>Desativo</option>
                                    </c:when>
                                    <c:when test="${colaboradorBusca.situacao==2}">
                                        <option value=1  >Ativo</option>
                                        <option value=2 selected>Desativo</option>
                                    </c:when>
                                </c:choose>
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
        </c:otherwise>
    </c:choose> 
</c:if>
<p><a href="colaborador">Voltar</a></p>






<%-- 
    Document   : editarTutor
    Created on : 15/02/2013, 09:11:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${tutorBusca != null}">
    <c:choose>
        <c:when test="${empty login}">
            <c:redirect url="listarTutor" />
        </c:when>

        <c:otherwise>
            <form method="POST" action="atualizarTutor" class="form-horizontal">
                <fieldset class="box">
                    <legend>Cadastro de Tutor</legend>
                    <span class="info">Campos Marcados com (*) são obrigatórios</span><br><br>

                    <input type="hidden" name="id" size="60" value="${tutorBusca.id}">

                    <c:if test="${mensagemErroTutor != null}">
                        <span class="mensagemErro">${mensagemErroTutor}<br><br></span>
                        </c:if>

                    <div class="control-group">
                        <label for="nome" class="control-label">*Nome do Tutor :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="nome" name="nome" size="60" value="${tutorBusca.nome}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="dataNascimento">*Data de Nascimento :</label>
                        <div class="controls">
                            <input type="text" class="date required input-xlarge" id="dataNascimento" name="dataNascimento"size="10" value="${tutorBusca.dataNascimentoFormatada}" />
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="rg" class="control-label">*RG :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="rg" name="rg" size="30" value="${tutorBusca.rg}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="email" class="control-label">*Email :</label>
                        <div class="controls">
                            <input class="input-xlarge email required" type="text" id="email" name="email" size="40" value="${tutorBusca.email}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="lattes" class="control-label">*Link do Lattes :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="lattes" name="lattes" size="40" value="${tutorBusca.linkLattes}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="dataEntrada" class="control-label">*Data de Entrada :</label>
                        <div class="controls">
                            <input class="date required input-xlarge" type="text" id="dataEntrada" name="dataEntrada"  size="10" value="${tutorBusca.dataEntradaFormatada}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="dataSaida" class="control-label">Data de Saída :</label>
                        <div class="controls">
                            <input  class="date" type="text" id="dataSaida" name="dataSaida" size="10" value="${tutorBusca.dataSaidaFormatada}"><//>
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
<p><a href="tutor">Voltar</a></p>






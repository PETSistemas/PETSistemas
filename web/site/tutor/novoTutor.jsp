<%-- 
    Document   : novoTutor
    Created on : 29/01/2013, 22:42:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarProjeto" />
    </c:when>
    <c:otherwise>
        <form method="POST" action="salvarTutor" class="form-horizontal">
            <fieldset class="box">
                <legend>Cadastro de Tutor</legend>
                <span class="info">Campos Marcados com (*) são obrigatórios</span><br><br>

                <c:if test="${mensagemErroTutor != null}">
                    <span class="mensagemErro">${mensagemErroTutor}<br><br></span>
                    </c:if>

                <div class="control-group">
                    <label for="nome" class="control-label">*Nome do Tutor :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="nome" name="nome"/>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="dataNascimento">*Data de Nascimento :</label>
                    <div class="controls">
                        <input type="text" class="date required input-xlarge" id="dataNascimento" name="dataNascimento" />
                    </div>
                </div>

                <div class="control-group">
                    <label for="rg" class="control-label">*RG :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="rg" name="rg"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="cpf" class="control-label">*CPF :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="cpf" name="cpf"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="senha" class="control-label">*Senha de Acesso :</label>
                    <div class="controls">
                        <input type="password" class="input-xlarge required" id="senha" name="senha"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="email" class="control-label">*Email :</label>
                    <div class="controls">
                        <input class="input-xlarge email required" type="text" id="email" name="email"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="lattes" class="control-label">*Link do Lattes :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="lattes" name="lattes"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="dataEntrada" class="control-label">*Data de Entrada :</label>
                    <div class="controls">
                        <input class="date required input-xlarge" type="text" id="dataEntrada" name="dataEntrada"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="dataSaida" class="control-label">Data de Saída :</label>
                    <div class="controls">
                        <input class="date" type="text" id="dataSaida" name="dataSaida"/>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <input class="btn btn-primary" type="submit" value="Salvar" id="salvar"/>
                    </div>
                </div>

            </fieldset>
            <div><a href="tutor">Voltar</a></div>
        </form>
    </c:otherwise>
</c:choose>
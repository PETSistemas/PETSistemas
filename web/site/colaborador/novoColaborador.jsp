<%-- 
    Document   : novoColaborador
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
        <form method="POST" action="salvarColaborador" class="form-horizontal">
            <fieldset class="box">
                <legend>Cadastro de Colaborador</legend>
                <span class="info">Campos Marcados com (*) são obrigatórios</span><br><br>

                <c:if test="${mensagemErroColaborador != null}">
                    <span class="mensagemErro">${mensagemErroColaborador}<br><br></span>
                    </c:if>

                <div class="control-group">
                    <label for="nome" class="control-label">*Nome do Colaborador :</label>
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
                    <label for="cpf" class="control-label">*CPF :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="cpf" name="cpf"/>
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
                    <label class="control-label" for="situacao">*Situação :</label>
                    <div class="controls">
                        <select class="input-xlarge required" id="situacao" name="situacao">
                            <option value=1>Ativo</option>
                            <option value=2>Desativo</option>
                        </select>
                    </div>
                </div>


                <div class="control-group">
                    <div class="controls">
                        <input class="btn btn-primary" type="submit" value="Salvar" id="salvar"/>
                    </div>
                </div>

            </fieldset>
            <div><a href="colaborador">Voltar</a></div>
        </form>
    </c:otherwise>
</c:choose>



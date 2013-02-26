<%-- 
    Document   : novoPetiano
    Created on : 05/12/2012, 09:11:39
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${empty login}">
        <c:redirect url="listarProjeto" />
    </c:when>
    <c:otherwise>
        <form method="POST" action="salvarPetiano" class="form-horizontal">
            <fieldset class="box">
                <legend>Cadastro de Petiano</legend>
                <span class="info">Campos Marcados com (*) são obrigatórios</span><br><br>

                <c:if test="${mensagemErroPetiano != null}">
                    <span class="mensagemErro">${mensagemErroPetiano}<br><br></span>
                    </c:if>

                <div class="control-group">
                    <label for="nome" class="control-label">*Nome do Petiano :</label>
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
                    <label for="pai" class="control-label">*Nome do Pai :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="pai" name="pai"/>
                    </div>
                </div>

                <div class="control-group">
                    <label for="mae" class="control-label">*Nome da Mãe :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="mae" name="mae"/>
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
                    <label class="control-label" for="curso">*Curso :</label>
                    <div class="controls">
                        <select class="input-xlarge required" id="curso" name="curso">
                            <option value=1>Análise de Sistemas</option>
                            <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                            <option value=3>Tecnologia em Redes de Computadores</option>
                        </select>
                    </div>
                </div>

                <div class="control-group">
                    <label for="endereco" class="control-label">*Endereço :</label>
                    <div class="controls">
                        <textarea class="input-xlarge required" id="endereco" name="endereco" rows="3" placeholder="Endereço do Petiano"></textarea>
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
            <div><a href="petiano">Voltar</a></div>
        </form>
    </c:otherwise>
</c:choose>
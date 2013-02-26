<%-- 
    Document   : editarPetiano
    Created on : 05/12/2012, 09:11:39
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${petianoBusca != null}">
    <c:choose>
        <c:when test="${empty login}">
            <c:redirect url="listarPetiano" />
        </c:when>

        <c:otherwise>
            <form method="POST" action="atualizarPetiano" class="form-horizontal">
                <fieldset class="box">
                    <legend>Cadastro de Petiano</legend>
                    <span class="info">Campos Marcados com (*) são obrigatórios</span><br><br>

                    <input type="hidden" name="id" size="60" value="${petianoBusca.id}">

                    <c:if test="${mensagemErroPetiano != null}">
                        <span class="mensagemErro">${mensagemErroPetiano}<br><br></span>
                        </c:if>

                    <div class="control-group">
                        <label for="nome" class="control-label">*Nome do Petiano :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="nome" name="nome" size="60" value="${petianoBusca.nome}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="dataNascimento">*Data de Nascimento :</label>
                        <div class="controls">
                            <input type="text" class="date required input-xlarge" id="dataNascimento" name="dataNascimento"size="10" value="${petianoBusca.dataNascimentoFormatada}" />
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="pai" class="control-label">*Nome do Pai :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="pai" name="pai" size="60" value="${petianoBusca.nomePai}"></ />
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="mae" class="control-label">*Nome da Mãe :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="mae" name="mae" size="60" value="${petianoBusca.nomeMae}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="rg" class="control-label">*RG :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="rg" name="rg" size="30" value="${petianoBusca.rg}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="email" class="control-label">*Email :</label>
                        <div class="controls">
                            <input class="input-xlarge email required" type="text" id="email" name="email" size="40" value="${petianoBusca.email}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="lattes" class="control-label">*Link do Lattes :</label>
                        <div class="controls">
                            <input class="input-xlarge required" type="text" id="lattes" name="lattes" size="40" value="${petianoBusca.linkLattes}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="curso">*Curso :</label>
                        <div class="controls">
                            <select class="input-xlarge required" id="curso" name="curso">
                                <c:choose>
                                    <c:when test="${petianoBusca.curso==1}">
                                        <option value=1 selected >Análise de Sistemas</option>
                                        <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                                        <option value=3>Tecnologia em Redes de Computadores</option>
                                    </c:when>
                                    <c:when test="${petianoBusca.curso==2}">
                                        <option value=1  >Análise de Sistemas</option>
                                        <option value=2 selected>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                                        <option value=3>Tecnologia em Redes de Computadores</option>

                                    </c:when>
                                    <c:when test="${petianoBusca.curso==3}">
                                        <option value=1  >Análise de Sistemas</option>
                                        <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                                        <option value=3 selected>Tecnologia em Redes de Computadores</option>
                                    </c:when>
                                </c:choose>
                            </select>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="endereco" class="control-label">*Endereço :</label>
                        <div class="controls">
                            <textarea class="input-xlarge required" id="endereco" name="endereco" rows="3" placeholder="Endereço do Petiano">${petianoBusca.endereco}</textarea>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="dataEntrada" class="control-label">*Data de Entrada :</label>
                        <div class="controls">
                            <input class="date required input-xlarge" type="text" id="dataEntrada" name="dataEntrada"  size="10" value="${petianoBusca.dataEntradaFormatada}"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="dataSaida" class="control-label">Data de Saída :</label>
                        <div class="controls">
                            <input  class="date" type="text" id="dataSaida" name="dataSaida" size="10" value="${petianoBusca.dataSaidaFormatada}"><//>
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
<p><a href="petiano">Voltar</a></p>

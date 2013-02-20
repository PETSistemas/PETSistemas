<%-- 
    Document   : editarPetiano
    Created on : 05/12/2012, 09:11:39
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="removerPetiano">
        <fieldset>
            <legend>Exclusão do Petiano</legend>
            <input type="hidden" name="id" size="60" value="${petianoBusca.id}" >
            <p>Nome: <input type="text" name="nome" size="60" disabled="disabled" value="${petianoBusca.nome}"></p>
            <p>Data de Nascimento: <input type="text" name="dataNascimento" size="10" disabled="disabled" value="${petianoBusca.dataNascimentoFormatada}"></p>
            <p>E-mail: <input type="text" name="email" size="40" disabled="disabled" value="${petianoBusca.email}"></p>
            <p>Link Curriculum Lattes: <input type="text" name="lattes" size="40" disabled="disabled" value="${petianoBusca.linkLattes}"></p>
            <p>Curso: <select name="curso">
                    <c:choose>
                        <c:when test="${petianoBusca.curso==1}">
                            <option value=1 selected  disabled="disabled" >Análise de Sistemas</option>
                            <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                            <option value=3>Tecnologia em Redes de Computadores</option>
                        </c:when>
                        <c:when test="${petianoBusca.curso==2}">
                            <option value=1  >Análise de Sistemas</option>
                            <option value=2 selected disabled="disabled" >Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                            <option value=3>Tecnologia em Redes de Computadores</option>

                        </c:when>
                        <c:when test="${petianoBusca.curso==3}">
                            <option value=1  >Análise de Sistemas</option>
                            <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                            <option value=3 selected disabled="disabled">Tecnologia em Redes de Computadores</option>
                        </c:when>
                    </c:choose>
                </select></p>
            <p>Nome do Pai: <input type="text" name="pai" size="60" disabled="disabled" value="${petianoBusca.nomePai}"></p>
            <p>Nome da Mãe: <input type="text" name="mae" size="60" disabled="disabled" value="${petianoBusca.nomeMae}"></p>
            <p>RG: <input type="text" name="rg" size="30" disabled="disabled" value="${petianoBusca.rg}"></p>
            <p>Endereço:</p>
            <textarea name="endereco" rows="10" disabled="disabled" cols="50" >${petianoBusca.endereco}</textarea>
            <p>Data de Entrada: <input type="text" name="dataEntrada" size="10" disabled="disabled" value="${petianoBusca.dataEntradaFormatada}"></p>
            <p>Data de Saida <input type="text" name="dataSaida" size="10" disabled="disabled" value="${petianoBusca.dataSaidaFormatada}"></p>
            <p><input type="submit" value="Excluir"></p>
        </fieldset>
    </form>
</div>
<p><a href="petiano">Voltar</a></p>

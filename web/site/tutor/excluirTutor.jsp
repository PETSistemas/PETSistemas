<%-- 
    Document   : excluirTutor
    Created on : 18/02/2013, 09:11:39
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
            <form method="POST" action="removerTutor">
                <fieldset>
                    <legend>Exclusão do Tutor</legend>

                    <input type="hidden" name="id" value="${tutorBusca.id}" />

                    <p>Nome: <input type="text" name="nome" size="60" disabled="disabled" value="${tutorBusca.nome}"></p>

                    <p>Data de Nascimento: <input type="text" name="dataNascimento" size="10" disabled="disabled" value="${tutorBusca.dataNascimentoFormatada}"></p>

                    <p>E-mail: <input type="text" name="email" size="40" disabled="disabled" value="${tutorBusca.email}"></p>

                    <p>Link Curriculum Lattes: <input type="text" name="lattes" size="40" disabled="disabled" value="${tutorBusca.linkLattes}"></p>

                    <p>RG: <input type="text" name="rg" size="30" disabled="disabled" value="${tutorBusca.rg}"></p>

                    <p>Data de Entrada: <input type="text" name="dataEntrada" size="10" disabled="disabled" value="${tutorBusca.dataEntradaFormatada}"></p>

                    <p>Data de Saida <input type="text" name="dataSaida" size="10" disabled="disabled" value="${tutorBusca.dataSaidaFormatada}"></p>
                    <input class="btn btn-primary" type="submit" value="Excluir" id="salvar"/>

                </fieldset>
            </form>
        </c:otherwise>
    </c:choose>
    <p><a href="tutor">Voltar</a></p>
</c:if>

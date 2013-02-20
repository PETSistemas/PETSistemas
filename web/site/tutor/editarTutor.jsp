<%-- 
    Document   : editarTutor
    Created on : 15/02/2013, 09:11:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/atualizarTutor">
        <fieldset>
            <legend>Alteração do Tutor</legend>
            <input type="text" name="id" size="60" value="${tutorBusca.id}" hidden="hidden">
            <p>Nome: <input type="text" name="nome" size="60" value="${tutorBusca.nome}"></p>
            <p>Data de Nascimento: <input type="text" name="dataNascimento" size="10" value="${tutorBusca.dataNascimentoFormatada}"></p>
            <p>E-mail: <input type="text" name="email" size="40" value="${tutorBusca.email}"></p>
            <p>Link Curriculum Lattes: <input type="text" name="lattes" size="40" value="${tutorBusca.linkLattes}"></p>
            <p>RG: <input type="text" name="rg" size="30" value="${petianoBusca.rg}"></p>
            <p>Data de Entrada: <input type="text" name="dataEntrada" size="10" value="${petianoBusca.dataEntradaFormatada}"></p>
            <p>Data de Saida <input type="text" name="dataSaida" size="10" value="${petianoBusca.dataSaidaFormatada}"></p>
            <p>Senha: <input type="text" name="senha" size="10" value="${tutorSenha.email}"></p>
            <p><input type="submit" value="Atualizar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
</div>
<p><a href="${pageContext.request.contextPath}/tutorADM">Voltar</a></p>

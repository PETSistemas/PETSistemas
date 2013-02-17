<%-- 
    Document   : novoTutor
    Created on : 29/01/2013, 22:42:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/salvarTutor">
        <fieldset>
            <legend>Cadastro de Tutor</legend>
            <p>Nome: <input type="text" name="nome" size="60"></p>
            <p>Data de Nascimento: <input type="text" name="dataNascimento" size="10"></p>
            <p>E-mail: <input type="text" name="email" size="40"></p>
            <p>Link Curriculum Lattes: <input type="text" name="lattes" size="40"></p>              
            <p>RG: <input type="text" name="rg" size="30"></p>
            <p>CPF: <input type="text" name="cpf" size="14"></p>
            <p>Data de Entrada: <input type="text" name="dataEntrada" size="10"></p>
            <p>Data de Saida <input type="text" name="dataSaida" size="10"></p>
            <p>Senha <input type="text" name="senha" size="10"></p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
</div>
<p><a href="${pageContext.request.contextPath}/tutor">Voltar</a></p>

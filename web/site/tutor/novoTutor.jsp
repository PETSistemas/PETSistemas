<%-- 
    Document   : novoTutor
    Created on : 29/01/2013, 22:42:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="POST" action="${pageContext.request.contextPath}/salvarTutor">
    <fieldset class="box">
        <legend>Cadastro de Tutor</legend>

        <label for="nome">Nome do Tutor:</label><br>
        <input type="text" name="nome" id="nome"><br>

        <label for="data_inicio">Data de Nascimento:</label><br>
        <input type="text" class="data" id="dataNascimento" name="dataNascimento" /><br><br>

        <label for="nome">RG:</label><br>
        <input type="text" id="rg" name="rg"/><br>

        <label for="nome">CPF:</label><br>
        <input type="text" id="cpf" name="cpf"/><br>

        <label for="nome">Senha de Acesso:</label><br>
        <input type="text" id="senha" name="senha"/><br>

        <label for="nome">E-mail:</label><br>
        <input type="text" id="email" name="email"/><br>

        <label for="nome">Link do Curriculum Lattes:</label><br>
        <input type="text" id="lattes" name="lattes"/><br>

        <label for="data">Data de Entrada no PET:</label><br>
        <input type="text" class="data" id="dataEntrada" name="dataEntrada" /><br><br>

        <label for="data">Data de Saída do PET:</label><br>
        <input type="text" class="data" id="dataSaida" name="dataSaida" /><br><br>

        <input type="submit" value="Salvar" id="salvar"/>
    </fieldset>
</form>
<div><a href="${pageContext.request.contextPath}/tutorADM">Voltar</a></div>




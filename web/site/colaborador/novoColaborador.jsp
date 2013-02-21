<%-- 
    Document   : novoColaborador
    Created on : 29/01/2013, 22:42:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="POST" action="${pageContext.request.contextPath}/salvarColaborador">
    <fieldset class="box">
        <legend>Cadastro de Colaborador</legend>

        <label for="nome">Nome do Colaborador:</label><br>
        <input type="text" name="nome" id="nome"><br>

        <label for="data_inicio">Data de Nascimento:</label><br>
        <input type="text" class="data" id="dataNascimento" name="dataNascimento" /><br><br>

        <label for="nome">RG:</label><br>
        <input type="text" id="rg" name="rg"/><br>

        <label for="nome">CPF:</label><br>
        <input type="text" id="cpf" name="cpf"/><br>

        <label for="nome">E-mail:</label><br>
        <input type="text" id="email" name="email"/><br>

        <label for="nome">Link do Curriculum Lattes:</label><br>
        <input type="text" id="lattes" name="lattes"/><br>

        <input type="submit" value="Salvar" id="salvar"/>
        
                <label for="tipo">Situação:</label><br>
        <select name="curso">
            <option value=""></option>
            <option value=1>Ativo</option>
            <option value=2>Desativo</option>
        </select><br><br>
    </fieldset>
</form>
<div><a href="${pageContext.request.contextPath}/colaborador">Voltar</a></div>




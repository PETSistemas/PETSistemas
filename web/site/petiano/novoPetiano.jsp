<%-- 
    Document   : novoPetiano
    Created on : 05/12/2012, 09:11:39
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="POST" action="${pageContext.request.contextPath}/salvarPetiano">
    <fieldset class="box">
        <legend>Cadastro de Petiano</legend>

        <label for="nome">Nome do Petiano:</label><br>
        <input type="text" id="nome" name="nome"/><br>

        <label for="data_inicio">Data de Nascimento:</label><br>
        <input type="text" class="data" id="dataNascimento" name="dataNascimento" /><br><br>
        
        <label for="nome">Nome do Pai do Petiano:</label><br>
        <input type="text" id="pai" name="pai"/><br>

        <label for="nome">Nome da Mãe do Petiano:</label><br>
        <input type="text" id="mae" name="mae"/><br>
        
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

        <label for="tipo">Curso:</label><br>
        <select name="curso">
            <option value=""></option>
            <option value=1>Análise de Sistemas</option>
            <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
            <option value=3>Tecnologia em Redes de Computadores</option>
        </select><br><br>

        <label for="resumo">Endereço:</label><br>
        <textarea id="endereco" name="endereco" maxlength="100">Endereço do Petiano
        </textarea><br>

        <label for="data">Data de Entrada no PET:</label><br>
        <input type="text" class="data" id="dataEntrada" name="dataEntrada" /><br><br>

        <label for="data">Data de Saída do PET:</label><br>
        <input type="text" class="data" id="dataSaida" name="dataSaida" /><br><br>

        <input type="submit" value="Salvar" id="salvar"/>
    </fieldset>
</form>
<div><a href="${pageContext.request.contextPath}/petianoADM">Voltar</a></div>

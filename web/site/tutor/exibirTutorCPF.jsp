<%-- 
    Document   : exibirPetianoCPF
    Created on : 15/02/2013, 10:11:18
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <fieldset>
        <legend>Cadastro de Tutor</legend>
        <p>Nome: ${nome}</p>
        <p>Data de Nascimento: ${dataNascimento}</p>
        <p>E-mail: ${email}</p>
        <p>Link Curriculum Lattes: ${lattes}</p>
        <p>RG: ${rg}</p>
        <p>CPF: ${cpf}</p>
        <p>Data de Entrada: ${dataEntrada}</p>
        <p>Data de Saida: ${dataSaida}</p>
    </fieldset>
    <p><a href="${pageContext.request.contextPath}/tutor">Voltar</a></p>
</div>

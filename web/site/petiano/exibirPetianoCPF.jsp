<%-- 
    Document   : exibirPetianoCPF
    Created on : 06/12/2012, 10:11:18
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Petiano</title>
    </head>
    <body>
        <div>
            <fieldset>
                <legend>Cadastro de Petiano</legend>
                <p>Nome: ${nome}</p>
                <p>Data de Nascimento: ${dataNascimento}</p>
                <p>E-mail: ${email}</p>
                <p>Link Curriculum Lattes: ${lattes}</p>
                <p>Curso: <select name="curso" disabled="true">
                        <option value=1 <c:if test="${curso=='1'}">selected</c:if>>Análise de Sistemas</option>
                        <option value=2 <c:if test="${curso=='2'}">selected</c:if>>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                        <option value=3 <c:if test="${curso=='3'}">selected</c:if>>Tecnologia em Redes de Computadores</option>
                    </select></p>
                <p>Nome do Pai: ${pai}</p>
                <p>Nome da Mãe: ${mae}</p>
                <p>RG: ${rg}</p>
                <p>CPF: ${cpf}</p>
                <p>Endereço: ${endereco}</p>
                <p>Data de Entrada: ${dataEntrada}</p>
            </fieldset>
            <p><a href="${pageContext.request.contextPath}/petiano">Voltar</a></p>
        </div>
    </body>
</html>

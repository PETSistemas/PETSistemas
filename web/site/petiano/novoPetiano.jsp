<%-- 
    Document   : novoPetiano
    Created on : 05/12/2012, 09:11:39
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Petiano</title>
    </head>
    <body>
        <div>
            <form method="POST" action="${pageContext.request.contextPath}/salvarPetiano">
                <fieldset>
                    <legend>Cadastro de Petiano</legend>
                    <p>Nome: <input type="text" name="nome" size="60"></p>
                    <p>Data de Nascimento: <input type="text" name="dataNascimento" size="10"></p>
                    <p>E-mail: <input type="text" name="email" size="40"></p>
                    <p>Link Curriculum Lattes: <input type="text" name="lattes" size="40"></p>
                    <p>Curso: <select name="curso">
                            <option value=></option>
                            <option value=1>Análise de Sistemas</option>
                            <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                            <option value=3>Tecnologia em Redes de Computadores</option>
                        </select></p>
                    <p>Nome do Pai: <input type="text" name="pai" size="60"></p>
                    <p>Nome da Mãe: <input type="text" name="mae" size="60"></p>
                    <p>RG: <input type="text" name="rg" size="30"></p>
                    <p>CPF: <input type="text" name="cpf" size="14"></p>
                    <p>Endereço:</p>
                    <textarea name="endereco" rows="10" cols="50"></textarea>
                    <p>Data de Entrada: <input type="text" name="dataEntrada" size="10"></p>
                    <p>Data de Saida <input type="text" name="dataSaida" size="10"></p>
                    <p><input type="submit" value="Salvar">
                        <input type="reset" value="Limpar"></p>
                </fieldset>
            </form>
        </div>
        <p><a href="${pageContext.request.contextPath}/petiano">Voltar</a></p>
    </body>
</html>

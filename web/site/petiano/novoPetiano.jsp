<%-- 
    Document   : novoPetiano
    Created on : 05/12/2012, 09:11:39
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/salvarPetiano">
        <fieldset>
            <legend>Cadastro de Petiano</legend>
            <div>Nome: <input type="text" name="nome" size="60"></div>
            <div>Senha: <input type="password" name="senha" size="20"></div>
            <div>Data de Nascimento: <input type="text" name="dataNascimento" size="10"></div>
            <div>E-mail: <input type="text" name="email" size="40"></div>
            <div>Link Curriculum Lattes: <input type="text" name="lattes" size="40"></div>
            <div>Curso: <select name="curso">
                    <option value=""></option>
                    <option value=1>Análise de Sistemas</option>
                    <option value=2>Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                    <option value=3>Tecnologia em Redes de Computadores</option>
                </select></div>
            <div>Nome do Pai: <input type="text" name="pai" size="60"></div>
            <div>Nome da Mãe: <input type="text" name="mae" size="60"></div>
            <div>RG: <input type="text" name="rg" size="30"></div>
            <div>CPF: <input type="text" name="cpf" size="14"></div>
            <div>Endereço:</div>
            <textarea name="endereco" rows="10" cols="50"></textarea>
            <div>Data de Entrada: <input type="text" name="dataEntrada" size="10"></div>
            <div>Data de Saida <input type="text" name="dataSaida" size="10"></div>
            <div><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></div>
        </fieldset>
    </form>
</div>
<div><a href="${pageContext.request.contextPath}/petianoADM">Voltar</a></div>

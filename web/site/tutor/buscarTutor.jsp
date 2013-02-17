<%-- 
    Document   : buscarTutor
    Created on : 26/01/2013, 11:31:30
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/exibirTutorCPF">
        <fieldset>
            <legend>Pesquisa de Tutor</legend>
            <p>CPF: <input type="text" name="cpf" size="14"></p>
            <p><input type="submit" value="Pesquisar">
                <input type="reset" value="Limpar"></p>
        </fieldset>
    </form>
</div>
<p><a href="${pageContext.request.contextPath}/tutor">Voltar</a></p>

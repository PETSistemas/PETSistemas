<%-- 
    Document   : tutorADM
    Created on : 18/02/2013, 08:55:22
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>

    <form method="POST" action="${pageContext.request.contextPath}/novoTutor">
        <input type="submit" value="Cadastrar Novo Tutor">
    </form>
    <br/>

    <form method="POST" action="${pageContext.request.contextPath}/buscarNome">
        <fieldset>
            <legend>Pesquise pelo Tutor:</legend>
            <p>Nome:  <input type="text" name="nome" size="60"><input type="submit" value="Pesquisar"></p>
        </fieldset>


        <h3>Tutor:</h3>
        <table border="1">
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Editar</th>
                <th>Apagar</th>
            </tr>

            <c:forEach var="tutor" items="${tutores}" varStatus="status" >
                <tr>
                    <th>${tutor.cpf}</th>
                    <th>${tutor.nome}</th>
                    <th><a href="${pageContext.request.contextPath}/editarTutor?cpf=${tutor.cpf}"/><img src="site/administrativo/imagem/editar.png" width="20px" height="20px" title="Editar" alt="Link para editar registro" /></th>
                    <th><a href="${pageContext.request.contextPath}/excluirTutor?cpf=${tutor.cpf}"/><img src="site/administrativo/imagem/excluir.png" width="20px" height="20px" title="Editar" alt="Link para editar registro" /></th>
                </tr>
            </c:forEach>
        </table>
</div>
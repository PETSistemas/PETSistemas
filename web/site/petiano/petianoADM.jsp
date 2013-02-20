<%-- 
    Document   : petiano
    Created on : 05/12/2012, 08:55:22
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>

    <form method="POST" action="${pageContext.request.contextPath}/novoPetiano">
        <input type="submit" value="Cadastrar Novo Petiano">
    </form>
    <br/>

  <form method="POST" action="${pageContext.request.contextPath}/buscarNome">
        <fieldset>
            <legend>Pesquise pelo Petiano:</legend>
            <p>Nome:  <input type="text" name="nome" size="60"><input type="submit" value="Pesquisar"></p>
        </fieldset>

  
    <h3>Petianos:</h3>
    <table border="1">
        <tr>
            <th>CPF</th>
            <th>Nome</th>
            <th>Editar</th>
            <th>Apagar</th>
        </tr>
        
        <c:forEach var="petiano" items="${petianos}" varStatus="status" >
            <tr>
                <th>${petiano.cpf}</th>
                <th>${petiano.nome}</th>
                <th><a href="${pageContext.request.contextPath}/editarPetiano?cpf=${petiano.cpf}"/><img src="site/administrativo/imagem/editar.png" width="20px" height="20px" title="Editar" alt="Link para editar registro" /></th>
                <th><a href="${pageContext.request.contextPath}/excluirPetiano?cpf=${petiano.cpf}"/><img src="site/administrativo/imagem/excluir.png" width="20px" height="20px" title="Editar" alt="Link para editar registro" /></th>
            </tr>
        </c:forEach>
    </table>
</div>

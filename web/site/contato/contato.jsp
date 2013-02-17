<%-- 
    Document   : contato
    Created on : Jan 27, 2013, 1:37:02 PM
    Author     : Rebecca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/enviarContato">
        <fieldset>
            <legend>Contato</legend>
            <c:if test="${not empty mensagem}">
                <br><strong>${mensagem}</strong>
            </c:if>
            <div>Nome: <input type="text" name="nome" size="10"></div>
            <div>E-mail: <input type="text" name="email" size="10"></div>
            <div>Mensagem:</div>
            <textarea name="mensagem" rows="10" cols="50"></textarea>
            <div><input type="submit" value="Enviar"></div>
        </fieldset>
    </form>
</div>


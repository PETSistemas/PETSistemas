<%-- 
    Document   : login
    Created on : Jan 27, 2013, 1:37:02 PM
    Author     : Rebecca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div>
    <c:choose>
        <c:when test="${empty login}">

            <form method="post" action="logar">
                <fieldset>
                    <legend>Realize seu Login</legend>
                    <input type="text" class="input-block-level" id="login" name="login" placeholder="cpf">
                    <input type="password" class="input-block-level" id="senha" name="senha" placeholder="senha" >
                    <button class="btn" type="submit">Logar <i class="icon-lock"></i></button>
                </fieldset>
            </form>

        </c:when>
        <c:otherwise>
            <a class="btn" href="deslogado">Sair</a>
        </c:otherwise>
    </c:choose>    
</div>

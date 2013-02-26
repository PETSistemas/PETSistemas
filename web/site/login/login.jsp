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
            <div class="container">
                <form class="form-signin" method="post" action="${pageContext.request.contextPath}/logar">
                    <h2 class="form-signin-heading">Realize seu Login</h2>
                    <input type="text" class="input-block-level" id="login" name="login" placeholder="cpf">
                    <input type="password" class="input-block-level" id="senha" name="senha" placeholder="senha" >
                    <button class="btn btn-large btn-primary" type="submit">Logar</button>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <p>
                Olá ${login.nome}.
            </p>
            <a href="deslogar" class="btn btn-danger">Sair</a>
        </c:otherwise>
    </c:choose>    
</div>


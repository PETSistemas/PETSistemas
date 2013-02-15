<%-- 
    Document   : login
    Created on : Jan 27, 2013, 1:37:02 PM
    Author     : Rebecca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Login - ERRO</title>
    </head>
    <body>
        <div class="container">
            <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/logar">
                <span>ERRO! CPF ou Senha inválidos</span>
                <h2 class="form-signin-heading">Realize seu Login</h2>
                <input type="text" class="input-block-level" placeholder="cpf">
                <input type="password" class="input-block-level" placeholder="senha" >
                <button class="btn btn-large btn-primary" type="submit">Logar</button>
            </form>
        </div>
    </body>
</html>

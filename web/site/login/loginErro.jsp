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
        <div>
            <form method="POST" action="${pageContext.request.contextPath}/logar">
                <fieldset>
                    <legend>Realizar Login</legend>
                    <span>ERRO! CPF ou Senha inválidos</span>
                    <p>CPF: <input type="text" name="login" size="60"></p>
                    <p>Senha: <input type="password" name="senha" size="20"></p>
                    
                    <p><input type="submit" value="Logar"></p>
                </fieldset>
            </form>
        </div>
    </body>
</html>

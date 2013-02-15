<%-- 
    Document   : login
    Created on : Jan 27, 2013, 1:37:02 PM
    Author     : Rebecca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/logar" class="form-horizontal">
        <fieldset>
            <legend>Realizar Login</legend>
            <div class="control-group">
                <label class="control-label">CPF</label>
                <div class="controls">
                    <input type="text" name="login" size="60">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Senha</label>
                <div class="controls">
                    <input type="password" name="senha" size="20">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="submit" class="btn btn-primary" value="Logar">
                </div>
            </div>
        </fieldset>
    </form>
</div>


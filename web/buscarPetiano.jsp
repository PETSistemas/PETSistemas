<%-- 
    Document   : buscarPetiano
    Created on : 06/12/2012, 10:08:36
    Author     : Rebecca Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Petiano</title>
    </head>
    <body>
        <div>
            <form method="POST" action="${pageContext.request.contextPath}/exibirPetianoCPF">
                <p>CPF: <input type="text" name="cpf" size="14"></p>
                <p><input type="submit" value="Buscar"></p>
            </form>
        </div>
    </body>
</html>

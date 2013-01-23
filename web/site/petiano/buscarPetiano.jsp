<%-- 
    Document   : buscarPetiano
    Created on : 06/12/2012, 10:08:30
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
                <fieldset>
                    <legend>Pesquisa de Petiano</legend>
                    <p>CPF: <input type="text" name="cpf" size="14"></p>
                    <p><input type="submit" value="Pesquisar">
                        <input type="reset" value="Limpar"></p>
                </fieldset>
            </form>
        </div>
        <p><a href="${pageContext.request.contextPath}/petiano">Voltar</a></p>
    </body>
</html>

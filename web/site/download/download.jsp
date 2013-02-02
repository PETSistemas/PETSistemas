<%-- 
    Document   : download
    Created on : 27/01/2013, 14:36:58
    Author     : Lillydi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Downloads</title>
    </head>
    <body>
        <div>
        <h1>Downloads</h1>
        <%--<c:forEach var="download" items="${downloads}" >
              //  <p>${download.titulo}</p>
            </c:forEach> --%>
        
        <p><a href="${pageContext.request.contextPath}/novoDownload">Cadastrar Download</a></p>
            <p><a href="${pageContext.request.contextPath}/buscarDownload">Alterar/Excluir Download</a></p>
            <p><a href="${pageContext.request.contextPath}/listarDownload">Listar Downloads</a></p>
        </div>
    </body>
</html>

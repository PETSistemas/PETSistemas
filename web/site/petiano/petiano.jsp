<%-- 
    Document   : petiano
    Created on : 05/12/2012, 08:55:22
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <h1>Petiano</h1>
    <c:forEach var="petiano" items="${petianos}" varStatus="status" >
        <p>${status.count}: ${petiano.nome}</p>
    </c:forEach>

    <p><a href="${pageContext.request.contextPath}/novoPetiano">Cadastrar Petiano</a></p>
    <p><a href="${pageContext.request.contextPath}/buscarPetiano">Buscar Petiano</a></p>
    <p><a href="${pageContext.request.contextPath}/listarPetiano">Listar Petianos</a></p>

</div>

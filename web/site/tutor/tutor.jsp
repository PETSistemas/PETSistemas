<%-- 
    Document   : tutor
    Created on : 29/01/2013, 22:46:22
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <h1>Tutor</h1>
    <c:forEach var="tutor" items="${tutores}" varStatus="status" >
        <p>${status.count}: ${tutor.nome}</p>
    </c:forEach>

    <p><a href="${pageContext.request.contextPath}/buscarTutor">Buscar Tutor</a></p>
    <p><a href="${pageContext.request.contextPath}/listarTutor">Listar Tutores</a></p>

</div>


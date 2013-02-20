<%-- 
    Document   : listarDownload
    Created on : 27/01/2013, 14:39:31
    Author     : Lillydi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <div>
        <h4>Apostilas</h4>
        <c:forEach var="download" items="${apostila}" >
            <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
            </c:forEach>
        <h4>Material de Cursos</h4>
        <c:forEach var="download" items="${material}" >
            <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
            </c:forEach>
        <h4>Documentos</h4>
        <c:forEach var="download" items="${documento}" >
            <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
            </c:forEach>
        <h4>Seminários</h4>
        <c:forEach var="download" items="${seminario}" >
            <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
            </c:forEach>
        <h4>Diversos</h4>
        <c:forEach var="download" items="${diverso}" >
            <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
            </c:forEach>
        </div>
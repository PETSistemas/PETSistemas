<%-- 
    Document   : listarDownload
    Created on : 27/01/2013, 14:39:31
    Author     : Lillydi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <fieldset>
        <legend>Apostilas </legend>
        <c:forEach var="download" items="${apostila}" >
            <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
        </c:forEach>
    </fieldset>
    <fieldset>
        <legend>Material de Cursos </legend>
    <c:forEach var="download" items="${material}" >
        <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
    </c:forEach>
    </fieldset>
    <fieldset>
        <legend>Documentos </legend>
    <c:forEach var="download" items="${documento}" >
        <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
    </c:forEach>
   </fieldset>
    <fieldset>
        <legend>Seminários </legend>
    <c:forEach var="download" items="${seminario}" >
        <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
    </c:forEach>
   </fieldset>
    <fieldset>
        <legend>Diversos </legend>
    <c:forEach var="download" items="${diverso}" >
        <p><a href="${pageContext.request.contextPath}/devolveDownload?titulo=${download.titulo}" >${download.titulo}</a></p>
    </c:forEach>
    </fieldset>
</div>
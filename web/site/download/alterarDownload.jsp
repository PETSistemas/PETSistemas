<%-- 
    Document   : alterarDownload
    Created on : 27/01/2013, 14:38:29
    Author     : Lillydi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="atualizarDownload" enctype="multipart/form-data">
        <fieldset>
            <legend>Alteração de Download</legend>
            <input type="hidden" name="id" size="60" value="${downloadBusca.id}">
            <p>Titulo: <input type="text" name="titulo" size="60" value="${downloadBusca.titulo}"></p>
            <p>Categoria </p><select name="curso">
                <c:choose>
                    <c:when test="${downloadBusca.categoria==1}">
                        <option value=1 selected>Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>
                    <c:when test="${downloadBusca.categoria==2}">
                        <option value=1>Apostila</option>
                        <option value=2  selected>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>  
                    <c:when test="${downloadBusca.categoria==3}">
                        <option value=1>Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3  selected>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>
                    <c:when test="${downloadBusca.categoria==4}">
                        <option value=1>Apostila</option>
                        <option value=2  selected>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4  selected>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>
                    <c:when test="${downloadBusca.categoria==5}">
                        <option value=1>Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5  selected>Diversos</option>
                    </c:when>

                </c:choose>
                        
                      <br/>   <label>Arquivo: </label><input type="file" name="anexo"/><br/>
                <p><input type="submit" value="Atualizar"></p>
        </fieldset>
    </form>
</div>
<p><a href="download">Voltar</a></p>
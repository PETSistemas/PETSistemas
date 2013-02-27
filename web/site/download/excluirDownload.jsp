<%-- 
    Document   : excluirDownload
    Created on : 27/01/2013, 14:39:14
    Author     : Lillydi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${downloadBusca != null}">
    <c:choose>
        <c:when test="${empty login}">
            <c:redirect url="listarDownload" />
        </c:when>

        <c:otherwise>
             <form method="POST" action="removerDownload">
                <fieldset>
                    <legend>Exclusão de Arquivo</legend>

                    <input type="hidden" name="id" value="${downloadBusca.id}" />

                    <p>Título: <input type="text" name="titulo" size="60" disabled="disabled" value="${downloadBusca.titulo}"></p>
            
            <p>Nome do arquivo: <input type="text" name="anexo" size="60" disabled="disabled" value="${downloadBusca.nome}"></p>
               <p>Categoria </p><select name="categoria" disabled="disabled">
                <c:choose>
                    <c:when test="${downloadBusca.categoria==1}">
                        <option value=1 selected >Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>
                    <c:when test="${downloadBusca.categoria==2}">
                        <option value=1>Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>  
                    <c:when test="${downloadBusca.categoria==3}">
                        <option value=1>Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>
                    <c:when test="${downloadBusca.categoria==4}">
                        <option value=1>Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4  selected>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>
                    <c:when test="${downloadBusca.categoria==5}">
                        <option value=1>Apostila</option>
                        <option value=2>Material de cursos</option>
                        <option value=3>Documentos</option>
                        <option value=4>seminários</option>
                        <option value=5>Diversos</option>
                    </c:when>

                </c:choose>     
                        <br/><input class="btn btn-primary" type="submit" value="Excluir" id="salvar"/>
            </fieldset>
            </form>
        </c:otherwise>
               </c:choose>
    <p><a href="download">Voltar</a></p>
    
    
</c:if>
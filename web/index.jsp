<%-- 
    Document   : index
    Created on : 05/12/2012, 11:19:50
    Author     : Rodrigo Kuninari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PET Sistemas</title>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id = "corpo">
            <div id = "cabecalho">
                <p>PET Sistemas</p>
            </div>
            <div id = "meio">
                <div id = "menu">
                    <p><a href="${pageContext.request.contextPath}/index">Página Inicial</a></p>
                    <p><a href="${pageContext.request.contextPath}/petiano">Petianos</a></p>
                    <p><a href="${pageContext.request.contextPath}/noticia">Notícias</a></p>
                    <p><a href="${pageContext.request.contextPath}/login">Realize seu Login</a></p>
                </div>
                <div id = "conteudo">
                    <p>PET Sistemas</p>
                    <c:if test="${pagina!=''}">
                        <c:choose>

                            <%-- ********************************************************************** --%>
                            <%-- PETIANO --%>
                            
                            <c:when test="${pagina=='petiano'}">
                                <%@ include file="site/petiano/petiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='novoPetiano'}">
                                <%@ include file="site/petiano/novoPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='salvarPetiano'}">
                                <%@ include file="site/petiano/salvarPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='buscarPetiano'}">
                                <%@ include file="site/petiano/buscarPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='exibirPetianoCPF'}">
                                <%@ include file="site/petiano/exibirPetianoCPF.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='listarPetiano'}">
                                <%@ include file="site/petiano/listarPetiano.jsp" %>  
                            </c:when>

                            <%-- ********************************************************************** --%>
                            <%-- NOTICIA --%>
                            
                            <c:when test="${pagina=='noticia'}">
                                <%@ include file="site/noticia/noticia.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='novaNoticia'}">
                                <%@ include file="site/noticia/novaNoticia.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='salvarNoticia'}">
                                <%@ include file="site/noticia/salvarNoticia.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='buscarNoticia'}">
                                <%@ include file="site/noticia/buscarNoticia.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='exibirNoticiaTitulo'}">
                                <%@ include file="site/noticia/exibirNoticiaTitulo.jsp" %>  
                            </c:when>

                            <%-- ********************************************************************** --%>                        
                            <%-- LOGIN --%>
                            <%--
                            <c:when test="${pagina=='login'}">
                                <%@ include file="site/login/login.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='logado'}">
                                <%@ include file="site/administrativo/index.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='logar'}">
                                <%@ include file="site/login/loginErro.jsp" %>  
                            </c:when>
                            --%>
                        </c:choose>
                    </c:if>
                </div>
                <div id = "links">
                    <p>PET Sistemas</p>
                </div>
            </div>
            <div id = "rodape">
                <p>PET Sistemas</p>
            </div>
        </div>
    </body>
</html>

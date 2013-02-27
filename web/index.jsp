<%-- 
    Document   : index
    Created on : 05/12/2012, 11:19:50
    Author     : Tamara Mendes e Daivid Silverio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PET Sistemas</title>
        <link rel="icon" href="icon/pet.gif" type="resources/css/image/gif" />

        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="resources/bootstrap/css/datepicker.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/bootstrap/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="resources/js/jquery.validate.js"></script>
        <script type="text/javascript" src="resources/js/additional-methods.js"></script>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="resources/js/todos.js"></script>
    </head>
    <body>
        <div class = "container-fluid corpo">
            <div class="hero-unit cabecalho">
                <h1>PET Sistemas</h1>
            </div>

            <div class="row corpo">
                <div class = "span3 menu">
                    <div class="well sidebar-nive">
                        <ul class="nav nav-list">
                            <li class="nav-header">Opções</li>
                            <li class="active"><a href="${pageContext.request.contextPath}/index">Página Inicial</a></li>
                            <li class="divider"></li>
                            <li class="nav-header">Pessoa</li>
                            <li><a href="${pageContext.request.contextPath}/tutor">Tutor</a></li>
                            <li><a href="${pageContext.request.contextPath}/petiano">Petiano</a></li>
                            <li><a href="${pageContext.request.contextPath}/colaborador">Colaborador</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/nossaHistoria">Nossa História</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/publicacao">Publicação</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/projeto">Projetos</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/facaParte">Faça Parte do PET</a></li>
                        </ul>
                    </div>
                </div>

                <div class="span10 well meio">
                    <c:if test="${not empty pagina}">
                        <c:choose>

                            <%-- ********************************************************************** --%>
                            <%-- PETIANO --%>
                            <c:when test="${pagina eq 'novoPetiano'}">
                                <%@ include file="site/petiano/novoPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'excluirPetiano'}">
                                <%@ include file="site/petiano/excluirPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'editarPetiano'}">
                                <%@ include file="site/petiano/editarPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'listarPetiano'}">
                                <%@ include file="site/petiano/listarPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'petiano'}">
                                <%@ include file="site/petiano/petiano.jsp" %>  
                            </c:when>

                            <%-- ********************************************************************** --%>
                            <%-- TUTOR --%>

                            <c:when test="${pagina=='novoTutor'}">
                                <%@ include file="site/tutor/novoTutor.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='excluirTutor'}">
                                <%@ include file="site/tutor/excluirTutor.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='editarTutor'}">
                                <%@ include file="site/tutor/editarTutor.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='listarTutor'}">
                                <%@ include file="site/tutor/listarTutor.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='tutor'}">
                                <%@ include file="site/tutor/tutor.jsp" %>  
                            </c:when>

                            <%-- ********************************************************************** --%>
                            <%-- COLABORADOR --%>

                            <c:when test="${pagina=='novoColaborador'}">
                                <%@ include file="site/colaborador/novoColaborador.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='excluirColaborador'}">
                                <%@ include file="site/colaborador/excluirColaborador.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='editarColaborador'}">
                                <%@ include file="site/colaborador/editarColaborador.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='listarColaborador'}">
                                <%@ include file="site/colaborador/listarColaborador.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='colaborador'}">
                                <%@ include file="site/colaborador/colaborador.jsp" %>  
                            </c:when>

                            <%-- ********************************************************************** --%>                        
                            <%-- PROJETOS --%>

                            <c:when test="${pagina eq 'projeto'}">
                                <%@include file="site/projeto/projeto.jsp" %>
                            </c:when>

                            <c:when test="${pagina eq 'novoProjeto'}">
                                <%@include file="site/projeto/novoProjeto.jsp" %>
                            </c:when>

                            <c:when test="${pagina eq 'listarProjeto'}">
                                <%@include file="site/projeto/listarProjeto.jsp" %>
                            </c:when>

                            <c:when test="${pagina eq 'alterarProjeto'}">
                                <%@include file="site/projeto/alterarProjeto.jsp" %>
                            </c:when>

                            <c:when test="${pagina eq 'apagarProjeto'}">
                                <%@include file="site/projeto/apagarProjeto.jsp" %>
                            </c:when>

                            <c:when test="${pagina eq 'listarParticipantes'}">
                                <%@include file="site/projeto/listarParticipantes.jsp" %>
                            </c:when>

                            <%-- ********************************************************************** --%>                        
                            <%-- LOGIN --%>
                            <c:when test="${pagina eq 'login'}">
                                <%@ include file="site/login/login.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'loginErro'}">
                                <%@ include file="site/login/loginErro.jsp" %>  
                            </c:when>


                            <%-- ********************************************************************** --%>
                            <%-- PUBLICAÇÃO --%>

                            <c:when test="${pagina eq 'publicacao'}">
                                <%@ include file="site/publicacao/publicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'listarAutores'}">
                                <%@ include file="site/publicacao/listarAutores.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'novaPublicacao'}">
                                <%@ include file="site/publicacao/novaPublicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'listarPublicacao'}">
                                <%@ include file="site/publicacao/listarPublicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'alterarPublicacao'}">
                                <%@ include file="site/publicacao/alterarPublicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'removerPublicacao'}">
                                <%@ include file="site/publicacao/removerPublicacao.jsp" %>  
                            </c:when>

                            <%-- ********************************************************************** --%>
                            <%-- DOWNLOAD --%>

                            <c:when test="${pagina eq 'download'}">
                                <%@ include file="site/download/download.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'novoDownload'}">
                                <%@ include file="site/download/novoDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'alterarDownload'}">
                                <%@ include file="site/download/alterarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'salvarDownload'}">
                                <%@ include file="site/download/salvarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'buscarDownload'}">
                                <%@ include file="site/download/buscarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'listarDownload'}">
                                <%@ include file="site/download/listarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina eq 'excluirDownload'}">
                                <%@ include file="site/download/excluirDownload.jsp" %>  
                            </c:when>

                            <%-- ********************************************************************** --%>
                            <%-- NOSSA HISTORIA --%>

                            <c:when test="${pagina eq 'nossaHistoria'}">
                                <%@ include file="site/nossaHistoria/nossaHistoria.jsp" %>  
                            </c:when>

                            <c:when test="${pagina eq 'voltarNossaHistoria'}">
                            </c:when>

                            <%-- ********************************************************************** --%>
                            <%-- FACA PARTE --%>

                            <c:when test="${pagina eq 'facaParte'}">
                                <%@ include file="site/facaParte/facaParte.jsp" %>  
                            </c:when>
                        </c:choose>
                    </c:if>
                    <c:if test="${empty pagina or pagina eq 'index'}">
                        <div class="logoMeio">
                            <img alt="Logo PET Sistemas" src="imagens/pet.png"/>
                        </div>
                    </c:if>  
                </div>


                <div class="span3 meio2">
                    <div class="well login">
                        <%@ include file="site/login/login.jsp" %>                
                    </div>
                    <div class="well sidebar-nive">
                        <ul class="nav nav-list">
                            <li><a href="${pageContext.request.contextPath}/download">Downloads</a></li>
                        </ul>
                    </div>
                    <div class="linksuteis">  
                        <div class="well sidebar-nive">
                            <ul class="nav nav-list">
                                <li class="nav-header">Links Uteis:</li>
                                <a href='http://www.ufms.br' ><img src = 'imagens/logo-ufms.png'/>  </a></br></br>
                                <a href='http://www.facom.ufms.br' ><img src = 'imagens/logo-facom.png'/></a><br/
                            </ul>    
                        </div>
                    </div>
                </div>

            </div>    
        </div>  
    </body>
</html>


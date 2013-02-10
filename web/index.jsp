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
        <script type="text/javascript" src="resources/js/jquery-1.9.0.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#inserir").click(function() {
                    $("#pessoas_selecionadas").prepend($("#lista_pessoas option:selected"));
                });
                $("#remover").click(function() {
                    $("#lista_pessoas").prepend($("#pessoas_selecionadas option:selected"));
                });

                $("#salvar").click(function() {
                    $("#pessoas_selecionadas option").each(function() {
                        $(this).attr('selected', 'selected');
                    });
                });
            });

        </script>

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
                    <p><a href="${pageContext.request.contextPath}/publicacao">Publicação</a></p>
                    <p><a href="${pageContext.request.contextPath}/projeto">Projetos</a></p>
                    <p><a href="${pageContext.request.contextPath}/login">Realize seu Login</a></p>
                    <p><a href="${pageContext.request.contextPath}/download">Downloads</a></p>
                    <p><a href="${pageContext.request.contextPath}/nossaHistoria">Nossa História</a></p>

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
                            <%-- PROJETOS --%>

                            <c:when test="${pagina == 'projeto'}">
                                <%@include file="site/projeto/projeto.jsp" %>
                            </c:when>

                            <c:when test="${pagina == 'novoProjeto'}">
                                <%@include file="site/projeto/novoProjeto.jsp" %>
                            </c:when>
                            
                            <c:when test="${pagina == 'listarProjeto'}">
                                <%@include file="site/projeto/listarProjeto.jsp" %>
                            </c:when>
                            
                            <c:when test="${pagina == 'alterarProjeto'}">
                                <%@include file="site/projeto/alterarProjeto.jsp" %>
                            </c:when>

                            <c:when test="${pagina == 'apagarProjeto'}">
                                <%@include file="site/projeto/apagarProjeto.jsp" %>
                            </c:when>
                            
                            <%-- ********************************************************************** --%>                        
                            <%-- LOGIN --%>
                            <c:when test="${pagina=='login'}">
                                <%@ include file="site/login/login.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='logado'}">
                                <%@ include file="site/administrativo/index.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='logar'}">
                                <%@ include file="site/login/loginErro.jsp" %>  
                            </c:when>


                            <%-- ********************************************************************** --%>
                            <%-- PUBLICAÇÃO --%>

                            <c:when test="${pagina=='publicacao'}">
                                <%@ include file="site/publicacao/publicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='novaPublicacao'}">
                                <%@ include file="site/publicacao/novaPublicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='salvarPublicacao'}">
                                <%@ include file="site/publicacao/salvarPublicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='buscarPublicacao'}">
                                <%@ include file="site/publicacao/buscarPublicacao.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='exibirPublicacaoTitulo'}">
                                <%@ include file="site/publicacao/exibirPublicacaoTitulo.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='listarPublicacao'}">
                                <%@ include file="site/publicacao/publicacaoADM.jsp" %>  
                            </c:when>
                            <%--<c:when test="${pagina=='alterarPublicacao'}">
                                <%@ include file="site/publicacao/alterarPublicacao.jsp" %>  
                            </c:when>
                            --%>
                            
                            <%-- ********************************************************************** --%>
                            <%-- DOWNLOAD --%>

                            <c:when test="${pagina=='download'}">
                                <%@ include file="site/download/download.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='novoDownload'}">
                                <%@ include file="site/download/novoDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='alterarDownload'}">
                                <%@ include file="site/download/alterarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='salvarDownload'}">
                                <%@ include file="site/download/salvarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='buscarDownload'}">
                                <%@ include file="site/download/buscarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='listarDownload'}">
                                <%@ include file="site/download/listarDownload.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='excluirDownload'}">
                                <%@ include file="site/download/excluirDownload.jsp" %>  
                            </c:when>
                            
                            <%-- ********************************************************************** --%>
                            <%-- NOSSA HISTORIA --%>

                            <c:when test="${pagina=='nossaHistoria'}">
                                <%@ include file="site/nossaHistoria/nossaHistoria.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='voltarNossaHistoria'}">
                            </c:when>
                        </c:choose>
                    </c:if>
                </div>
                <div id = "links">
                    <p>PET Sistemas</p>
                </div>
            </div>
            <div id="footer" class="row-fluid offset6">
                <p class="muted">Pet Sistemas</p>
            </div>
        </div>


    </body>
</html>

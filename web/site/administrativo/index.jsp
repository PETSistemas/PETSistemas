<%-- 
    Document   : index
    Created on : 05/12/2012, 11:19:50
    Author     : Rebecca Alves
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
                <%@include file="/WEB-INF/validarLogin.jspf" %>
                Bem Vindo(a): ${login.nome}
                <a href="${pageContext.request.contextPath}/deslogar">Sair</a>

            </div>
            <div id = "meio">
                <div id = "menu">
                    <p><a href="${pageContext.request.contextPath}/index">Página Inicial</a></p>
                    <p><a href="${pageContext.request.contextPath}/petianoADM">Administrar Petianos</a></p>
                    <p><a href="${pageContext.request.contextPath}/tutorADM">Administrar Tutores</a></p>

                    
                </div>
                <div id = "conteudo">
                    <p>PET Sistemas</p>
                    <c:if test="${pagina!=''}">
                        <c:choose>
                            <%-- ********************************************************************** --%>
                            <%-- PETIANO --%>
                            <c:when test="${pagina=='petianoADM'}">
                                <%@ include file="/site/petiano/petianoADM.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='novoPetiano'}">
                                <%@ include file="/site/petiano/novoPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='editarPetiano'}">
                                <%@ include file="/site/petiano/editarPetiano.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='excluirPetiano'}">
                                <%@ include file="/site/petiano/excluirPetiano.jsp" %>  
                            </c:when>
                            <%-- ********************************************************************** --%>
                            <%-- TUTOR --%>
                            <c:when test="${pagina=='tutorADM'}">
                                <%@ include file="/site/tutor/tutorADM.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='novoTutor'}">
                                <%@ include file="/site/tutor/novoTutor.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='editarTutor'}">
                                <%@ include file="/site/tutor/editarTutor.jsp" %>  
                            </c:when>
                            <c:when test="${pagina=='excluirTutor'}">
                                <%@ include file="/site/tutor/excluirTutor.jsp" %>  
                            </c:when>

                            
                            
                            
                            
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

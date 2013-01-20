<%-- 
    Document   : index
    Created on : 04/12/2012, 11:19:31
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
                </div>
                <div id = "conteudo">
                    <p>PET Sistemas</p>
                    <c:if test="${pagina!=''}">
                        <c:if test="${pagina=='petiano'}">
                            <%@ include file="petiano.jsp" %>  
                        </c:if>
                        <c:if test="${pagina=='novoPetiano'}">
                            <%@ include file="novoPetiano.jsp" %>  
                        </c:if>
                        <c:if test="${pagina=='salvarPetiano'}">
                            <%@ include file="salvarPetiano.jsp" %>  
                        </c:if>
                        <c:if test="${pagina=='buscarPetiano'}">
                            <%@ include file="buscarPetiano.jsp" %>  
                        </c:if>
                        <c:if test="${pagina=='exibirPetianoCPF'}">
                            <%@ include file="exibirPetianoCPF.jsp" %>  
                        </c:if>

                        <c:if test="${pagina=='noticia'}">
                            <%@ include file="noticia.jsp" %>  
                        </c:if>
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

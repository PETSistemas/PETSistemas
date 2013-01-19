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
    </head>
    <body>
        <div id = "cabecalho">

        </div>
        <div id = "corpo">
            <div id = "menu">
                <p><a href="${pageContext.request.contextPath}/index">Página Inicial</a></p>
                <p><a href="${pageContext.request.contextPath}/petiano">Petianos</a></p>
                <p><a href="${pageContext.request.contextPath}/noticia">Notícias</a></p>
            </div>
            <div id = "conteudo">
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

            </div>
        </div>
        <div id = "rodape">

        </div>
    </body>
</html>

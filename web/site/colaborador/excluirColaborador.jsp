<%-- 
    Document   : excluirColaborador
    Created on : 15/02/2013, 09:11:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${colaboradorBusca != null}">
    <c:choose>
        <c:when test="${empty login}">
            <c:redirect url="listarColaborador" />
        </c:when>

        <c:otherwise>
            <form method="POST" action="removerColaborador">
                <fieldset>
                    <legend>Exclusão do Colaborador</legend>

                    <input type="hidden" name="id" value="${colaboradorBusca.id}" />

                    <p>Nome: <input type="text" name="nome" size="60" disabled="disabled" value="${colaboradorBusca.nome}"></p>

                    <p>Data de Nascimento: <input type="text" name="dataNascimento" size="10" disabled="disabled" value="${colaboradorBusca.dataNascimentoFormatada}"></p>

                    <p>E-mail: <input type="text" name="email" size="40" disabled="disabled" value="${colaboradorBusca.email}"></p>

                    <p>Link Curriculum Lattes: <input type="text" name="lattes" size="40" disabled="disabled" value="${colaboradorBusca.linkLattes}"></p>

                    <p>Situação: <select name="situacao">

                            <c:choose>
                                <c:when test="${colaboradorBusca.situacao==1}">
                                    <option value=1 selected  disabled="disabled" >Ativo</option>
                                    <option value=2>Desativo</option>
                                </c:when>
                                <c:when test="${colaboradorBusca.situacao==2}">
                                    <option value=1  >Ativo</option>
                                    <option value=2 selected disabled="disabled" >Desativo</option>
                                </c:when>
                             </c:choose>
                        </select></p>

                    
                </fieldset>
            </form>
        </c:otherwise>
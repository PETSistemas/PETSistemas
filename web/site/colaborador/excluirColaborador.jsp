<%-- 
    Document   : excluirColaborador
    Created on : 15/02/2013, 09:11:39
    Author     : Bruno Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="POST" action="removerColaborador">
        <fieldset>
            <legend>Exclusão do Colaborador</legend>
            <input type="hidden" name="id" size="60" value="${colaboradorBusca.id}" >
            <p>Nome: <input type="text" name="nome" size="60" disabled="disabled" value="${colaboradorBusca.nome}"></p>
            <p>Data de Nascimento: <input type="text" name="dataNascimento" size="10" disabled="disabled" value="${colaboradorBusca.dataNascimentoFormatada}"></p>
            <p>E-mail: <input type="text" name="email" size="40" disabled="disabled" value="${colaboradorBusca.email}"></p>
            <p>Link Curriculum Lattes: <input type="text" name="lattes" size="40" disabled="disabled" value="${colaboradorBusca.linkLattes}"></p>
            <p>Situação: <select name="situacao">
                    <c:choose>
                        <c:when test="${colaboradorBusca.situacao==1}">
                            <option value=1 selected >Sim</option>
                            <option value=3>Não</option>
                        </c:when>
                        <c:when test="${colaboradorBusca.situacao==2}">
                            <option value=1  >Não</option>
                            <option value=2 selected>Sim</option>
                        </c:when>
                    </c:choose>
                </select></p>

            <p><input type="submit" value="Excluir"></p>
        </fieldset>
    </form>
</div>
<p><a href="colaborador">Voltar</a></p>

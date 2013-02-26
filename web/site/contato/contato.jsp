<%-- 
    Document   : contato
    Created on : Jan 27, 2013, 1:37:02 PM
    Author     : Rebecca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div>
    <form method="post" action="enviarContato" class="form-horizontal">
        <fieldset>
            <legend>Contato</legend>
            <c:if test="${not empty mensagem}">
                <br><strong>${mensagem}</strong>
            </c:if>

            <span class="info">Campos Marcados com (*) são obrigatórios</span><br><br>

            <div class="control-group">
                <label for="nome" class="control-label">*Nome :</label>
                <div class="controls">
                    <input class="input-xlarge required" type="text" id="nome" name="nome" size="10"/>
                </div>
            </div>

            <div class="control-group">
                <label for="email" class="control-label">*Email :</label>
                <div class="controls">
                    <input class="input-xlarge email required" type="text" id="email" name="email" size="40"/>
                </div>
            </div>

            <div class="control-group">
                <label for="mensagem" class="control-label">*Mensagem :</label>
                <div class="controls">
                    <textarea class="input-xlarge required" id="mensagem" name="mensagem" rows="8" placeholder="Email a ser enviado"></textarea>
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input class="btn btn-primary" type="submit" value="Enviar" id="Enviar"/>
                </div>
            </div>
        </fieldset>
    </form>
</div>


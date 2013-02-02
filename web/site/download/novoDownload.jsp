<%-- 
    Document   : novoDownload
    Created on : 27/01/2013, 14:37:51
    Author     : Lillydi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Download</title>
    </head>
    <body>
    <div>
            <form method="POST" action="${pageContext.request.contextPath}/salvarDownload">
                <fieldset>
                    <legend>Cadastro de Download</legend>
                    <p>Título: <input type="text" name="titulo" size="60"></p>
                    <p>Categoria: <select name="categoria">
                            <option value=></option>
                            <option value=1>Apostila</option>
                            <option value=2>Material de cursos</option>
                            <option value=3>Documentos</option>
                             <option value=4>seminários</option>
                             <option value=5>Diversos</option>
                        </select>
                      
                    <p>Data de inclusão: <input type="text" name="dataCriacao" size="10"></p>
                    <p>Tamanho: <input type="text" name="tamanho" size="20">MB</p>
                    <p>Público: <input type="radio" name="tipo" value="1" checked="checked">Sim</p>
                    <p><input type="submit" value="Salvar">
                        <input type="reset" value="Limpar"></p>
                </fieldset>
            </form>
        </div>
        <p><a href="${pageContext.request.contextPath}/download">Voltar</a></p>
    </body>
</html>

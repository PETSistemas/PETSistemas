<%-- 
    Document   : novoDownload
    Created on : 27/01/2013, 14:37:51
    Author     : Lillydi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div>
        <form method="POST" action="${pageContext.request.contextPath}/salvarDownload" enctype="multipart/form-data" name="form">
                <fieldset>
                    <legend>Cadastro de Download</legend>
                    
                    <div class="control-group">
                    <label for="titulo" class="control-label">*Título :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="text" id="titulo" name="titulo"/>
                    </div>
                </div>
                    
                    <label>Categoria: </label> <select name="categoria">
                            <option value=1>Apostila</option>
                            <option value=2>Material de cursos</option>
                            <option value=3>Documentos</option>
                             <option value=4>seminários</option>
                             <option value=5>Diversos</option>
                        </select><br/>
                      
                        <%--  <label>Data de inclusão: <input type="text" name="dataCriacao" size="10"></label><br/>
                    <label>Tamanho: <input type="text" name="tamanho" size="20">MB</label><br/> --%>
                    <label>Público: <input type="radio" name="tipo" value="1" checked="checked">Sim</label><br/>
                    <div class="control-group">
                    <label for="anexo" class="control-label">*Arquivo :</label>
                    <div class="controls">
                        <input class="input-xlarge required" type="file" id="anexo" name="anexo" accept = "pdf/*, image/*, text/*, video/*, application/x-rar-compressed, application/zip"/>
                    </div>
                </div>
                    
                    
                    <input type="submit" value="Salvar">
                        <input type="reset" value="Limpar">
                </fieldset>
            </form>
        </div>
        <p><a href="${pageContext.request.contextPath}/download">Voltar</a></p>
   
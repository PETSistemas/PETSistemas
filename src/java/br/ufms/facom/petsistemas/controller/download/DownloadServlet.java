/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.download;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.download.DownloadDAO;
import br.ufms.facom.petsistemas.model.dao.download.DownloadDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Arquivo;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Lillydi
 */
public class DownloadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DownloadDAO controladorBD;

    @Override
    public void init() throws ServletException {
        controladorBD = new DownloadDAOImplementacao();
    }

    private void listarDownload(HttpServletRequest request) {
        List<Arquivo> downloads = controladorBD.listarTodosDownloads();
        request.setAttribute("downloads", downloads);

    }

    private void listarDownloadPorCategoria(HttpServletRequest request) {
        List<Arquivo> downloads = controladorBD.buscarDownloadPorCategoria(1);
        request.setAttribute("apostila", downloads);
        downloads = controladorBD.buscarDownloadPorCategoria(2);
        request.setAttribute("material", downloads);
        downloads = controladorBD.buscarDownloadPorCategoria(3);
        request.setAttribute("documento", downloads);
        downloads = controladorBD.buscarDownloadPorCategoria(4);
        request.setAttribute("seminario", downloads);
        downloads = controladorBD.buscarDownloadPorCategoria(5);
        request.setAttribute("diverso", downloads);

    }

    private void salvarDownload(HttpServletRequest request) {
        String titulo = "";
        int categoria = 0;
        String data = "";
        Date dataEntrada = null;
        long tamanho = 0;
        int tipo = 0;
        FileItem fileItem = null;
        byte[] anexo = null;
        String nome = null;
        //  String path = this.getServletContext().getRealPath("WEB-INF\\files");
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(request);
                Iterator it = items.iterator();
                while (it.hasNext()) {
                    FileItem item = (FileItem) it.next();
                    if (!item.isFormField()) {
                        fileItem = item;
                        anexo = item.get();
                        nome = fileItem.getName();
                        tamanho = fileItem.getSize();
                        dataEntrada = new Date();

                    } else {
                        if (item.getFieldName().equals("titulo")) {
                            titulo = item.getString();
                        } else if (item.getFieldName().equals("categoria")) {
                            categoria = Integer.parseInt(item.getString());
                        } else if (item.getFieldName().equals("dataCriacao")) {
                            dataEntrada = Utilitarios.stringParaData(item.getString());
                        } else if (item.getFieldName().equals("tamanho")) {
                            tamanho = Integer.parseInt(item.getString());
                        } else if (item.getFieldName().equals("tipo")) {
                            tipo = Integer.parseInt(item.getString());
                        }
                    }
                    /*  if (fileItem != null) {
                     File arquivo = new File(path + "\\" + fileItem.getName());
                     try {
                     item.write(arquivo);
                     } catch (Exception e) {
                     }
                     }*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Arquivo file;
        file = new Arquivo(titulo, categoria, dataEntrada, tamanho, tipo, anexo, nome);
        controladorBD.inserir(file);
        request.setAttribute("mensagem", "Download " + titulo + " cadastrado com sucesso!");
    }

    private void atualizarDownload(HttpServletRequest request) {
        FileItem fileItem;
        byte[] anexo = null;
        String nome = null;
        long tamanho = -1;
        Date dataEntrada = null;
        int categoria = -1;
        String titulo = null;
        long id = -1;
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(request);
                Iterator it = items.iterator();
                while (it.hasNext()) {
                    FileItem item = (FileItem) it.next();
                    if (!item.isFormField()) {
                        fileItem = item;
                        anexo = item.get();
                        nome = fileItem.getName();
                        tamanho = fileItem.getSize();
                        dataEntrada = new Date();

                    } else {
                        if (item.getFieldName().equals("titulo")) {
                            titulo = item.getString();
                        } else if (item.getFieldName().equals("categoria")) {
                            categoria = Integer.parseInt(item.getString());
                        } else if (item.getFieldName().equals("id")) {
                            id = Integer.parseInt(item.getString());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        Arquivo download = controladorBD.retrieve(id);
        download.setAnexo(anexo);
        download.setCategoria(categoria);
        download.setDataCriacao(dataEntrada);
        download.setNome(nome);
        download.setTamanho(tamanho);
        download.setTitulo(titulo);
        (new DownloadDAOImplementacao()).atualizar(download);
        controladorBD.atualizar(download);

    }

    private HttpServletResponse devolverDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Arquivo download = controladorBD.buscarDownloadPeloTitulo(request.getParameter("titulo"));
        ByteArrayInputStream in = null;
        OutputStream out = null;
        byte[] buf = new byte[1024 * 1024 * 100]; //tamanho maximo de 100mb
        int lidos;
        Arquivo temp = download;
        in = new ByteArrayInputStream(temp.getAnexo());
        out = response.getOutputStream();
        response.setHeader("Content-Disposition", "attachment;filename=\"" + temp.getNome() + "\"");
        response.setContentType("application/download");
        while ((lidos = in.read(buf)) != -1) {
            out.write(buf, 0, lidos);//Transfere imagem  
            out.flush();
        }

        in.close();
        out.close();
        return response;
    }

    void buscarDownloadTitulo(HttpServletRequest request) {
        String titulo = request.getParameter("titulo");
        Arquivo download = controladorBD.buscarDownloadPeloTitulo(titulo);
        request.setAttribute("downloadBusca", download);

        request.setAttribute("titulo", download.getTitulo());
        request.setAttribute("data", Utilitarios.dataParaString(download.getDataCriacao()));
        request.setAttribute("tamanho", download.getTamanho());
        request.setAttribute("categoria", download.getCategoria());
        request.setAttribute("anexo", download.getAnexo());
        request.setAttribute("id", download.getId());
    }

    public boolean sessaoEstaAtiva(HttpServletRequest request) {
        return request.getSession().getAttribute("login") != null;
    }

    public void iniciarSinal(HttpServletRequest request) {
        request.getSession().setAttribute("sinal", 1);
    }

    public void apagarSinal(HttpServletRequest request) {
        request.getSession().removeAttribute("sinal");
    }

    public boolean sinalOK(HttpServletRequest request) {
        return request.getSession().getAttribute("sinal") != null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String jsp = null;
        if (request.getRequestURI().endsWith("/index")) {
            jsp = "/index.jsp";

        } else if (request.getRequestURI().endsWith("/download")) {
            listarDownload(request); //Implementar esse metodo
            jsp = "/index.jsp";
            request.setAttribute("pagina", "download");
        } else if (request.getRequestURI().endsWith("/devolveDownload")) {
            response = devolverDownload(request, response); //Implementar esse metodo
            response.setContentType("application/download");
            jsp = "/index.jsp";

            request.setAttribute("pagina", "listarDownload");
        } else if (request.getRequestURI().endsWith("/novoDownload")) {
            iniciarSinal(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "novoDownload");

        } else if (request.getRequestURI().endsWith("/alterarDownload")) {
            if (sessaoEstaAtiva(request)) {
                buscarDownloadTitulo(request);

                jsp = "/index.jsp";
                request.setAttribute("pagina", "alterarDownload");
            }
        } else if (request.getRequestURI().endsWith("/atualizarDownload")) {
            if (sessaoEstaAtiva(request)) {
                atualizarDownload(request);
                listarDownload(request);
                jsp = "/index.jsp";
                request.setAttribute("pagina", "download");
            }
        } else if (request.getRequestURI().endsWith("/salvarDownload")) {
            salvarDownload(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "salvarDownload");
        } else if (request.getRequestURI().endsWith("/listarDownload")) {

            listarDownloadPorCategoria(request);// Implementar esse metodo
            jsp = "/index.jsp";
            request.setAttribute("pagina", "listarDownload");
        } else if (request.getRequestURI().endsWith("/buscarDownload")) {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "buscarDownload");
        } else if (request.getRequestURI().endsWith("/excluirDownload")) {
            // excluirDownload(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "excluirDownload");
        } else {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "download");
        }

        if (jsp == null) {
            response.sendRedirect(request.getContextPath() + "/index");
        } else if (!"empty".equals(jsp)) {
            request.getRequestDispatcher(jsp).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

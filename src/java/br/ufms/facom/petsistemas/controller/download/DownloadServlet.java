/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.download;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.download.DownloadDAO;
import br.ufms.facom.petsistemas.model.dao.download.DownloadDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Arquivo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private void salvarDownload(HttpServletRequest request){
        String titulo = request.getParameter("titulo");
        int categoria = Integer.valueOf(request.getParameter("categoria"));
        String data = request.getParameter("dataCriacao");
        Date dataEntrada = Utilitarios.stringParaData(data);
        int tamanho = Integer.parseInt(request.getParameter("tamanho"));
        int tipo = Integer.valueOf(request.getParameter("tipo"));
        Arquivo file = new Arquivo(titulo, categoria, dataEntrada,tamanho,tipo);
        controladorBD.inserir(file);
        request.setAttribute("mensagem", "Download "+ titulo+" cadastrado com sucesso!");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         String jsp = null;
     if (request.getRequestURI().endsWith("/index")) {
            jsp = "/index.jsp";
        } else if (request.getRequestURI().endsWith("/download")) {
            //listarDownload(request); Implementar esse metodo
            jsp = "/index.jsp";
            request.setAttribute("pagina", "download");
        } else if (request.getRequestURI().endsWith("/novoDownload")) {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "novoDownload");
             } else if (request.getRequestURI().endsWith("/alterarDownload")) {
                 //alterarDownload(request); Implementar esse metodo
            jsp = "/index.jsp";
            request.setAttribute("pagina", "alterarDownload");
        } else if (request.getRequestURI().endsWith("/salvarDownload")) {
            salvarDownload(request); 
            jsp = "/index.jsp";
            request.setAttribute("pagina", "salvarDownload");
        } else if (request.getRequestURI().endsWith("/listarDownload")) {

            //listarDownload(request); Implementar esse metodo
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.noticia;

import br.ufms.facom.petsistemas.model.dao.noticia.NoticiaDAO;
import br.ufms.facom.petsistemas.model.dao.noticia.NoticiaDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Noticia;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controladora da Entidade Noticia. Responsável pela comunicação da View
 * com o código Java.
 *
 * @author Rodrigo Kuninari
 */
public class NoticiaServlet extends HttpServlet
{

    NoticiaDAO controladorBD;

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException
    {
        controladorBD = new NoticiaDAOImplementacao();
    }

    /**
     * Método responsável pela pesquisa de todas as notícias cadastradas
     *
     * @param request
     */
    private void listarNoticias(HttpServletRequest request)
    {
        List<Noticia> noticias = controladorBD.listarTodasNoticias();
        request.setAttribute("noticias", noticias);
    }

    /**
     * Método responsável pela criação de um novo petiano
     *
     * @param request
     */
    private void salvarNoticia(HttpServletRequest request)
    {
        request.setAttribute("mensagem", "Noticia cadastrado com sucesso!");
    }

    private void buscarNoticiaTitulo(HttpServletRequest request)
    {

        String titulo = request.getParameter("titulo");
        Noticia noticia = controladorBD.buscarNoticiaPeloTitulo(titulo);
    }

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        String jsp = null;

        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/noticia"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "noticia");
        }
        else
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "noticia");
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/index");
        }
        else if (!"empty".equals(jsp))
        {
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}

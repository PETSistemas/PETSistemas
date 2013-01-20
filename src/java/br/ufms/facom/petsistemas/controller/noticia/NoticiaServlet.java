/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.noticia;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.noticia.NoticiaDAO;
import br.ufms.facom.petsistemas.model.dao.noticia.NoticiaDAOImplementacao;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAO;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Noticia;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import java.io.IOException;
import java.util.Date;
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

    PetianoDAO controladorPetianoBD;

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
     * Método responsável pela pesquisa de todos os petianos
     *
     * @param request
     */
    private void listarPetianos(HttpServletRequest request)
    {
        controladorPetianoBD = new PetianoDAOImplementacao();
        List petianos = controladorPetianoBD.listarTodosPetianos();
        request.setAttribute("petianos", petianos);
    }

    /**
     * Método responsável pela criação de uma nova noticia
     *
     * @param request
     */
    private void salvarNoticia(HttpServletRequest request)
    {
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        Date dataInicial = Utilitarios.stringParaData(request.getParameter("dataInicial"));
        Date dataFinal = Utilitarios.stringParaData(request.getParameter("dataFinal"));
        int tipo = Integer.valueOf(request.getParameter("tipo"));
        Petiano petiano = controladorPetianoBD.retrieve(Long.valueOf(request.getParameter("petiano")));

        Noticia noticia = new Noticia(titulo, conteudo, dataInicial, dataFinal, tipo, petiano);
        controladorBD.inserir(noticia);
        request.setAttribute("mensagem", "Noticia cadastrada com sucesso!");
    }

    /**
     * Método responsável pela pesquisa de nóticia através do título
     *
     * @param request
     */
    private void buscarNoticiaTitulo(HttpServletRequest request)
    {

        String titulo = request.getParameter("titulo");
        Noticia noticia = controladorBD.buscarNoticiaPeloTitulo(titulo);

        request.setAttribute("titulo", noticia.getTitulo());
        request.setAttribute("conteudo", noticia.getConteudo());
        request.setAttribute("dataInicial", Utilitarios.dataParaString(noticia.getDataInicial()));
        request.setAttribute("dataFinal", Utilitarios.dataParaString(noticia.getDataFinal()));
        request.setAttribute("tipo", noticia.getTipo());
        request.setAttribute("petiano", noticia.getPetiano().getNome());
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
            listarNoticias(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "noticia");
        }
        else if (request.getRequestURI().endsWith("/novaNoticia"))
        {
            listarPetianos(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "novaNoticia");
        }
        else if (request.getRequestURI().endsWith("/salvarNoticia"))
        {
            salvarNoticia(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "salvarNoticia");
        }
        else if (request.getRequestURI().endsWith("/buscarNoticia"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "buscarNoticia");
        }
        else if (request.getRequestURI().endsWith("/exibirNoticiaTitulo"))
        {
            buscarNoticiaTitulo(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "exibirNoticiaTitulo");
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

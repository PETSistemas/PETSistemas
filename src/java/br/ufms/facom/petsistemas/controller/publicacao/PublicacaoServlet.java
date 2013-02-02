/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.publicacao;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.publicacao.PublicacaoDAO;
import br.ufms.facom.petsistemas.model.dao.publicacao.PublicacaoDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Publicacao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controladora da entidade Publicacao. Responsável pela cominucação da
 * View com o código Java.
 *
 * @author Thiago
 */
public class PublicacaoServlet extends HttpServlet
{

    PublicacaoDAO controladorBD;

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException
    {
        controladorBD = new PublicacaoDAOImplementacao();
    }

    /**
     * Método responsável pela pesquisa de todas as publicações cadastradas
     *
     * @param request
     */
    private void listarPublicacoes(HttpServletRequest request)
    {
        List<Publicacao> publicacao = controladorBD.listarTodasPublicacoes();
        request.setAttribute("publicacoes", publicacao);
    }

    /**
     * Método responsável pela criação de uma nova publicação
     *
     * @param request
     */
    private void salvarPublicacao(HttpServletRequest request)
    {
        String titulo = request.getParameter("titulo");
        String resumo = request.getParameter("resumo");
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        Date dataPublicacao = Utilitarios.stringParaData(request.getParameter("dataPublicacao"));
        Date dataInclusao = Utilitarios.stringParaData(request.getParameter("dataInclusao"));

        Publicacao publicacao = new Publicacao(titulo, resumo, tipo, dataPublicacao, dataInclusao);
        controladorBD.inserir(publicacao);
        request.setAttribute("mensagem", "Publicação cadastrada com sucesso!");
    }

    private void buscarPublicacaoTitulo(HttpServletRequest request)
    {
        String titulo = request.getParameter("titulo");
        Publicacao publicacao = controladorBD.buscarPublicacaoPeloTitulo(titulo);

        request.setAttribute("titulo", publicacao.getTitulo());
        request.setAttribute("resumo", publicacao.getResumo());
        request.setAttribute("tipo", publicacao.getTipo());
        request.setAttribute("dataPublicacao", publicacao.getDataPublicacao());
        request.setAttribute("dataInclusao", publicacao.getDataInclusao());
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
        if (request.getRequestURI().endsWith("/publicacao"))
        {
            listarPublicacoes(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "publicacao");
        }
        else if (request.getRequestURI().endsWith("/novaPublicacao"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "novaPublicacao");
        }
        else if (request.getRequestURI().endsWith("/salvarPublicacao"))
        {
            salvarPublicacao(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "salvarPublicacao");
        }
        else if (request.getRequestURI().endsWith("/buscarPublicacao"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "buscarPublicacao");
        }
        else if (request.getRequestURI().endsWith("/exibirPublicacaoTitulo"))
        {
            buscarPublicacaoTitulo(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "exibirPublicacaoTitulo");
        }
        else if (request.getRequestURI().endsWith("/listarPublicacao"))
        {
            listarPublicacoes(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "listarPublicacao");
        }
        else
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "publicacao");
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
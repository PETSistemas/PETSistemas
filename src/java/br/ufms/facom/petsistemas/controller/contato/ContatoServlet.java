/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.contato;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAO;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Contato;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controladora da Entidade Contato. Responsável pela comunicação da View
 * com o código Java.
 *
 * @author Rebecca Alves
 */
public class ContatoServlet extends HttpServlet {

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
    }

    private void criarMensagem(String mensagem){
        Contato contato = new Contato();
        contato.envia(mensagem);
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jsp = null;

        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/index")) {
            jsp = "/index.jsp";

        } else if (request.getRequestURI().endsWith("/contato")) {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "contato");

        } else if (request.getRequestURI().endsWith("/enviarContato")) {
            String mensagem = "Temos uma Novo e-mail de: " + request.getParameter("nome") + "\n";
            mensagem = mensagem + "Email: " + request.getParameter("email") + "\n";
            mensagem = mensagem + "Com a seguinte mensagem: " + request.getParameter("mensagem");
            criarMensagem(mensagem);
            request.setAttribute("mensagem", "Obrigado por entrar em Contato " + request.getParameter("nome") + " ! Em breve, responderemos por e-mail.");

            jsp = "/index.jsp";
            request.setAttribute("pagina", "contato");

        } else {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "petiano");
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

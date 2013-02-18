/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.login;

import br.ufms.facom.petsistemas.model.dao.login.LoginDAO;
import br.ufms.facom.petsistemas.model.dao.login.LoginDAOImplementacao;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAO;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAOImplementacao;
import br.ufms.facom.petsistemas.model.dao.tutor.TutorDAO;
import br.ufms.facom.petsistemas.model.dao.tutor.TutorDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import br.ufms.facom.petsistemas.model.entity.Tutor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rebecca
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    LoginDAO controladorBD;
    PetianoDAO controladorPetianoBD;
    TutorDAO controladorTutorBD;
    
    Petiano master;

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
    public void init() throws ServletException {
        controladorBD = new LoginDAOImplementacao();
        controladorPetianoBD = new PetianoDAOImplementacao();
        controladorTutorBD = new TutorDAOImplementacao();
        master = new Petiano();
        master.setCpf("master");
        master.setNome("master");
        master.setCurso(0);
        master.setSenha("1");
    }

    public boolean tentarLogar(HttpServletRequest request) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Petiano petiano = controladorPetianoBD.buscarPetianoPeloCPF(login);
        Tutor tutor = controladorTutorBD.buscarTutorPeloCPF(login);
        
        if (petiano == null && tutor == null) {
            if (login.equals(master.getCpf())) {
                petiano = master;
            } else {
                return false;
            }
        }
        
        // petiano ou tutor nao sao nulos
        
        if (petiano != null && petiano.getSenha().equals(senha)) {
            request.getSession(true).setMaxInactiveInterval(600);
            request.getSession().setAttribute("login", petiano);
            return true;
        }
        // petiano eh nulo, tutor nao
        else if (tutor.getSenha().equals(senha)) {
            request.getSession(true).setMaxInactiveInterval(600);
            request.getSession().setAttribute("login", tutor);
            return true;
        }
        return false;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jsp = null;

        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/logar")) {
            jsp = "/index.jsp";
            if (!tentarLogar(request)) {
                request.setAttribute("pagina", "loginErro");
            }
            else {
                request.setAttribute("pagina", "login");
            }
        } else if (request.getRequestURI().endsWith("/deslogar")) {
            request.getSession().invalidate();
            jsp = "/index.jsp";
            request.setAttribute("pagina", "login");
        } else {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "login");
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

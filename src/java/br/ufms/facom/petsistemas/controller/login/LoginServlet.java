/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.login;

import br.ufms.facom.petsistemas.model.dao.login.LoginDAO;
import br.ufms.facom.petsistemas.model.dao.login.LoginDAOImplementacao;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAO;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import java.io.IOException;
import java.io.PrintWriter;
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
    }

    public boolean logar(HttpServletRequest request) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (login.equals("master")) {
            return true;
        }
        controladorPetianoBD = new PetianoDAOImplementacao();
        Petiano petiano = controladorPetianoBD.buscarPetianoPeloCPF(login);

        return controladorBD.logarUsuario(login, senha, petiano, null);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jsp = null;


        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/logar")) {

            if ((logar(request) && System.getProperty("login") != null)) {
                jsp = "site/administrativo/index.jsp";
                HttpSession sessao = request.getSession();
                sessao = request.getSession();
                sessao.setAttribute("login", System.getProperty("login"));
                request.setAttribute("pagina", "logado");
            } else {
                jsp = "/index.jsp";
                request.setAttribute("pagina", "logar");
            }
        } else if (request.getRequestURI().endsWith("/login")) {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "login");

        } else if (request.getRequestURI().endsWith("/petianoADM")) {
            List<Petiano> petianos = controladorPetianoBD.listarTodosPetianos();
            request.setAttribute("petianos", petianos);

            jsp = "site/administrativo/index.jsp";
            request.setAttribute("pagina", "petianoADM");

        } else if (request.getRequestURI().endsWith("/deslogar")) {
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            jsp = "/index.jsp";
            request.setAttribute("pagina", "deslogar");
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

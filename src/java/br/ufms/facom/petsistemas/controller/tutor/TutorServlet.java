/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.tutor;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.tutor.TutorDAO;
import br.ufms.facom.petsistemas.model.dao.tutor.TutorDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Tutor;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controladora da Entidade Tutor. Responsável pela comunicação da View
 * com o código Java.
 *
 * @author bruno Monteiro
 */
public class TutorServlet extends HttpServlet {

    TutorDAO controladorBD;

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        controladorBD = new TutorDAOImplementacao();
    }

    /**
     * Método responsável pela pesquisa de todos os petianos cadastrados
     *
     * @param request
     */
    private void listarTutores(HttpServletRequest request) {
        List<Tutor> tutores = controladorBD.listarTodosTutores();
        request.setAttribute("tutores", tutores);
    }

    /**
     * Método responsável pela criação de um novo tutor
     *
     * @param request
     */
    private void salvarTutor(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        Date dataNascimento = Utilitarios.stringParaData(dataNasc);
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String dataEnt = request.getParameter("dataEntrada");
        Date dataEntrada = Utilitarios.stringParaData(dataEnt);
        String dataSai = request.getParameter("dataSaida");
        Date dataSaida = Utilitarios.stringParaData(dataSai);

        Tutor tutor = new Tutor(rg, cpf, dataEntrada, dataSaida, senha, nome, dataNascimento, email, lattes, null);
        controladorBD.inserir(tutor);
        request.setAttribute("mensagem", "Tutor " + nome + " cadastrado com sucesso!");
    }

    /**
     * Método responsável pela busca de Tutor pelo CPF
     *
     * @param request
     */
    private void buscarTutorCPF(HttpServletRequest request) {

        String cpf = request.getParameter("cpf");
        Tutor tutor = controladorBD.buscarTutorPeloCPF(cpf);

        request.setAttribute("nome", tutor.getNome());
        request.setAttribute("dataNascimento", Utilitarios.dataParaString(tutor.getDataNascimento()));
        request.setAttribute("email", tutor.getEmail());
        request.setAttribute("lattes", tutor.getLinkLattes());
        request.setAttribute("senha", tutor.getSenha());
        request.setAttribute("rg", tutor.getRg());
        request.setAttribute("cpf", tutor.getCpf());
        request.setAttribute("dataEntrada", Utilitarios.dataParaString(tutor.getDataEntrada()));
           request.setAttribute("dataSaida", Utilitarios.dataParaString(tutor.getDataSaida()));
    }
    
    private void buscarTutorNome(HttpServletRequest request) {

        String cpf = request.getParameter("cpf");
        Tutor tutor = controladorBD.buscarTutorPeloCPF(cpf);

        request.setAttribute("nome", tutor.getNome());
        request.setAttribute("dataNascimento", Utilitarios.dataParaString(tutor.getDataNascimento()));
        request.setAttribute("email", tutor.getEmail());
        request.setAttribute("lattes", tutor.getLinkLattes());
        request.setAttribute("senha", tutor.getSenha());
        request.setAttribute("rg", tutor.getRg());
        request.setAttribute("cpf", tutor.getCpf());
        request.setAttribute("dataEntrada", Utilitarios.dataParaString(tutor.getDataEntrada()));
    }

    /**
     * Método responsável por buscar Tutores ativos e Desativos Separa os
     * ativos dos desativos em variáveis diferentes
     *
     * @param request
     */
    private void buscarTutorSituacao(HttpServletRequest request) {

        List<Tutor> tutores = controladorBD.buscarTutorPelaSituacao(1);
        request.setAttribute("tutoresAtivos", tutores);

        tutores = controladorBD.buscarTutorPelaSituacao(0);
        request.setAttribute("tutoresDesativos", tutores);

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
                if (request.getRequestURI().endsWith("/tutor"))
        {
            listarTutores(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "tutor");
        }
        else if (request.getRequestURI().endsWith("/novoTutor"))
        {
            listarTutores(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "novoTutor");
        }
        else if (request.getRequestURI().endsWith("/salvarTutor"))
        {
            salvarTutor(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "salvarTutor");
        }
        else if (request.getRequestURI().endsWith("/listarTutor")) {
            buscarTutorSituacao(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "listarTutor");
        }          
        else if (request.getRequestURI().endsWith("/buscarTutor"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "buscarTutor");
        }
       else if (request.getRequestURI().endsWith("/exibirTutorCPF")) {
            buscarTutorCPF(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "exibirTutorCPF");
        } else {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "tutor");
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

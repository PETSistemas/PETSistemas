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
     * Método responsável pela pesquisa de todos os tutors cadastrados
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

        Date dataSaida = null;

        if (dataSai != null) {
            dataSaida = Utilitarios.stringParaData(dataSai);
        }

        Tutor tutor = new Tutor(senha, rg, cpf, dataEntrada, dataSaida, nome, dataNascimento, email, lattes, null);
        tutor.setDataEntradaFormatada(dataEnt);
        tutor.setDataNascimentoFormatada(dataNasc);
        if (dataSai != null) {
            tutor.setDataSaidaFormatada(dataSai);
        }
        controladorBD.inserir(tutor);
        request.setAttribute("mensagem", "Tutor " + nome + " cadastrado com sucesso!");
    }

    private void atualizarTutor(HttpServletRequest request) {

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        Date dataNascimento = Utilitarios.stringParaData(dataNasc);
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String rg = request.getParameter("rg");
        String dataEnt = request.getParameter("dataEntrada");
        Date dataEntrada = Utilitarios.stringParaData(dataEnt);
        String dataSai = request.getParameter("dataSaida");
        Date dataSaida = null;
        if (dataSai != null) {
            dataSaida = Utilitarios.stringParaData(dataSai);
        }
        Long id = Long.parseLong(request.getParameter("id"));

        Tutor tutor = controladorBD.retrieve(id);

        tutor.setNome(nome);
        tutor.setDataEntrada(dataEntrada);
        tutor.setDataNascimento(dataNascimento);
        tutor.setDataSaida(dataSaida);
        tutor.setDataEntradaFormatada(Utilitarios.dataParaString(dataEntrada));
        if (dataSaida != null) {
            tutor.setDataSaidaFormatada(Utilitarios.dataParaString(dataSaida));
        }
        tutor.setDataNascimentoFormatada(Utilitarios.dataParaString(dataNascimento));

        tutor.setRg(rg);
        tutor.setEmail(email);
        tutor.setLinkLattes(lattes);

        (new TutorDAOImplementacao()).atualizar(tutor);
        controladorBD.atualizar(tutor);

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

        request.setAttribute("tutorBusca", tutor);

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
     * Método responsável por buscar Tutores ativos e Desativos Separa os ativos
     * dos desativos em variáveis diferentes
     *
     * @param request
     */
    private void buscarTutorSituacao(HttpServletRequest request) {

        List<Tutor> tutores = controladorBD.buscarTutorPelaSituacao(1);
        request.setAttribute("tutoresAtivos", tutores);

        tutores = controladorBD.buscarTutorPelaSituacao(0);

        request.setAttribute("tutoresDesativos", tutores);

    }
        
        
    

    public void removerTutor(HttpServletRequest request) {

        Long id = Long.valueOf(request.getParameter("id"));

        Tutor tutor = controladorBD.retrieve(id);

        if (tutor != null) {
            controladorBD.deletar(tutor);
        }
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
        String pagina = "tutor";

        //redirect for the correct method in accordance with to received uri:

        if (request.getRequestURI()
                .endsWith("/tutor")) {
            listarTutores(request);


        } else if (request.getRequestURI()
                .endsWith("/editarTutor")) {
            if (sessaoEstaAtiva(request)) {
                buscarTutorCPF(request);
                pagina = "editarTutor";
            }

        } else if (request.getRequestURI()
                .endsWith("/atualizarTutor")) {
            if (sessaoEstaAtiva(request)) {
                atualizarTutor(request);
                listarTutores(request);
            }
        } else if (request.getRequestURI().endsWith("/novoTutor")) {
            iniciarSinal(request);
            pagina = "novoTutor";

        } else if (request.getRequestURI()
                .endsWith("/excluirTutor")) {
            buscarTutorCPF(request);
            pagina = "excluirTutor";

        } else if (request.getRequestURI()
                .endsWith("/salvarTutor")) {
            if (sessaoEstaAtiva(request)) {
                if (sinalOK(request)) {
                    salvarTutor(request);
                    apagarSinal(request);
                }
                listarTutores(request);
            }

        } else if (request.getRequestURI()
                .endsWith("/removerTutor")) {
            if (sessaoEstaAtiva(request)) {
                removerTutor(request);
            }
            listarTutores(request);


        } else if (request.getRequestURI()
                .endsWith("/listarTutor")) {
            buscarTutorSituacao(request);
            pagina = "listarTutor";

        }

        request.setAttribute(
                "pagina", pagina);
        request.getRequestDispatcher(
                "/index.jsp").forward(request, response);

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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.tutor;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAO;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAOImplementacao;
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
    PetianoDAO controladorPetianoBD;

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
     * Método responsável pela pesquisa de todos os tutores cadastrados
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
    public boolean validarInclusao(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String senha = Utilitarios.encripta(request.getParameter("senha"));
        String dataEnt = request.getParameter("dataEntrada");
        String dataSai = request.getParameter("dataSaida");

        if (!Utilitarios.isCPF(cpf)) {
            request.setAttribute("mensagemErroTutor", "O número: " + cpf +" não é um CPF válido!");
            return false;
        } else if (nome.equals("") || nome == null) {
            request.setAttribute("mensagemErroTutor", "O Campo Nome é Obrigatógio!");
            return false;
        } else if (dataNasc.equals("") || dataNasc == null) {
            request.setAttribute("mensagemErroTutor", "O Campo Data de Nascimento é Obrigatógio!");
            return false;
        } else if (rg.equals("") || rg == null) {
            request.setAttribute("mensagemErroTutor", "O Campo RG é Obrigatógio!");
            return false;
        } else if (cpf.equals("") || cpf == null) {
            request.setAttribute("mensagemErroTutor", "O Campo CPF é Obrigatógio!");
            return false;
        } else if (email.equals("") || email == null) {
            request.setAttribute("mensagemErroTutor", "O Campo Nome é Obrigatógio!");
            return false;
        } else if (lattes.equals("") || lattes == null) {
            request.setAttribute("mensagemErroTutor", "O Campo Link do Curriculum Lattes é Obrigatógio!");
            return false;
        } else if (dataEnt.equals("") || dataEnt == null) {
            request.setAttribute("mensagemErroTutor", "O Campo Data de Entrada é Obrigatógio!");
            return false;
        } else {
            buscarTutorCPF(request);
            controladorPetianoBD = new PetianoDAOImplementacao();
            Petiano petiano = controladorPetianoBD.buscarPetianoPeloCPF(cpf);
            if (request.getAttribute("tutorBusca") != null) {
                request.setAttribute("mensagemErroTutor", "Já existe um tutor com este CPF!");
                return false;
            } else if (petiano != null) {
                request.setAttribute("mensagemErroTutor", "Já existe um tutor com este CPF!");
                return false;
            } else {
                Date dataNascimento = Utilitarios.stringParaData(dataNasc);
                Date dataEntrada = Utilitarios.stringParaData(dataEnt);
                salvarTutor(request, senha, rg, cpf, dataEntrada, dataSai, nome, dataNascimento, email, lattes);
                return true;
            }
        }
    }

    /**
     * Método responsável pela criação de um novo tutor
     *
     * @param request
     */
    private void salvarTutor(HttpServletRequest request, String senha, String rg, String cpf, Date dataEntrada, String dataSai, String nome, Date dataNascimento, String email, String lattes) {

        Date dataSaida = null;

        if (!dataSai.equals("")) {
            dataSaida = Utilitarios.stringParaData(dataSai);
        }

        Tutor tutor = new Tutor(senha, rg, cpf, dataEntrada, dataSaida, nome, dataNascimento, email, lattes, null);
        tutor.setDataEntradaFormatada(Utilitarios.dataParaString(dataEntrada));
        tutor.setDataNascimentoFormatada(Utilitarios.dataParaString(dataNascimento));

        if (!dataSai.equals("")) {
            tutor.setDataSaidaFormatada(dataSai);
        } else {
            tutor.setDataSaidaFormatada(null);
        }
        controladorBD.inserir(tutor);
    }

   public boolean validarEdição(HttpServletRequest request) {

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        Date dataNascimento = Utilitarios.stringParaData(dataNasc);
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String rg = request.getParameter("rg");
        String endereco = request.getParameter("endereco");
        String dataEnt = request.getParameter("dataEntrada");
        Date dataEntrada = Utilitarios.stringParaData(dataEnt);
        String dataSai = request.getParameter("dataSaida");


        if (nome.equals("") || nome == null) {
            request.setAttribute("mensagemErroPetiano", "O Campo Nome é Obrigatógio!");
            return false;
        } else if (dataNasc.equals("") || dataNasc == null) {
            request.setAttribute("mensagemErroPetiano", "O Campo Data de Nascimento é Obrigatógio!");
            return false;
       } else if (rg.equals("") || rg == null) {
            request.setAttribute("mensagemErroPetiano", "O Campo RG é Obrigatógio!");
            return false;
        } else if (email.equals("") || email == null) {
            request.setAttribute("mensagemErroPetiano", "O Campo Nome é Obrigatógio!");
            return false;
        } else if (lattes.equals("") || lattes == null) {
            request.setAttribute("mensagemErroPetiano", "O Campo Link do Curriculum Lattes é Obrigatógio!");
            return false;
       } else if (dataEnt.equals("") || dataEnt == null) {
            request.setAttribute("mensagemErroPetiano", "O Campo Data de Entrada é Obrigatógio!");
            return false;
        } else {
            atualizarTutor(request, rg, dataEntrada, dataSai, nome, dataNascimento, email, lattes);
            return true;
        }
    }

    private void atualizarTutor(HttpServletRequest request, String rg, Date dataEntrada, String dataSai, String nome, Date dataNascimento, String email, String lattes) {

        Date dataSaida = null;

        if (!dataSai.equals("")) {
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
            tutor.setDataSaidaFormatada(dataSai);
        } else {
            tutor.setDataSaidaFormatada("");
        }
        tutor.setDataNascimentoFormatada(Utilitarios.dataParaString(dataNascimento));

        tutor.setRg(rg);
        tutor.setEmail(email);
        tutor.setLinkLattes(lattes);

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
            if (Utilitarios.sessaoEstaAtiva(request, "login")) {
                buscarTutorCPF(request);
                pagina = "editarTutor";
            }

        } else if (request.getRequestURI()
                .endsWith("/atualizarTutor")) {
            if (Utilitarios.sessaoEstaAtiva(request, "login")) {
                if (validarEdição(request)) {
                    listarTutores(request);
                } else {
                    pagina = "editarTutor";
                }

            }
        } else if (request.getRequestURI().endsWith("/novoTutor")) {
            Utilitarios.iniciarSinal(request);
            pagina = "novoTutor";

        } else if (request.getRequestURI()
                .endsWith("/excluirTutor")) {
            buscarTutorCPF(request);
            pagina = "excluirTutor";

        } else if (request.getRequestURI()
                .endsWith("/salvarTutor")) {
            if (Utilitarios.sessaoEstaAtiva(request, "login")) {
                if (Utilitarios.sinalOK(request)) {
                    if (validarInclusao(request)) {
                        Utilitarios.apagarSinal(request);
                        listarTutores(request);
                    } else {
                        pagina = "novoTutor";
                    }
                }
            }

        } else if (request.getRequestURI()
                .endsWith("/removerTutor")) {
            if (Utilitarios.sessaoEstaAtiva(request, "login")) {
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

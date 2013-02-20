/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.petiano;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAO;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controladora da Entidade Petiano. Responsável pela comunicação da View
 * com o código Java.
 *
 * @author Rebecca Alves
 */
public class PetianoServlet extends HttpServlet {

    PetianoDAO controladorBD;

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        controladorBD = new PetianoDAOImplementacao();
    }

    /**
     * Método responsável pela pesquisa de todos os petianos cadastrados
     *
     * @param request
     */
    private void listarPetianos(HttpServletRequest request) {
        List<Petiano> petianos = controladorBD.listarTodosPetianos();
        request.setAttribute("petianos", petianos);

    }

    /**
     * Método responsável pela criação de um novo petiano
     *
     * @param request
     */
    private void salvarPetiano(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        Date dataNascimento = Utilitarios.stringParaData(dataNasc);
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        int curso = Integer.valueOf(request.getParameter("curso"));
        String nomePai = request.getParameter("pai");
        String nomeMae = request.getParameter("mae");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        String dataEnt = request.getParameter("dataEntrada");
        Date dataEntrada = Utilitarios.stringParaData(dataEnt);
        String dataSai = request.getParameter("dataSaida");
        Date dataSaida = null;

        if (dataSai != null) {
            dataSaida = Utilitarios.stringParaData(dataSai);
        }

        Petiano petiano = new Petiano(curso, senha, nomePai, nomeMae, rg, cpf, dataEntrada, dataSaida, endereco, nome, dataNascimento, email, lattes, null);
        petiano.setDataEntradaFormatada(dataEnt);
        petiano.setDataNascimentoFormatada(dataNasc);
        if (dataSai != null) {
            petiano.setDataSaidaFormatada(dataSai);
        }
        controladorBD.inserir(petiano);
        request.setAttribute("mensagem", "Petiano " + nome + " cadastrado com sucesso!");
    }

    private void atualizarPetiano(HttpServletRequest request) {

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        Date dataNascimento = Utilitarios.stringParaData(dataNasc);
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        int curso = Integer.valueOf(request.getParameter("curso"));
        String nomePai = request.getParameter("pai");
        String nomeMae = request.getParameter("mae");
        String rg = request.getParameter("rg");

        String endereco = request.getParameter("endereco");
        String dataEnt = request.getParameter("dataEntrada");
        Date dataEntrada = Utilitarios.stringParaData(dataEnt);
        String dataSai = request.getParameter("dataSaida");
        Date dataSaida = null;

        if (dataSai != null) {
            dataSaida = Utilitarios.stringParaData(dataSai);
        }
        Long id = Long.parseLong(request.getParameter("id"));

        Petiano petiano = controladorBD.retrieve(id);

        petiano.setNome(nome);
        petiano.setDataEntrada(dataEntrada);
        petiano.setDataNascimento(dataNascimento);
        petiano.setDataSaida(dataSaida);
        petiano.setDataEntradaFormatada(Utilitarios.dataParaString(dataEntrada));
        if (dataSaida != null) {
            petiano.setDataSaidaFormatada(Utilitarios.dataParaString(dataSaida));
        }
        petiano.setDataNascimentoFormatada(Utilitarios.dataParaString(dataNascimento));

        petiano.setCurso(curso);
        petiano.setNomeMae(nomeMae);
        petiano.setNomePai(nomePai);

        petiano.setRg(rg);
        petiano.setEndereco(endereco);
        petiano.setEmail(email);
        petiano.setLinkLattes(lattes);

        (new PetianoDAOImplementacao()).atualizar(petiano);
        controladorBD.atualizar(petiano);

        request.setAttribute("mensagem", "Petiano " + nome + " cadastrado com sucesso!");
    }

    /**
     * Método responsável pela busca de Petiano pelo CPF
     *
     * @param request
     */
    private void buscarPetianoCPF(HttpServletRequest request) {

        String cpf = request.getParameter("cpf");
        Petiano petiano = controladorBD.buscarPetianoPeloCPF(cpf);


        request.setAttribute("petianoBusca", petiano);

        request.setAttribute("nome", petiano.getNome());
        request.setAttribute("dataNascimento", Utilitarios.dataParaString(petiano.getDataNascimento()));
        request.setAttribute("email", petiano.getEmail());
        request.setAttribute("lattes", petiano.getLinkLattes());
        request.setAttribute("curso", petiano.getCurso());
        request.setAttribute("pai", petiano.getNomePai());
        request.setAttribute("mae", petiano.getNomeMae());
        request.setAttribute("rg", petiano.getRg());
        request.setAttribute("cpf", petiano.getCpf());
        request.setAttribute("endereco", petiano.getEndereco());
        request.setAttribute("dataEntrada", Utilitarios.dataParaString(petiano.getDataEntrada()));

    }

    /**
     * Método responsável por buscar Petianos ativos e Desativos Separa os
     * ativos dos desativos em variáveis diferentes
     *
     * @param request
     */
    private void buscarPetianoSituacao(HttpServletRequest request) {

        List<Petiano> petianos = controladorBD.buscarPetianoPelaSituacao(1);
        request.setAttribute("petianosAtivos", petianos);

        petianos = controladorBD.buscarPetianoPelaSituacao(0);
        request.setAttribute("petianosDesativos", petianos);

    }

    public void removerPetiano(HttpServletRequest request) {

        Long id = Long.valueOf(request.getParameter("id"));

        Petiano petiano = controladorBD.retrieve(id);

        if (petiano != null) {
            controladorBD.deletar(petiano);
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
        String pagina = "petiano";

        //redirect for the correct method in accordance with to received uri:

        if (request.getRequestURI().endsWith("/index")) {
            pagina = "index";

        } else if (request.getRequestURI()
                .endsWith("/petiano")) {
            listarPetianos(request);


        } else if (request.getRequestURI()
                .endsWith("/editarPetiano")) {
            if (sessaoEstaAtiva(request)) {
                buscarPetianoCPF(request);
                pagina = "editarPetiano";
            }

        } else if (request.getRequestURI()
                .endsWith("/atualizarPetiano")) {
            if (sessaoEstaAtiva(request)) {
                atualizarPetiano(request);
                listarPetianos(request);
            }
        } else if (request.getRequestURI().endsWith("/novoPetiano")) {
            iniciarSinal(request);
            pagina = "novoPetiano";

        } else if (request.getRequestURI()
                .endsWith("/excluirPetiano")) {
            buscarPetianoCPF(request);
            pagina = "excluirPetiano";

        } else if (request.getRequestURI()
                .endsWith("/salvarPetiano")) {
            if (sessaoEstaAtiva(request)) {
                if (sinalOK(request)) {
                    salvarPetiano(request);
                    apagarSinal(request);
                }
                listarPetianos(request);
            }

        } else if (request.getRequestURI()
                .endsWith("/removerPetiano")) {
            if (sessaoEstaAtiva(request)) {
                removerPetiano(request);
            }
            listarPetianos(request);


        } else if (request.getRequestURI()
                .endsWith("/listarPetiano")) {
            buscarPetianoSituacao(request);
            pagina = "listarPetiano";

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

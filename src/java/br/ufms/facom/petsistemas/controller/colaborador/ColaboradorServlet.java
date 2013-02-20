/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.colaborador;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.colaborador.ColaboradorDAO;
import br.ufms.facom.petsistemas.model.dao.colaborador.ColaboradorDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Colaborador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controladora da Entidade Colaborador. Responsável pela comunicação da
 * View com o código Java.
 *
 * @author Rebecca Alves
 */
public class ColaboradorServlet extends HttpServlet {

    ColaboradorDAO controladorBD;

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        controladorBD = new ColaboradorDAOImplementacao();
    }

    /**
     * Método responsável pela pesquisa de todos os colaboradores cadastrados
     *
     * @param request
     */
    private void listarColaboradores(HttpServletRequest request) {
        List<Colaborador> colaboradores = controladorBD.listarTodosColaboradores();
        request.setAttribute("colaboradores", colaboradores);

    }

    /**
     * Método responsável pela criação de um novo colaborador
     *
     * @param request
     */
    private void salvarColaborador(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        Date dataNascimento = Utilitarios.stringParaData(dataNasc);
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        int situacao = Integer.valueOf(request.getParameter("situacao"));
        String cpf = request.getParameter("cpf");

        Colaborador colaborador = new Colaborador(situacao, cpf, nome, dataNascimento, email, lattes, null);
        colaborador.setDataNascimentoFormatada(dataNasc);
        controladorBD.inserir(colaborador);
        request.setAttribute("mensagem", "Colaborador " + nome + " cadastrado com sucesso!");
    }

    private void atualizarColaborador(HttpServletRequest request) {

        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNascimento");
        Date dataNascimento = Utilitarios.stringParaData(dataNasc);
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        int situacao = Integer.valueOf(request.getParameter("situacao"));
        Long id = Long.parseLong(request.getParameter("id"));

        Colaborador colaborador = controladorBD.retrieve(id);

        colaborador.setNome(nome);
        colaborador.setDataNascimento(dataNascimento);
        colaborador.setDataNascimentoFormatada(Utilitarios.dataParaString(dataNascimento));

        colaborador.setSituacao(situacao);
        colaborador.setEmail(email);
        colaborador.setLinkLattes(lattes);

        (new ColaboradorDAOImplementacao()).atualizar(colaborador);
        controladorBD.atualizar(colaborador);

        request.setAttribute("mensagem", "Colaborador " + nome + " cadastrado com sucesso!");
    }

    /**
     * Método responsável pela busca de Colaborador pelo CPF
     *
     * @param request
     */
    private void buscarColaboradorCPF(HttpServletRequest request) {

        String cpf = request.getParameter("cpf");
        Colaborador colaborador = controladorBD.buscarColaboradorPeloCPF(cpf);


        request.setAttribute("colaboradorBusca", colaborador);

        request.setAttribute("nome", colaborador.getNome());
        request.setAttribute("dataNascimento", Utilitarios.dataParaString(colaborador.getDataNascimento()));
        request.setAttribute("email", colaborador.getEmail());
        request.setAttribute("lattes", colaborador.getLinkLattes());
        request.setAttribute("situacao", colaborador.getSituacao());
        request.setAttribute("cpf", colaborador.getCpf());

    }

    /**
     * Método responsável por buscar Colaboradores ativos e Desativos Separa os
     * ativos dos desativos em variáveis diferentes
     *
     * @param request
     */
    private void buscarColaboradorSituacao(HttpServletRequest request) {

        List<Colaborador> colaboradores = controladorBD.buscarColaboradorPelaSituacao(1);
        request.setAttribute("colaboradoresAtivos", colaboradores);

        colaboradores = controladorBD.buscarColaboradorPelaSituacao(0);
        request.setAttribute("colaboradoresDesativos", colaboradores);

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
        } else if (request.getRequestURI().endsWith("/colaboradorADM")) {
            listarColaboradores(request);
            jsp = "site/administrativo/index.jsp";
            request.setAttribute("pagina", "colaboradorADM");
        } else if (request.getRequestURI().endsWith("/editarColaborador")) {
            buscarColaboradorCPF(request);
            jsp = "/site/administrativo/index.jsp";
            request.setAttribute("pagina", "editarColaborador");
        } else if (request.getRequestURI().endsWith("/atualizarColaborador")) {
            atualizarColaborador(request);
            listarColaboradores(request);
            jsp = "/site/administrativo/index.jsp";
            request.setAttribute("pagina", "colaboradorADM");
        } else if (request.getRequestURI().endsWith("/novoColaborador")) {
            jsp = "/site/administrativo/index.jsp";
            request.setAttribute("pagina", "novoColaborador");
        } else if (request.getRequestURI().endsWith("/excluirColaborador")) {
            buscarColaboradorCPF(request);
            jsp = "/site/administrativo/index.jsp";
            request.setAttribute("pagina", "excluirColaborador");
        } else if (request.getRequestURI().endsWith("/salvarColaborador")) {
            salvarColaborador(request);
            listarColaboradores(request);
            jsp = "/site/administrativo/index.jsp";
            request.setAttribute("pagina", "colaboradorADM");
        } else if (request.getRequestURI().endsWith("/listarColaborador")) {
            buscarColaboradorSituacao(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "listarColaborador");
        } else if (request.getRequestURI().endsWith("/buscarColaborador")) {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "buscarColaborador");
        } else if (request.getRequestURI().endsWith("/exibirColaboradorCPF")) {
            buscarColaboradorCPF(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "exibirColaboradorCPF");
        } else {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "colaborador");
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

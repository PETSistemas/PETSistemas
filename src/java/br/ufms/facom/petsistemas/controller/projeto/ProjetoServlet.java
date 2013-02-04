/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.projeto;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.pessoa.PessoaDAOImplementacao;
import br.ufms.facom.petsistemas.model.dao.petiano.PetianoDAOImplementacao;
import br.ufms.facom.petsistemas.model.dao.projeto.ProjetoDAO;
import br.ufms.facom.petsistemas.model.dao.projeto.ProjetoDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Pessoa;
import br.ufms.facom.petsistemas.model.entity.Projeto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daivid
 */
public class ProjetoServlet extends HttpServlet {

    ProjetoDAO projetoControladorBD;

    @Override
    public void init() throws ServletException {
        super.init();
        projetoControladorBD = new ProjetoDAOImplementacao();
    }
    
    public void listarProjetos(HttpServletRequest request) {
        List<Projeto> projetos = projetoControladorBD.listarTodosProjetos();
        request.setAttribute("projetos", projetos);
    }
    
    public void novoProjeto(HttpServletRequest request) {
        List<Pessoa> pessoas = (new PessoaDAOImplementacao()).listarPessoas();
        request.setAttribute("pessoas", pessoas);
    }
    
    public void salvarProjeto(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String[] tipos = request.getParameterValues("tipo");
        int tipo = 0;
        for (String t : tipos) {
            tipo += Integer.parseInt(t);
        }
        String resumo = request.getParameter("resumo");
        Date dataInicio = Utilitarios.stringParaData(request.getParameter("data_inicio"));
        String[] pessoas_selecionadas = request.getParameterValues("pessoas_selecionadas");
        Long[] ids = new Long[pessoas_selecionadas.length];
        for (int i = 0; i < pessoas_selecionadas.length; i++) {
            ids[i] = Long.valueOf(pessoas_selecionadas[i]);
        }
        List<Pessoa> pessoas = (new PessoaDAOImplementacao()).buscaPessoas(ids);
        
        Projeto.Builder builder = new Projeto.Builder(nome, tipo, dataInicio)
                .resumo(resumo)
                .pessoas(pessoas);
        Projeto projeto = builder.build();
        
        projetoControladorBD.inserir(projeto);
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String uri = request.getRequestURI();
        String pagina = null;
        String jsp = "/index.jsp";
        
        if (uri.endsWith("/novoProjeto")) {
            novoProjeto(request);
            pagina = "novoProjeto";
        }
        else if (uri.endsWith("/listarProjeto")) {
            listarProjetos(request);
            pagina = "listarProjeto";
        }
        else if (uri.endsWith("salvarProjeto")) {
            salvarProjeto(request);
            pagina = "projeto";
        }
        else {
            pagina = "projeto";
        }
        
        request.setAttribute("pagina", pagina);
        request.getRequestDispatcher(jsp).forward(request, response);
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

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

    public void obterProjeto(HttpServletRequest request, boolean listarPessoas) {
        String s_id = request.getParameter("id");
        Long id = null;
        if (s_id != null) {
            id = Long.valueOf(s_id);
        }

        Projeto projeto = null;
        if (id != null) {
            projeto = projetoControladorBD.retrieve(id);
        }

        if (projeto != null) {
            request.setAttribute("projeto", projeto);
            request.setAttribute("ensino", projeto.getTipo() % 2 != 0);
            request.setAttribute("pesquisa", projeto.getTipo() / 2 == 1 || projeto.getTipo() / 2 == 3);
            request.setAttribute("extensao", projeto.getTipo() / 4 > 0);
            
            if (listarPessoas) {
            List<Pessoa> pessoas = (new PessoaDAOImplementacao()).listarPessoas();
            pessoas.removeAll(projeto.getPessoas());
            request.setAttribute("lista_pessoas", pessoas);
            }
            
            request.setAttribute("pessoas_selecionadas", projeto.getPessoas());
        }
    }

    public void salvarAlteracao(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String[] tipos = request.getParameterValues("tipo");
        int tipo = 0;
        if (tipos != null) {
            for (String t : tipos) {
                tipo += Integer.parseInt(t);
            }
        }
        
        String resumo = request.getParameter("resumo");
        String dataTermino = request.getParameter("data_termino");
        String[] pessoas_selecionadas = request.getParameterValues("pessoas_selecionadas");
        Long[] ids = new Long[pessoas_selecionadas.length];
        for (int i = 0; i < pessoas_selecionadas.length; i++) {
            ids[i] = Long.valueOf(pessoas_selecionadas[i]);
        }
        List<Pessoa> pessoas = (new PessoaDAOImplementacao()).buscaPessoas(ids);

        Long id = Long.valueOf(request.getParameter("id"));
        Projeto projeto = projetoControladorBD.retrieve(id);

        if (nome != null) {
            projeto.setNome(nome);
        }

        if (resumo != null) {
            projeto.setResumo(resumo);
        }

        if (dataTermino != null) {
            projeto.setDataTermino(Utilitarios.stringParaData(dataTermino));
        }

        projeto.setTipo(tipo);
        projeto.setPessoas(pessoas);

        projetoControladorBD.atualizar(projeto);

    }

    public void salvarProjeto(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String[] tipos = request.getParameterValues("tipo");
        int tipo = 0;
        if (tipos != null) {
            for (String t : tipos) {
                tipo += Integer.parseInt(t);
            }
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

    public void removerProjeto(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        
        Projeto projeto = projetoControladorBD.retrieve(id);
        
        if (projeto != null) {
            projetoControladorBD.deletar(projeto);
            request.setAttribute("remocao", "realizada com sucesso!");
        }
        else {
            request.setAttribute("remocao", "falhou!");
        }
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
        } else if (uri.endsWith("/listarProjeto")) {
            listarProjetos(request);
            pagina = "listarProjeto";
        } else if (uri.endsWith("salvarProjeto")) {
            salvarProjeto(request);
            pagina = "projeto";
        } else if (uri.endsWith("alterarProjeto")) {
            obterProjeto(request, true);
            pagina = "alterarProjeto";
        } else if (uri.endsWith("salvarAlteracaoProjeto")) {
            salvarAlteracao(request);
            pagina = "projeto";
        } else if (uri.endsWith("apagarProjeto")) {
            obterProjeto(request, false);
            pagina = "apagarProjeto";
        } else if (uri.endsWith("efetivarRemocaoProjeto")) {
            removerProjeto(request);
            pagina = "listarProjeto";
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

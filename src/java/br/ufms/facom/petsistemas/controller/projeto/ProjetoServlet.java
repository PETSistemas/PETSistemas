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
import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.pessoa.PessoaDAO;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
    PessoaDAO pessoaControladorBD;

    /**
     * Inicia os controladores de banco de dados de Pessoa e Projeto
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        projetoControladorBD = new ProjetoDAOImplementacao();
        pessoaControladorBD = new PessoaDAOImplementacao();
    }

    /**
     * Dado o HttpServletRequest request, carrega a lista de todos os projetos
     * no atributo projetos
     *
     * @param request
     */
    public void listarProjetos(HttpServletRequest request) {
        List<Projeto> projetos = projetoControladorBD.listarTodosProjetos();
        request.setAttribute("projetos", projetos);
    }

    /**
     * Dado o HttpServletRequest request, carrega a lista de todas a pessoas no
     * atributo pessoas
     *
     * @param request
     */
    public void novoProjeto(HttpServletRequest request) {
        List<Pessoa> pessoas = pessoaControladorBD.listarPessoas();
        request.setAttribute("pessoas", pessoas);
    }

    /**
     * Dado o HttpServletRequest request e o boolean listarPessoas, obtem um
     * projeto com id "id" (parametro contido na request). Lista todas as
     * pessoas que não pertencem a o projeto no atributo "lista_pessoas", se
     * listarPessoas for true. Lista todas os participantes do projeto no
     * atributo "pessoas_selecionadas"
     *
     * @param request
     * @param listarPessoas
     */
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
                List<Pessoa> pessoas = pessoaControladorBD.listarPessoas();
                pessoas.removeAll(projeto.getPessoas());
                request.setAttribute("lista_pessoas", pessoas);
            }

            request.setAttribute("pessoas_selecionadas", projeto.getPessoas());
        }
    }

    /**
     * Salva as alterações feitas em um projeto.
     *
     * @param request
     */
    public void salvarAlteracao(HttpServletRequest request) throws UnsupportedEncodingException {
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
        List<Pessoa> pessoas = pessoaControladorBD.buscaPessoas(ids);

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

    /**
     * Cria um novo projeto
     *
     * @param request
     */
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
        List<Pessoa> pessoas = pessoaControladorBD.buscaPessoas(ids);

        Projeto.Builder builder = new Projeto.Builder(nome, tipo, dataInicio)
                .resumo(resumo)
                .pessoas(pessoas);
        Projeto projeto = builder.build();

        projetoControladorBD.inserir(projeto);
    }

    /**
     * Remove um projeto
     *
     * @param request
     */
    public void removerProjeto(HttpServletRequest request) {
        String s_id = request.getParameter("id");
        if (s_id != null) {
            Long id = Long.valueOf(s_id);

            Projeto projeto = projetoControladorBD.retrieve(id);

            if (projeto != null) {
                projetoControladorBD.deletar(projeto);
                request.setAttribute("remocao", "realizada com sucesso!");
            } else {
                request.setAttribute("remocao", "falhou!");
            }
        }
    }

    /**
     * Obtem todos os participantes do projeto, a partir do id contido na request
     * @param request
     */
    public void obterParticipantes(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));

        Projeto projeto = projetoControladorBD.retrieve(id);

        if (projeto != null) {
            if (projeto.getPessoas() != null && projeto.getPessoas().size() > 0) {
                request.setAttribute("pessoas", projeto.getPessoas());
            }
        }
    }

    
    /**
     * Processa as requisições de projetos
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

        String uri = request.getRequestURI();
        String pagina = "projeto";
        String jsp = "/index.jsp";

        if (Utilitarios.sessaoEstaAtiva(request, "login")) {
            /* Acesso Administrativo */

            if (uri.endsWith("novoProjeto")) {
                novoProjeto(request);
                Utilitarios.iniciarSinal(request);
                pagina = "novoProjeto";

            } else if (uri.endsWith("salvarProjeto")) {
                if (Utilitarios.sinalOK(request)) {
                    salvarProjeto(request);
                    Utilitarios.apagarSinal(request);
                }
                listarProjetos(request);

            } else if (uri.endsWith("alterarProjeto")) {
                obterProjeto(request, true);
                pagina = "alterarProjeto";

            } else if (uri.endsWith("salvarAlteracaoProjeto")) {
                salvarAlteracao(request);
                listarProjetos(request);

            } else if (uri.endsWith("apagarProjeto")) {
                obterProjeto(request, false);
                pagina = "apagarProjeto";

            } else if (uri.endsWith("efetivarRemocaoProjeto")) {
                removerProjeto(request);
                listarProjetos(request);

            } else {
                listarProjetos(request);
            }

        } else {
            /* Acesso Comum */

            if (uri.endsWith("listarProjeto")) {
                listarProjetos(request);
                pagina = "listarProjeto";
            } else if (uri.endsWith("listarParticipantes")) {
                obterParticipantes(request);
                pagina = "listarParticipantes";
            }
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

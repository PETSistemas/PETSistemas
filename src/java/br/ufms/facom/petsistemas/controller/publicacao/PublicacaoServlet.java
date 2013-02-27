/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller.publicacao;

import br.ufms.facom.petsistemas.controller.Utilitarios;
import br.ufms.facom.petsistemas.model.dao.pessoa.PessoaDAO;
import br.ufms.facom.petsistemas.model.dao.pessoa.PessoaDAOImplementacao;
import br.ufms.facom.petsistemas.model.dao.publicacao.PublicacaoDAO;
import br.ufms.facom.petsistemas.model.dao.publicacao.PublicacaoDAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Arquivo;
import br.ufms.facom.petsistemas.model.entity.Pessoa;
import br.ufms.facom.petsistemas.model.entity.Publicacao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Controladora da entidade Publicacao. Responsável pela cominucação da
 * View com o código Java.
 *
 * @author Thiago
 */
public class PublicacaoServlet extends HttpServlet
{

    PessoaDAO pessoaControladorBD;

    PublicacaoDAO controladorBD;

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException
    {
        controladorBD = new PublicacaoDAOImplementacao();
        pessoaControladorBD = new PessoaDAOImplementacao();
    }

    /**
     * Método responsável pela pesquisa de todas as publicações cadastradas
     *
     * @param request
     */
    private void listarPublicacoes(HttpServletRequest request)
    {
        List<Publicacao> publicacao = controladorBD.listarTodasPublicacoes();
        request.setAttribute("publicacoes", publicacao);
    }

    /**
     * Método responsárvel por iniciar uma nova publicação, linstando as pessoas
     *
     * @param request
     */
    private void novaPublicacao(HttpServletRequest request)
    {
        List<Pessoa> pessoas = (new PessoaDAOImplementacao()).listarPessoas();
        request.setAttribute("pessoas", pessoas);
    }

    /**
     * Método responsável pela criação de uma nova publicação
     *
     * @param request
     */
    private void salvarPublicacao(HttpServletRequest request)
    {
        String titulo = request.getParameter("titulo");
        String resumo = request.getParameter("resumo");
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        Date dataPublicacao = Utilitarios.stringParaData(request.getParameter("dataPublicacao"));
        Date dataInclusao = Utilitarios.stringParaData(request.getParameter("dataInclusao"));
        String[] pessoas_selecionadas = request.getParameterValues("pessoas_selecionadas");
        Long[] ids = new Long[pessoas_selecionadas.length];
        for (int i = 0; i < pessoas_selecionadas.length; i++)
        {
            ids[i] = Long.valueOf(pessoas_selecionadas[i]);
        }
        List<Pessoa> pessoas = (new PessoaDAOImplementacao()).buscaPessoas(ids);

        Publicacao publicacao = new Publicacao(titulo, resumo, tipo, dataPublicacao, dataInclusao);
        publicacao.setPessoas(pessoas);
        controladorBD.inserir(publicacao);
    }

    /**
     * Método responsável pela busca de uma publicação pelo titulo
     *
     * @param request
     */
    private void buscarPublicacaoTitulo(HttpServletRequest request)
    {
        String titulo = request.getParameter("titulo");
        Publicacao publicacao = controladorBD.buscarPublicacaoPeloTitulo(titulo);

        request.setAttribute("titulo", publicacao.getTitulo());
        request.setAttribute("resumo", publicacao.getResumo());
        request.setAttribute("tipo", publicacao.getTipo());
        request.setAttribute("dataPublicacao", Utilitarios.dataParaString(publicacao.getDataPublicacao()));
        request.setAttribute("dataInclusao", Utilitarios.dataParaString(publicacao.getDataInclusao()));
    }

    /**
     * Método responsável pela busca de uma publicação pelo id
     *
     * @param request
     */
    private void buscarPublicacaoId(HttpServletRequest request)
    {
        String idString = request.getParameter("id");
        Long id = null;
        if (idString != null)
        {
            id = Long.parseLong(idString);
        }

        Publicacao publicacao = null;
        if (id != null)
        {
            publicacao = controladorBD.retrieve(id);
        }

        if (publicacao != null)
        {
            request.setAttribute("publicacao", publicacao);

            List<Pessoa> pessoas = pessoaControladorBD.listarPessoas();
            pessoas.removeAll(publicacao.getPessoas());
            request.setAttribute("lista_pessoas", pessoas);

            request.setAttribute("pessoas_selecionadas", publicacao.getPessoas());
        }
    }

    /**
     * Método responsável por salvar as alterações que a publicação teve
     *
     * @param request
     */
    private void salvarAlteracaoPublicacao(HttpServletRequest request)
    {
        Long id = Long.parseLong(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String resumo = request.getParameter("resumo");
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        Date dataPublicacao = Utilitarios.stringParaData(request.getParameter("dataPublicacao"));
        Date dataInclusao = Utilitarios.stringParaData(request.getParameter("dataInclusao"));
        String[] pessoas_selecionadas = request.getParameterValues("pessoas_selecionadas");
        Long[] ids = new Long[pessoas_selecionadas.length];
        for (int i = 0; i < pessoas_selecionadas.length; i++)
        {
            ids[i] = Long.valueOf(pessoas_selecionadas[i]);
        }
        List<Pessoa> pessoas = (new PessoaDAOImplementacao()).buscaPessoas(ids);

        Publicacao publicacao = controladorBD.retrieve(id);

        if (titulo != null)
        {
            publicacao.setTitulo(titulo);
        }

        if (resumo != null)
        {
            publicacao.setResumo(resumo);
        }

        if (dataInclusao != null)
        {
            publicacao.setDataInclusao(dataInclusao);
        }

        publicacao.setDataPublicacao(dataPublicacao);
        publicacao.setTipo(tipo);
        publicacao.setPessoas(pessoas);

        controladorBD.atualizar(publicacao);
    }

    /**
     * Método responsável por remover a publicação
     *
     * @param request
     */
    private void executarRemocaoPublicacao(HttpServletRequest request)
    {
        String idString = request.getParameter("id");
        if (idString != null)
        {
            Long id = Long.parseLong(idString);

            Publicacao publicacao = controladorBD.retrieve(id);

            if (publicacao != null)
            {
                controladorBD.deletar(publicacao);
            }
        }
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
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String pagina = "publicacao";
        String jsp = "/index.jsp";

        /* Verfica se está feito login */
        if (Utilitarios.sessaoEstaAtiva(request, "login"))
        {
            /* Acesso Administrativo */
            if (request.getRequestURI().endsWith("/novaPublicacao"))
            {
                novaPublicacao(request);
                Utilitarios.iniciarSinal(request);
                pagina = "novaPublicacao";
            }
            else if (request.getRequestURI().endsWith("/salvarPublicacao"))
            {
                if (Utilitarios.sinalOK(request))
                {
                    salvarPublicacao(request);
                    Utilitarios.apagarSinal(request);
                }
                listarPublicacoes(request);
            }
            else if (request.getRequestURI().endsWith("/alterarPublicacao"))
            {
                buscarPublicacaoId(request);
                pagina = "alterarPublicacao";
            }
            else if (request.getRequestURI().endsWith("/salvarAlteracaoPublicacao"))
            {
                salvarAlteracaoPublicacao(request);
                listarPublicacoes(request);
            }
            else if (request.getRequestURI().endsWith("removerPublicacao"))
            {
                buscarPublicacaoId(request);
                pagina = "removerPublicacao";
            }
            else if (request.getRequestURI().endsWith("executarRemocaoPublicacao"))
            {
                executarRemocaoPublicacao(request);
                listarPublicacoes(request);
            }
            else
            {
                listarPublicacoes(request);
            }
        }
        else
        {
            if (request.getRequestURI().endsWith("listarPublicacao"))
            {
                listarPublicacoes(request);
                pagina = "listarPublicacao";
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}

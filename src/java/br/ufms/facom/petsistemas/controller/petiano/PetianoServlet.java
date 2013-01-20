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
 * @author Rodrigo Kuninari
 */
public class PetianoServlet extends HttpServlet
{

    PetianoDAO controladorBD;

    /**
     * Método executado na inicialização da Classe
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException
    {
        controladorBD = new PetianoDAOImplementacao();
    }

    /**
     * Método responsável pela pesquisa de todos os petianos cadastrados
     *
     * @param request
     */
    private void listarPetianos(HttpServletRequest request)
    {
        List<Petiano> petianos = controladorBD.listarTodosPetianos();
        request.setAttribute("petianos", petianos);
    }

    /**
     * Método responsável pela criação de um novo petiano
     *
     * @param request
     */
    private void salvarPetiano(HttpServletRequest request)
    {
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
        String endereco = request.getParameter("endereco");
        String dataEnt = request.getParameter("dataEntrada");
        Date dataEntrada = Utilitarios.stringParaData(dataEnt);

        Petiano petiano = new Petiano(curso, nomePai, nomeMae, rg, cpf, dataEntrada, endereco, nome, dataNascimento, email, lattes, null);
        controladorBD.inserir(petiano);
        request.setAttribute("mensagem", "Petiano " + nome + " cadastrado com sucesso!");
    }

    private void buscarPetianoCPF(HttpServletRequest request)
    {

        String cpf = request.getParameter("cpf");
        Petiano petiano = controladorBD.buscarPetianoPeloCPF(cpf);

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
        response.setContentType("text/html;charset=UTF-8");
        String jsp = null;

        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/index"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/petiano"))
        {
            listarPetianos(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "petiano");
        }
        else if (request.getRequestURI().endsWith("/novoPetiano"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "novoPetiano");
        }
        else if (request.getRequestURI().endsWith("/salvarPetiano"))
        {
            salvarPetiano(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "salvarPetiano");
        }
        else if (request.getRequestURI().endsWith("/listarPetiano"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "petiano");
        }
        else if (request.getRequestURI().endsWith("/buscarPetiano"))
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "buscarPetiano");
        }
        else if (request.getRequestURI().endsWith("/exibirPetianoCPF"))
        {
            buscarPetianoCPF(request);
            jsp = "/index.jsp";
            request.setAttribute("pagina", "exibirPetianoCPF");
        }
        else
        {
            jsp = "/index.jsp";
            request.setAttribute("pagina", "petiano");
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

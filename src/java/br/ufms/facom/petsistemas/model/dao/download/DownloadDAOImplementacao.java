/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.download;



import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Arquivo;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.util.List;

/**
 * Classe parametrizada que implementa a interface DownloadDAO.
 *
 * @author Lillydi Cacere
 */
public class DownloadDAOImplementacao extends DAOImplementacao<Arquivo, Long> implements DownloadDAO
{
     @Override
    public Class<Arquivo> getDomainClass()
    {
        return Arquivo.class;
    }
      @Override
    public List<Arquivo> listarTodosDownloads()
    {
        List<Arquivo> download = retornarLista();
        return download;
    }
      
      @Override
    public List<Arquivo> buscarDownloadPeloTitulo(String titulo)
    {
        String namedQuery = "Arquivo.buscarDownloadPeloTitulo";
        ParametrosConsulta parametros = new ParametrosConsulta("titulo", titulo);
        List<Arquivo> downloads = executarNamedQuery(namedQuery, parametros);
        return downloads;
    }
      
      @Override
    public List<Arquivo> buscarDownloadPorCategoria(int categoria)
    {
        String namedQuery = "Arquivo.buscarDownloadPorCategoria";
        ParametrosConsulta parametros = new ParametrosConsulta("categoria", categoria);
        List<Arquivo> downloads = executarNamedQuery(namedQuery, parametros);
        return downloads;
    }
}
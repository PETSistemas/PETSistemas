/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.noticia;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Noticia;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.util.List;

/**
 * Classe parametrizada que implementa a interface NoticiaDAO.
 *
 * @author Rodrigo Kuninari
 */
public class NoticiaDAOImplementacao extends DAOImplementacao<Noticia, Long> implements NoticiaDAO
{

    @Override
    public Class<Noticia> getDomainClass()
    {
        return Noticia.class;
    }

    @Override
    public Noticia buscarNoticiaPeloTitulo(String titulo)
    {
        String namedQuery = "Noticia.buscarNoticiaPeloTitulo";
        ParametrosConsulta parametros = new ParametrosConsulta("titulo", titulo);
        Noticia noticia = (Noticia) executarNamedQuerySimples(namedQuery, parametros);
        return noticia;
    }

    @Override
    public List<Noticia> listarTodasNoticias()
    {
        List<Noticia> noticia = retornarLista();
        return noticia;
    }
}

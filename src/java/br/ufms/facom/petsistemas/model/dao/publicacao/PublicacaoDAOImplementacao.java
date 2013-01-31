/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.publicacao;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Publicacao;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.util.List;

/**
 * Classe parametrizada que implementa a interface PublicacaoDAO.
 *
 * @author Thiago
 */
public class PublicacaoDAOImplementacao extends DAOImplementacao<Publicacao, Long> implements PublicacaoDAO
{

    @Override
    public Class<Publicacao> getDomainClass()
    {
        return Publicacao.class;
    }

    @Override
    public Publicacao buscarPublicacaoPeloTitulo(String titulo)
    {
        String namedQuery = "Publicacao.buscarPublicacaoPeloTitulo";
        ParametrosConsulta parametros = new ParametrosConsulta("titulo", titulo);
        Publicacao publicacao = (Publicacao) executarNamedQuerySimples(namedQuery, parametros);
        return publicacao;
    }

    @Override
    public List<Publicacao> listarTodasPublicacoes()
    {
        List<Publicacao> publicacao = retornarLista();
        return publicacao;
    }
}

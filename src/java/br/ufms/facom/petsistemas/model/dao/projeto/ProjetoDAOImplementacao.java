/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.projeto;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Pessoa;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import br.ufms.facom.petsistemas.model.entity.Projeto;
import br.ufms.facom.petsistemas.model.util.GerenciadorEntidade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author daivid
 */
public class ProjetoDAOImplementacao extends DAOImplementacao<Projeto, Long> implements ProjetoDAO {

    @Override
    public Class<Projeto> getDomainClass() {
        return Projeto.class;
    }

    @Override
    public List<Projeto> buscarProjetoPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> buscarProjetoPorTipo(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> listarTodosProjetos() {
        return retornarLista();
    }

    @Override
    public List<Projeto> listarProjetosConcluidos() {
        String namedQuery = "Projeto.buscarProjetosAtivos";
        List<Projeto> projetos = executarNamedQuerySemParametro(namedQuery);
        return projetos;
    }

    @Override
    public List<Projeto> listarProjetosAtivos() {
        String namedQuery = "Projeto.buscarProjetosConcluidos";
        List<Projeto> projetos = executarNamedQuerySemParametro(namedQuery);
        return projetos;
    }
}

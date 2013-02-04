/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.projeto;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Pessoa;
import br.ufms.facom.petsistemas.model.entity.Projeto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    public List<Projeto> buscarProjetoPorDataDeInicio(Date inicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> buscarProjetoPorDataDeTermino(Date termino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> buscarProjetoPorTipo(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> buscarProjetoPorPessoa(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> listarTodosProjetos() {
        return retornarLista();
    }
    
}

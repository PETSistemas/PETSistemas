/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.projeto;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Pessoa;
import br.ufms.facom.petsistemas.model.entity.Projeto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author daivid
 */
public interface ProjetoDAO extends DAO<Projeto, Long> {
    public List<Projeto> buscarProjetoPorNome(String nome);
    public List<Projeto> buscarProjetoPorDataDeInicio(Date inicio);
    public List<Projeto> buscarProjetoPorDataDeTermino(Date termino);
    public List<Projeto> buscarProjetoPorTipo(int tipo);
    public List<Projeto> buscarProjetoPorPessoa(Pessoa pessoa);
    public List<Projeto> listarTodosProjetos();
}

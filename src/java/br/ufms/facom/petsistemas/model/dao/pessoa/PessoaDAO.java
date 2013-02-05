/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.pessoa;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Pessoa;
import java.util.List;

/**
 *
 * @author daivid
 */
public interface PessoaDAO extends DAO<Pessoa, Long> {
    public List<Pessoa> listarPessoas();
    public Pessoa buscaPessoa(Long id);
    public List<Pessoa> buscaPessoas(Long[] ids);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.pessoa;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daivid
 */
public class PessoaDAOImplementacao extends DAOImplementacao<Pessoa, Long> implements PessoaDAO {

    @Override
    public Class<Pessoa> getDomainClass() {
        return Pessoa.class;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return retornarLista();
    }

    @Override
    public Pessoa buscaPessoa(Long id) {
        return retrieve(id);
    }

    @Override
    public List<Pessoa> buscaPessoas(Long[] ids) {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (Long id : ids) {
            Pessoa pessoa = buscaPessoa(id);
            if (pessoa != null) {
                pessoas.add(pessoa);
            }
        }   
        if (pessoas.size() > 0) {
            return pessoas;
        }
        return null;
    }
    
}

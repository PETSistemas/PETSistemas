/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.petiano;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.util.List;

/**
 * Classe parametrizada que implementa a interface PetianoDAO.
 *
 * @author Rebecca Alves
 */
public class PetianoDAOImplementacao extends DAOImplementacao<Petiano, Long> implements PetianoDAO
{

    @Override
    public Class<Petiano> getDomainClass()
    {
        return Petiano.class;
    }

    @Override
    public Petiano buscarPetianoPeloCPF(String cpf)
    {
        String namedQuery = "Petiano.buscarPetianoPeloCPF";
        ParametrosConsulta parametros = new ParametrosConsulta("cpf", cpf);
        Petiano petiano = (Petiano) executarNamedQuerySimples(namedQuery, parametros);
        return petiano;
    }

    @Override
    public List<Petiano> listarTodosPetianos()
    {
        List<Petiano> petianos = retornarLista();
        return petianos;
    }

    @Override
    public List<Petiano> buscarPetianoPeloCurso(int curso)
    {
        String namedQuery = "Petiano.buscarPetianoPeloCurso";
        ParametrosConsulta parametros = new ParametrosConsulta("curso", curso);
        List<Petiano> petianos = executarNamedQuery(namedQuery, parametros);
        return petianos;
    }
    
    @Override
    public List<Petiano> buscarPetianoPelaSituacao(int situacao) {


        if (situacao == 1) {
            String namedQuery = "Petiano.buscarPetianoAtivo";
            List<Petiano> petianos = executarNamedQuerySemParametro(namedQuery);
            return petianos;
        }
        else {
            String namedQuery = "Petiano.buscarPetianoDesativo";
            List<Petiano> petianos = executarNamedQuerySemParametro(namedQuery);
            return petianos;
        }
    }

}

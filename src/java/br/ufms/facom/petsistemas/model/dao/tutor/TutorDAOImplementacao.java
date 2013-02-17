/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.tutor;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Tutor;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.util.List;

/**
 * Classe parametrizada que implementa a interface PetianoDAO.
 *
 * @author Bruno Monteiro
 */
public class TutorDAOImplementacao extends DAOImplementacao<Tutor, Long> implements TutorDAO
{

    @Override
    public Class<Tutor> getDomainClass()
    {
        return Tutor.class;
    }

    @Override
    public Tutor buscarTutorPeloCPF(String cpf)
    {
        String namedQuery = "Tutor.buscarTutorPeloCPF";
        ParametrosConsulta parametros = new ParametrosConsulta("cpf", cpf);
        Tutor tutor = (Tutor) executarNamedQuerySimples(namedQuery, parametros);
        return tutor;
    }

    @Override
    public List<Tutor> listarTodosTutores()
    {
        List<Tutor> tutores = retornarLista();
        return tutores;
    }

        public List<Tutor> buscarTutorPelaSituacao(int situacao) {

        if (situacao == 1) {
            String namedQuery = "Tutor.buscarTutorAtivo";
            List<Tutor> tutores = executarNamedQuerySemParametro(namedQuery);
            return tutores;
        }
        else {
            String namedQuery = "Tutor.buscarTutorDesativo";
            List<Tutor> tutores = executarNamedQuerySemParametro(namedQuery);
            return tutores;
        }
    }

}

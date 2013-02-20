/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.colaborador;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Colaborador;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.util.List;

/**
 * Classe parametrizada que implementa a interface ColaboradorDAO.
 *
 * @author Rodrigo Kuninari
 */
public class ColaboradorDAOImplementacao extends DAOImplementacao<Colaborador, Long> implements ColaboradorDAO {

    @Override
    public Class<Colaborador> getDomainClass() {
        return Colaborador.class;
    }

    @Override
    public Colaborador buscarColaboradorPeloCPF(String cpf) {
        String namedQuery = "Colaborador.buscarColaboradorPeloCPF";
        ParametrosConsulta parametros = new ParametrosConsulta("cpf", cpf);
        Colaborador colaborador = (Colaborador) executarNamedQuerySimples(namedQuery, parametros);
        return colaborador;
    }

    @Override
    public List<Colaborador> listarTodosColaboradores() {
        List<Colaborador> colaboradores = retornarLista();
        return colaboradores;
    }

    public List<Colaborador> buscarColaboradorPelaSituacao(int situacao) {


        if (situacao == 1) {
            String namedQuery = "Colaborador.buscarColaboradorAtivo";
            List<Colaborador> colaboradores = executarNamedQuerySemParametro(namedQuery);
            return colaboradores;
        } else {
            String namedQuery = "Colaborador.buscarColaboradorDesativo";
            List<Colaborador> colaboradores = executarNamedQuerySemParametro(namedQuery);
            return colaboradores;
        }
    }
}

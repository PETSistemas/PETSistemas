package br.ufms.facom.petsistemas.model.dao;

import br.ufms.facom.petsistemas.model.util.GerenciadorEntidade;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Classe abstrata parametrizada que implementa a interface DAO.
 *
 * @author Rodrigo Kuninari
 */
public abstract class DAOImplementacao<T, ID extends Serializable> implements DAO<T, ID>, Serializable {

    /**
     * Metodo para retornar a classe do parametro T
     *
     * @return Classe especificada por T
     */
    public abstract Class<T> getDomainClass();

    public EntityManager getEntityManager() {
        return GerenciadorEntidade.getEntityManager();
    }

    @Override
    public void inserir(T obj) {
        GerenciadorEntidade.inserir(obj);

    }

    @Override
    public T retrieve(ID id) {
        return (T) getEntityManager().find(getDomainClass(), id);

    }

    @Override
    public List<T> retornarLista() {
        String queryS = "SELECT obj FROM " + getDomainClass().getSimpleName() + " obj";
        Query query = GerenciadorEntidade.criarConsulta(queryS);

        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public T deletar(T obj) {
        obj = (T) GerenciadorEntidade.atualizar(obj);
        GerenciadorEntidade.remover(obj);

        return obj;

    }

    @Override
    public T atualizar(T obj) {
        T objReturn = null;

        if (obj != null) {
            objReturn = (T) GerenciadorEntidade.atualizar(obj);
        }

        return objReturn;
    }

    @Override
    public Query criarConsulta(String query) {
        return GerenciadorEntidade.criarConsulta(query);
    }

    @Override
    public Query criarNamedQuery(String query) {
        return GerenciadorEntidade.criarNamedQuery(query);
    }

    @Override
    public T executarConsultaSimples(ParametrosConsulta parameter) {
        String sql = "SELECT o FROM " + getDomainClass().getSimpleName()
                + "AS o WHERE o." + parameter.getName() + " = :" + parameter.getValue();
        Query query = criarConsulta(sql);
        query.setParameter(parameter.getName(), parameter.getValue());

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<T> executarNamedQuerySemParametro(String namedQuery) {
        Query query = criarNamedQuery(namedQuery);

        try {
            return (List<T>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<T> executarNamedQuery(String namedQuery, ParametrosConsulta parameter) {
        Query query = criarNamedQuery(namedQuery);
        query.setParameter(parameter.getName(), parameter.getValue());

        try {
            return (List<T>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public T executarNamedQuerySimples(String namedQuery, ParametrosConsulta parameter) {
        Query query = criarNamedQuery(namedQuery);
        query.setParameter(parameter.getName(), parameter.getValue());

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public T executarNamedQuerySimplesSemParametro(String namedQuery) {
        Query query = criarNamedQuery(namedQuery);

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public T executarConsulta(String sql) {
        Query query = criarConsulta(sql);

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @PreDestroy
    @Override
    public void finalizeAccess() {
        GerenciadorEntidade.close();
    }
}

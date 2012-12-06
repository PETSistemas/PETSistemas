package br.ufms.facom.petsistemas.model.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Singleton que realiza as operacoes basicas para persistencia dos dados no
 * banco. Inicializa uma EntityManager a partir da unidade de persistencia
 * declarada no parâmetro do método Persistence.createEntityManagerFactory.
 *
 * @author Rodrigo Kuninari
 */
public class GerenciadorEntidade
{

    private static EntityManagerFactory emf;

    private static EntityManager em;

    @PostConstruct
    public static void init()
    {
        if (!estaDisponivel())
        {
            emf = Persistence.createEntityManagerFactory("PETSistemasPU");
            em = emf.createEntityManager();
        }
    }

    /**
     * Metodo para retornar a EntityManager criada
     *
     * @return EntityManager criada a partir da unidade de persistencia
     */
    public static EntityManager getEntityManager()
    {
        init();
        return em;
    }

    /**
     * Metodo para iniciar uma transacao no banco. Necessaria para operacoes
     * transacionais.
     */
    public static void iniciarTransacao()
    {
        init();
        if (!verificarTransacao())
        {
            em.getTransaction().begin();
        }
    }

    /**
     * Metodo para verificar se a transacao esta ativa.
     *
     * @return True caso esteja ativa a transacao. False caso contrario.
     */
    public static boolean verificarTransacao()
    {
        init();
        return em.getTransaction().isActive();
    }

    /**
     * Metodo para dar commit na transacao.
     */
    public static void commit()
    {
        init();
        em.getTransaction().commit();
    }

    /**
     * Metodo para inserir um novo objeto no banco.
     *
     * @param obj Objeto a ser inserido
     */
    public static void inserir(Object obj)
    {
        init();
        iniciarTransacao();
        em.persist(obj);
        commit();
    }

    /**
     * Metodo para criar uma query a ser executada no banco.
     *
     * @param query String que representa a query
     * @return Query criada
     */
    public static Query criarConsulta(String query)
    {
        init();
        return em.createQuery(query);
    }

    /**
     * Metodo para criar uma NamedQuery a ser executada no banco.
     *
     * @param namedQuery String com a NamedQuery a ser criada
     * @return Query criada
     */
    public static Query criarNamedQuery(String namedQuery)
    {
        init();
        return em.createNamedQuery(namedQuery);
    }

    /**
     * Metodo para atualizar um determinado objeto no banco.
     *
     * @param obj Objeto a ser atualizado
     * @return Objeto atualizado
     */
    public static Object atualizar(Object obj)
    {
        init();
        iniciarTransacao();
        Object object = em.merge(obj);
        commit();
        return object;
    }

    /**
     * Metodo para remover um determinado objeto do banco.
     *
     * @param obj Objeto a ser removido.
     */
    public static void remover(Object obj)
    {
        init();
        iniciarTransacao();
        em.remove(obj);
        commit();
    }

    @PreDestroy
    public static void close()
    {
        if (em.isOpen())
        {
            em.close();
        }

        if (emf.isOpen())
        {
            emf.close();
        }
    }

    private static boolean estaDisponivel()
    {
        if (emf != null)
        {
            return emf.isOpen();
        }

        return false;
    }

}

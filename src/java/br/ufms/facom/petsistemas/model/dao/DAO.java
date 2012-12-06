/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao;

import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 * DAO - Data Access Object. Interface que descreve a assinatura da operacoes
 * basicas que cada entidade do banco ira realizar. Operacoes do CRUD.
 *
 * @author Rodrigo Kuninari
 */
public interface DAO<T, ID extends Serializable>
{

    /**
     * Metodo para inserir um novo objeto do tipo T no banco.
     *
     * @param obj Objeto a ser inserido no banco.
     */
    public void inserir(T obj);

    /**
     * Metodo para consultar um objeto especificado pela id.
     *
     * @param id Identificacao do objeto.
     * @return Objeto consultado.
     */
    public T retrieve(ID id);

    /**
     * Metodo para atualizar um objeto no banco.
     *
     * @param obj
     * @return Objeto atualizado.
     */
    public T atualizar(T obj);

    /**
     * Método para deletar um objeto no banco.
     *
     * @param obj
     * @return
     */
    public T deletar(T obj);

    /**
     * Metodo para listar todos os objetos do tipo T contidos no banco.
     *
     * @return Lista contendo objetos do tipo T.
     */
    public List<T> retornarLista();

    /**
     * Método responsável pela criação de um Objeto do tipo Query.
     *
     * @param query String com a Query (Consulta) a ser criada.
     * @return Objeto Query contendo a consulta.
     */
    public Query criarConsulta(String query);

    /**
     * Método responsável pela criação de um Objeto do tipo Query (NamedQuery).
     *
     * @param query String com a Query (Consulta) a ser criada.
     * @return Objeto Query contendo a consulta.
     */
    public Query criarNamedQuery(String query);

    /**
     * Método responsável pela execução de uma consulta simples no banco de
     * dados.
     *
     * @param parameter Objeto do tipo ParametrosConsulta contendo o nome e
     * valor do parâmetro.
     * @return Objeto resultante da consulta.
     */
    public T executarConsultaSimples(ParametrosConsulta parameter);

    /**
     * Método responsável pela execução de uma NamedQuery no banco de dados.
     *
     * @param namedQuery String com o nome da NamedQuery a ser executada.
     * @param parameter bjeto do tipo ParametrosConsulta contendo o nome e valor
     * do parâmetro.
     * @return Objeto resultante da consulta.
     */
    public List<T> executarNamedQuery(String namedQuery, ParametrosConsulta parameter);

    /**
     * Método responsável pela execução de uma NamedQuery no banco de dados.
     *
     * @param namedQuery String com o nome da NamedQuery a ser executada.
     * @param parameter bjeto do tipo ParametrosConsulta contendo o nome e valor
     * do parâmetro.
     * @return Lista contendo os Objetos resultantes da consulta.
     */
    public T executarNamedQuerySimples(String namedQuery, ParametrosConsulta parameter);

    /**
     * Método responsável pela execução de uma Consulta SQL.
     *
     * @param sql String contendo a SQL a ser executada.
     * @return Objeto resultante da consulta.
     */
    public T executarConsulta(String sql);

    public void finalizeAccess();

}

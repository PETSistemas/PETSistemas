/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.tutor;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Tutor;
import java.util.List;

/**
 * DAO - Data Access Object. Interface que descreve a assinatura da operações
 * básicas que a Entidade Petiano irá realizar no Banco de Dados. Operacoes do
 * CRUD.
 *
 * @author Bruno Monteiro
 */
public interface TutorDAO extends DAO<Tutor, Long> {

    /**
     * Método responsável por consultar um Tutor através do CPF.
     *
     * @param cpf String contendo o CPF do Tutor a ser consultado.
     * @return Objeto do tipo Tutor resultante da consulta.
     */
    public Tutor buscarTutorPeloCPF(String cpf);

    /**
     * Método responsável por consultar todos os Tutores.
     *
     * @return Lista de Objeto do tipo Tutor resultante da consulta.
     */
    public List<Tutor> listarTodosTutores();

     /**
     * Método responsável por consultar todos os Petianos com uma determinada
     * situação
     *
     * @param situacao Inteiro que representa 1 para ativo e qualquer outro
     * número, desativo Quando ativo, Petiano possui uma data de saída. Quando
     * Desativo, Petiano não possui data de saída nula
     * @return
     */
    public List<Tutor> buscarTutorPelaSituacao(int situacao);
}

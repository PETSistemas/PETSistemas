/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.petiano;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import java.util.List;

/**
 * DAO - Data Access Object. Interface que descreve a assinatura da operações
 * básicas que a Entidade Petiano irá realizar no Banco de Dados. Operacoes do
 * CRUD.
 *
 * @author Rodrigo Kuninari
 */
public interface PetianoDAO extends DAO<Petiano, Long>
{

    /**
     * Método responsável por consultar um Petiano através do CPF.
     *
     * @param cpf String contendo o CPF do Petiano a ser consultado.
     * @return Objeto do tipo Petiano resultante da consulta.
     */
    public Petiano buscarPetianoPeloCPF(String cpf);

    /**
     * Método responsável por consultar todos os Petianos.
     *
     * @return Lista de Objeto do tipo Petiano resultante da consulta.
     */
    public List<Petiano> listarTodosPetianos();

    /**
     * Método responsável por consultar todos os Petianos de um determinado
     * curso.
     *
     * @param curso Inteiro representando o curso a ser consultado.
     * @return Lista de Objeto do tipo Petiano resultante da consulta.
     */
    public List<Petiano> buscarPetianoPeloCurso(int curso);

}

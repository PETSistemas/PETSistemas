/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.colaborador;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Colaborador;
import java.util.List;

/**
 * DAO - Data Access Object. Interface que descreve a assinatura da operações
 * básicas que a Entidade Colaborador irá realizar no Banco de Dados. Operacoes
 * do CRUD.
 *
 * @author Rodrigo Kuninari
 */
public interface ColaboradorDAO extends DAO<Colaborador, Long> {

    /**
     * Método responsável por consultar um Colaborador através do CPF.
     *
     * @param cpf String contendo o CPF do Colaborador a ser consultado.
     * @return Objeto do tipo Colaborador resultante da consulta.
     */
    public Colaborador buscarColaboradorPeloCPF(String cpf);

    /**
     * Método responsável por consultar todos os Colaboradores.
     *
     * @return Lista de Objeto do tipo Colaborador resultante da consulta.
     */
    public List<Colaborador> listarTodosColaboradores();

    /**
     * Método responsável por consultar todos os Colaboradores com uma
     * determinada situação
     *
     * @param situacao Inteiro que representa 1 para ativo e qualquer outro
     * número, desativo Quando ativo, Colaborador possui uma data de saída.
     * Quando Desativo, Colaborador não possui data de saída nula
     * @return
     */
    public List<Colaborador> buscarColaboradorPelaSituacao(int situacao);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.noticia;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Noticia;
import java.util.List;

/**
 * DAO - Data Access Object. Interface que descreve a assinatura da operações
 * básicas que a Entidade Noticia irá realizar no Banco de Dados. Operacoes do
 * CRUD.
 *
 * @author Rodrigo Kuninari
 */
public interface NoticiaDAO extends DAO<Noticia, Long>
{

    /**
     * Método responsável por consultar um Noticia através do CPF.
     *
     * @param cpf String contendo o Título da Noticia a ser consultada.
     * @return Objeto do tipo Noticia resultante da consulta.
     */
    public Noticia buscarNoticiaPeloTitulo(String titulo);

    /**
     * Método responsável por consultar todas as Noticias.
     *
     * @return Lista de Objeto do tipo Noticia resultante da consulta.
     */
    public List<Noticia> listarTodasNoticias();
}

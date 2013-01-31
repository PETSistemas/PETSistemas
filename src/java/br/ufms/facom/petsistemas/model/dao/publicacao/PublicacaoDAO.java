/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.publicacao;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Publicacao;
import java.util.List;

/**
 * DAO - Data Access Object. Interface que descreve a assinatura da operações
 * básicas que a Entidade Noticia irá realizar no Banco de Dados. Operacoes do
 * CRUD.
 * 
 * @author Thiago
 */
public interface  PublicacaoDAO extends DAO<Publicacao, Long> {
    
    /**
     * Método responsável por consultar uma publicação através do título
     * 
     * @param titulo
     * @return Objeto do tipo Publicacao resultante da consulta
     */
    public Publicacao buscarPublicacaoPeloTitulo(String titulo);
    
    /**
     * Método responsável por consultar todas as Publicações.
     *
     * @return Lista de Objeto do tipo Publicação resultante da consulta.
     */
    public List<Publicacao> listarTodasPublicacoes();
    
}

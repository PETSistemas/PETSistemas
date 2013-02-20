/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.download;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Arquivo;
import java.util.List;

/**
 * DAO - Data Access Object. Interface que descreve a assinatura da operações
 * básicas que a Entidade Petiano irá realizar no Banco de Dados. Operacoes do
 * CRUD.
 *
 */
public interface DownloadDAO extends DAO<Arquivo, Long> {

public List<Arquivo> listarTodosDownloads();

public List<Arquivo> buscarDownloadPeloTitulo(String titulo);
public List<Arquivo> buscarDownloadPorCategoria(int categoria);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.download;



import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Arquivo;
import br.ufms.facom.petsistemas.model.util.ParametrosConsulta;
import java.util.List;

/**
 * Classe parametrizada que implementa a interface PetianoDAO.
 *
 * @author Rodrigo Kuninari
 */
public class DownloadDAOImplementacao extends DAOImplementacao<Arquivo, Long> implements DownloadDAO
{
     @Override
    public Class<Arquivo> getDomainClass()
    {
        return Arquivo.class;
    }
}
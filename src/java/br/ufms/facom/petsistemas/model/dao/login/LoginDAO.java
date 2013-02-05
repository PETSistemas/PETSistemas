/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.login;

import br.ufms.facom.petsistemas.model.dao.DAO;
import br.ufms.facom.petsistemas.model.entity.Login;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import br.ufms.facom.petsistemas.model.entity.Tutor;

/**
 *
 * @author Rebecca
 */
public interface LoginDAO extends DAO<Login, Long> {
    
    
    public Boolean logarUsuario(String usuario, String senha, Petiano petiano, Tutor tutor);
    
    
}

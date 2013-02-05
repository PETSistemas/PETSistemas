/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.dao.login;

import br.ufms.facom.petsistemas.model.dao.DAOImplementacao;
import br.ufms.facom.petsistemas.model.entity.Login;
import br.ufms.facom.petsistemas.model.entity.Petiano;
import br.ufms.facom.petsistemas.model.entity.Tutor;

/**
 *
 * @author Rebecca
 */
public class LoginDAOImplementacao extends DAOImplementacao<Login, Long> implements LoginDAO {

    @Override
    public Class<Login> getDomainClass() {
        return Login.class;
    }

    @Override
    public Boolean logarUsuario(String usuario, String senha, Petiano petiano, Tutor tutor) {

        if (petiano != null) {
            Login login = new Login(usuario, senha);
            if ((petiano.getSenha()).equals(login.getSenha())) {
                System.setProperty("login", usuario);
                System.setProperty("senha", senha);
                return true;
            }
            return false;
        } else if (tutor != null) {
            /*  Login login = new Login(usuario, senha);
             if ((tutor.getSenha()).equals(login.getSenha())) {
             return true;
             }*/
            return false;
        } else {
            return false;

        }
    }
}

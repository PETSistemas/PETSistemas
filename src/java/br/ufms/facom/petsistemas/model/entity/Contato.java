/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Contato {

    SimpleEmail email = new SimpleEmail();
    String userMail = "petsistemasufms@gmail.com";
    String userName = "petsistemasufms";
    String userPassword = "petsistemas2010";

    public void envia(String mensagem) {
        try {
            email.setHostName("smtp.gmail.com");
            email.setFrom(userMail);

            email.setMsg(mensagem);
            email.setSubject("Contato");

            email.setSSL(true);
            email.setTLS(true); // utiliza TLS na encriptação    
            email.setSmtpPort(465);
            email.setAuthentication(userName, userPassword);

            email.addTo(userMail);
            email.send();
//           System.out.print("Email enviado com sucesso!");     
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
}

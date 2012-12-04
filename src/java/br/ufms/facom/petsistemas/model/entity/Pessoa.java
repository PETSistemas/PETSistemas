/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.util.Date;

/**
 *
 * @author Rodrigo Kuninari
 */
public class Pessoa
{

    private Long id;

    private Date dataNascimento;

    private String email;

    private String linkLattes;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLinkLattes()
    {
        return linkLattes;
    }

    public void setLinkLattes(String linkLattes)
    {
        this.linkLattes = linkLattes;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * Classe abstrata que representa a Entidade Pessoa. Seus atributos irão ser
 * criados nas Entidades Filhas.
 *
 * @author Rodrigo Kuninari
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "nome", updatable = true, nullable = false, length = 60)
    private String nome;

    @Column(name = "dataNascimento", updatable = true, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "email", updatable = true, nullable = false, length = 60)
    private String email;

    @Column(name = "linkLattes", updatable = true, nullable = false, length = 100)
    private String linkLattes;

    @OneToOne
    @JoinColumn(name = "arquivo", updatable = true, nullable = true)
    private Arquivo arquivo;

    public Pessoa()
    {
    }

    public Pessoa(String nome, Date dataNascimento, String email, String linkLattes, Arquivo arquivo)
    {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.linkLattes = linkLattes;
        this.arquivo = arquivo;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
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

    public Arquivo getArquivo()
    {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo)
    {
        this.arquivo = arquivo;
    }

}

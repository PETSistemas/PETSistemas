/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_PESSOA")
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(name = "nome", updatable = true, nullable = false, length = 60)
    private String nome;
    @Column(name = "cpf", updatable = false, nullable = false, length = 14)
    private String cpf;
    @Column(name = "dataNascimento", updatable = true, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "dataNascimentoFormatada", updatable = false, nullable = false)
    private String dataNascimentoFormatada;
    @Column(name = "email", updatable = true, nullable = false, length = 60)
    private String email;
    @Column(name = "linkLattes", updatable = true, nullable = false, length = 100)
    private String linkLattes;
    @OneToOne
    @JoinColumn(name = "arquivo", updatable = true, nullable = true)
    private Arquivo arquivo;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, Date dataNascimento, String email, String linkLattes, Arquivo arquivo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.linkLattes = linkLattes;
        this.arquivo = arquivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkLattes() {
        return linkLattes;
    }

    public void setLinkLattes(String linkLattes) {
        this.linkLattes = linkLattes;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public String getDataNascimentoFormatada() {
        return dataNascimentoFormatada;
    }

    public void setDataNascimentoFormatada(String dataNascimentoFormatada) {
        this.dataNascimentoFormatada = dataNascimentoFormatada;
    }
    
    
}

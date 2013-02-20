/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Classe que representa a Entidade Tutor. Herda atributos e métodos da Classe
 * Pessoa.
 *
 * @author Bruno Monteiro
 */
@Entity
@DiscriminatorValue("T")
@Table(name = "TUTOR")
@NamedQueries({
    @NamedQuery(name = "Tutor.buscarTutorPeloNome", query = "SELECT p FROM Tutor AS p WHERE p.nome like :nome ORDER BY p.nome"),
    @NamedQuery(name = "Tutor.buscarTutorPeloCPF", query = "SELECT p FROM Tutor AS p WHERE p.cpf = :cpf ORDER BY p.nome"),
    @NamedQuery(name = "Tutor.buscarTutorAtivo", query = "SELECT p FROM Tutor AS p WHERE p.dataSaida is null"),
    @NamedQuery(name = "Tutor.buscarTutorDesativo", query = "SELECT p FROM Tutor AS p WHERE p.dataSaida is not null")
})
public class Tutor extends Pessoa implements Serializable {

    @Column(name = "rg", updatable = false, nullable = false, length = 30)
    private String rg;
    @Column(name = "senha", updatable = false, nullable = false, length = 30)
    private String senha;
    @Column(name = "dataEntrada", updatable = false, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "dataEntradaFormatada", updatable = true, nullable = false)
    private String dataEntradaFormatada;
    @Column(name = "dataSaida", updatable = false, nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSaida;
    @Column(name = "dataSaidaFormatada", updatable = true, nullable = false)
    private String dataSaidaFormatada;
    @OneToMany(mappedBy = "tutor")
    private List<Noticia> noticias;

    public Tutor() {
    }

    public Tutor(String senha, String rg, String cpf, Date dataEntrada, Date dataSaida, String nome, Date dataNascimento, String email, String linkLattes, Arquivo arquivo) {
        super(nome, cpf, dataNascimento, email, linkLattes, arquivo);
        this.rg = rg;
        this.senha = senha;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public String getDataEntradaFormatada() {
        return dataEntradaFormatada;
    }

    public void setDataEntradaFormatada(String dataEntradaFormatada) {
        this.dataEntradaFormatada = dataEntradaFormatada;
    }

    public String getDataSaidaFormatada() {
        return dataSaidaFormatada;
    }

    public void setDataSaidaFormatada(String dataSaidaFormatada) {
        this.dataSaidaFormatada = dataSaidaFormatada;
    }
}

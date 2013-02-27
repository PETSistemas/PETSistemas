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
 * Classe que representa a Entidade Petiano. Herda atributos e métodos da Classe
 * Pessoa.
 *
 * @author Rebecca Alves
 */
@Entity
@DiscriminatorValue("P")
@Table(name = "PETIANO")
@NamedQueries({
    @NamedQuery(name = "Petiano.buscarPetianoPeloNome", query = "SELECT p FROM Petiano AS p WHERE p.nome like :nome ORDER BY p.nome"),
    @NamedQuery(name = "Petiano.buscarPetianoPeloCPF", query = "SELECT p FROM Petiano AS p WHERE p.cpf = :cpf ORDER BY p.nome"),
    @NamedQuery(name = "Petiano.buscarPetianoPeloCurso", query = "SELECT p FROM Petiano AS p WHERE p.curso = :curso ORDER BY p.nome"),
    @NamedQuery(name = "Petiano.buscarPetianoAtivo", query = "SELECT p FROM Petiano AS p WHERE p.dataSaida is null"),
    @NamedQuery(name = "Petiano.buscarPetianoDesativo", query = "SELECT p FROM Petiano AS p WHERE p.dataSaida is not null")
})
public class Petiano extends Pessoa implements Serializable {

    @Column(name = "curso", updatable = true, nullable = false)
    private int curso;
    @Column(name = "nomePai", updatable = true, nullable = false, length = 60)
    private String nomePai;
    @Column(name = "nomeMae", updatable = true, nullable = false, length = 60)
    private String nomeMae;
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
    @Column(name = "dataSaidaFormatada", updatable = true, nullable = true)
    private String dataSaidaFormatada;
    @Column(name = "endereco", updatable = false, nullable = false, length = 250)
    private String endereco;
    @OneToMany(mappedBy = "petiano")
    private List<Noticia> noticias;

    public Petiano() {
    }

    public Petiano(int curso, String senha, String nomePai, String nomeMae, String rg, String cpf, Date dataEntrada, Date dataSaida, String endereco, String nome, Date dataNascimento, String email, String linkLattes, Arquivo arquivo) {
        super(nome, cpf, dataNascimento, email, linkLattes, arquivo);
        this.curso = curso;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.rg = rg;
        this.senha = senha;
        this.dataEntrada = dataEntrada;
        this.endereco = endereco;
        this.dataSaida = dataSaida;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

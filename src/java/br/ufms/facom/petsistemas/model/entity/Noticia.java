/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Classe que representa a Entidade Noticia
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "NOTICIA")
@NamedQueries(
{
    @NamedQuery(name = "Noticia.buscarNoticiaPeloTitulo", query = "SELECT n FROM Noticia AS n WHERE n.titulo LIKE :titulo ORDER BY n.titulo")
})
public class Noticia implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "titulo", updatable = true, nullable = false, length = 60)
    private String titulo;

    @Column(name = "conteudo", updatable = true, nullable = false, length = 255)
    private String conteudo;

    @Column(name = "dataInicial", updatable = true, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicial;

    @Column(name = "dataFinal", updatable = true, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFinal;

    @Column(name = "tipo", updatable = true, nullable = false)
    private int tipo;

    @JoinColumn(name = "petiano", updatable = true, nullable = true)
    @ManyToOne
    private Petiano petiano;

    public Noticia()
    {
    }

    public Noticia(String titulo, String conteudo, Date dataInicial, Date dataFinal, int tipo, Petiano petiano)
    {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.tipo = tipo;
        this.petiano = petiano;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getConteudo()
    {
        return conteudo;
    }

    public void setConteudo(String conteudo)
    {
        this.conteudo = conteudo;
    }

    public Date getDataInicial()
    {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial)
    {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal()
    {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal)
    {
        this.dataFinal = dataFinal;
    }

    public int getTipo()
    {
        return tipo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public Petiano getPetiano()
    {
        return petiano;
    }

    public void setPetiano(Petiano petiano)
    {
        this.petiano = petiano;
    }
}

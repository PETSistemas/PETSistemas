/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import br.ufms.facom.petsistemas.model.dao.download.DownloadDAO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Classe que representa a entidade Publicação
 *
 * @author Thiago
 */
@Entity
@Table(name = "PUBLICACAO")
@NamedQueries(
{
    @NamedQuery(name = "Publicacao.buscarPublicacaoPeloTitulo", query = "SELECT p FROM Publicacao AS p WHERE p.titulo = :titulo ORDER BY p.titulo")
})
public class Publicacao implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "titulo", updatable = true, nullable = false, unique = true)
    private String titulo;

    @Column(name = "resumo", updatable = true, nullable = false, unique = false)
    private String resumo;

    @Column(name = "tipo", updatable = true, nullable = false, unique = false)
    private int tipo;

    @Column(name = "dataPublicacao", updatable = true, nullable = true, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPublicacao;

    @Column(name = "dataInclusao", updatable = true, nullable = false, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInclusao;
    
    @ManyToMany
    private List<Pessoa> autores;
    
    @OneToOne
    @JoinColumn(name = "arquivo")
    private Arquivo arquivo;

    public Publicacao()
    {
    }

    public Publicacao(String titulo, String resumo, int tipo, Date dataPublicacao, Date dataInclusao)
    {
        this.titulo = titulo;
        this.resumo = resumo;
        this.tipo = tipo;
        this.dataPublicacao = dataPublicacao;
        this.dataInclusao = dataInclusao;
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

    public String getResumo()
    {
        return resumo;
    }

    public void setResumo(String resumo)
    {
        this.resumo = resumo;
    }

    public int getTipo()
    {
        return tipo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public Date getDataPublicacao()
    {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao)
    {
        this.dataPublicacao = dataPublicacao;
    }

    public Date getDataInclusao()
    {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao)
    {
        this.dataInclusao = dataInclusao;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Classe que representa a Entidade Arquivo.
 *
 * @author Rodrigo Kuninari
 */
@DiscriminatorValue("A")
@NamedQueries({
    @NamedQuery(name = "Arquivo.buscarDownloadPorCategoria", query = "SELECT a FROM Arquivo AS a WHERE a.categoria = :categoria ORDER BY a.categoria"),
    @NamedQuery(name = "Arquivo.buscarDownloadPeloTitulo", query = "SELECT a FROM Arquivo AS a WHERE a.titulo like :titulo ORDER BY a.titulo"),
})

@Entity
@Table(name = "ARQUIVO")
public class Arquivo implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Lob
    @Column(name = "anexo", updatable = true, nullable = false, columnDefinition="mediumblob" )
    private byte[] anexo;

    @Column(name = "dataCriacao", updatable = false, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCriacao;

    @Column(name = "tamanho", updatable = true, nullable = false)
    private long tamanho;

    @Column(name = "titulo", updatable = true, nullable = false)
    private String titulo;

    @Column(name = "categoria", updatable = true, nullable = false)
    private int categoria;

    @Column(name = "tipo", updatable = true, nullable = false)
    private int tipo;

   @Column(name = "nome", updatable = true, nullable = false)
    private String nome;

   
    
     public Arquivo()
     {
     }
   public Arquivo(String titulo, int categoria, Date data, long tamanho, int tipo, byte[] anexo, String nome) {
       this.titulo = titulo;
       this.categoria = categoria;
       this.dataCriacao = data;
       this.tamanho = tamanho;
       this.tipo = tipo;
       this.anexo = anexo;
       this.nome = nome;
       
   }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public long getTamanho()
    {
        return tamanho;
    }

    public void setTamanho(long tamanho)
    {
        this.tamanho = tamanho;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public int getCategoria()
    {
        return categoria;
    }

    public void setCategoria(int categoria)
    {
        this.categoria = categoria;
    }

    public int getTipo()
    {
        return tipo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

   // public Pessoa getPessoa()
   // {
   //     return pessoa;
   // }

   // public void setPessoa(Pessoa pessoa)
   // {
   //     this.pessoa = pessoa;
   // }

}

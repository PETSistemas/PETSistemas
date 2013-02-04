/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author daivid
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Projeto.buscarProjetoPorNome", query = "Select p From Projeto p Where p.nome LIKE '%:nome%'"),
        @NamedQuery(name = "Projeto.buscarProjetoPorTipo", query = "Select p From Projeto p Where p.tipo = :tipo")
})
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nome;
    
    @Column(length = 100)
    private String resumo;
    
    @Column(nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    
    @Column(nullable = true, updatable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataTermino;
    
    private int tipo;
    
    @ManyToMany
    private List<Pessoa> pessoas;
    
    @OneToOne
    @JoinColumn(updatable = true, nullable = true)
    private Arquivo arquivo;
    
    public Projeto() {}
     
    
    public Projeto(String nome, int tipo, String resumo, Date inicio, Date termino, Arquivo arquivo) {
        this.nome = nome;
        this.tipo = tipo;
        this.resumo = resumo;
        this.arquivo = arquivo;
        this.dataInicio = inicio;
        this.dataTermino = termino;
        this.pessoas = new ArrayList<Pessoa>();
        
    }
    
    /**
     * Builder de Projetos --> Talvez seja legal usar isso =)
     */
    public static class Builder {
        Projeto projeto;
        public Builder(String nome, int tipo, Date inicio) {
            projeto = new Projeto();
            projeto.setNome(nome);
            projeto.setDataInicio(inicio);
            projeto.setTipo(tipo);
            projeto.setArquivo(null);
            projeto.setDataTermino(null);
        }
        
        public Builder nome(String nome) {
            projeto.setNome(nome);
            return this;
        }
        
        public Builder resumo(String resumo) {
            projeto.setResumo(resumo);
            return this;
        }
        
        public Builder pessoas(List<Pessoa> pessoas) {
            projeto.addPessoas(pessoas);
            return this;
        }
        
        public Builder tipo(int tipo) {
            projeto.setTipo(tipo);
            return this;
        }
        
        public Builder dataInicio(Date inicio) {
            projeto.setDataInicio(inicio);
            return this;
        }
        
        public Builder dataTermino(Date termino) {
            projeto.setDataTermino(termino);
            return this;
        }
        
        public Builder arquivo(Arquivo arquivo) {
            projeto.setArquivo(arquivo);
            return this;
        }
        
        public Projeto build() {
            return projeto;
        }
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void addPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
    
    public void addPessoas(List<Pessoa> pessoas) {
        if (this.pessoas == null) {
            this.pessoas = new ArrayList<Pessoa>();
        }
        this.pessoas.addAll(pessoas);
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
      
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projeto)) {
            return false;
        }
        Projeto other = (Projeto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}

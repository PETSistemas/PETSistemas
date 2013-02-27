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
 * Classe que representa a Entidade Colaborador. Herda atributos e métodos da
 * Classe Pessoa.
 *
 * @author Rodrigo Kuninari
 */
@Entity
@DiscriminatorValue(value = "C")
@Table(name = "COLABORADOR")
@NamedQueries({
    @NamedQuery(name = "Colaborador.buscarColaboradorPeloNome", query = "SELECT p FROM Colaborador AS p WHERE p.nome like :nome ORDER BY p.nome"),
    @NamedQuery(name = "Colaborador.buscarColaboradorPeloCPF", query = "SELECT p FROM Colaborador AS p WHERE p.cpf = :cpf ORDER BY p.nome"),
    @NamedQuery(name = "Colaborador.buscarColaboradorAtivo", query = "SELECT p FROM Colaborador AS p WHERE p.situacao = 1"),
    @NamedQuery(name = "Colaborador.buscarColaboradorDesativo", query = "SELECT p FROM Colaborador AS p WHERE p.situacao = 2")
})
public class Colaborador extends Pessoa implements Serializable {

    @Column(name = "situacao", updatable = true, nullable = false)
    private int situacao;
    
    public Colaborador() {
    }

    public Colaborador(int situacao, String cpf, String nome, Date dataNascimento, String email, String linkLattes, Arquivo arquivo) {
        super(nome, cpf, dataNascimento, email, linkLattes, arquivo);
        this.situacao = situacao;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}

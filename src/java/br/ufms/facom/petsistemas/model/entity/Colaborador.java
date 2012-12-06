/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe que representa a Entidade Colaborador. Herda atributos e métodos da
 * Classe Pessoa.
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "COLABORADOR")
public class Colaborador extends Pessoa implements Serializable
{

    @Column(name = "situacao", updatable = true, nullable = false)
    private int situacao;

    public int getSituacao()
    {
        return situacao;
    }

    public void setSituacao(int situacao)
    {
        this.situacao = situacao;
    }

}

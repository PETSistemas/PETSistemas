/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "PETIANO")
public class Petiano extends Pessoa implements Serializable
{

    @Column(name = "curso", updatable = true, nullable = false)
    private int curso;

    @Column(name = "nomePai", updatable = true, nullable = false, length = 60)
    private String nomePai;

    @Column(name = "nomeMae", updatable = true, nullable = false, length = 60)
    private String nomeMae;

    @Column(name = "rg", updatable = false, nullable = false, length = 30)
    private String rg;

    @Column(name = "cpf", updatable = false, nullable = false, length = 14)
    private String cpf;

    @Column(name = "dataEntrada", updatable = false, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrada;

    @Column(name = "dataSaida", updatable = false, nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSaida;

    @Column(name = "endereco", updatable = false, nullable = false, length = 250)
    private String endereco;

    public int getCurso()
    {
        return curso;
    }

    public void setCurso(int curso)
    {
        this.curso = curso;
    }

    public String getNomePai()
    {
        return nomePai;
    }

    public void setNomePai(String nomePai)
    {
        this.nomePai = nomePai;
    }

    public String getNomeMae()
    {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae)
    {
        this.nomeMae = nomeMae;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public Date getDataEntrada()
    {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada)
    {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida()
    {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida)
    {
        this.dataSaida = dataSaida;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

}

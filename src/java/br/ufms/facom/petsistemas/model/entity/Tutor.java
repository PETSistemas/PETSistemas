/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.entity;

import java.util.Date;

/**
 *
 * @author Rodrigo Kuninari
 */
public class Tutor
{

    private Long id;

    private String rg;

    private Date dataEntrada;

    private Date dataSaida;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
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

}

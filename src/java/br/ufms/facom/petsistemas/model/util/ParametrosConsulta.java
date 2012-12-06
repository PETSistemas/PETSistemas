/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.model.util;

/**
 * Classe que representa um parâmetro de uma consulta no formato nome e valor do
 * parâmetro
 *
 * @author Rodrigo Kuninari
 */
public class ParametrosConsulta
{

    private String nome;

    private Object valor;

    public ParametrosConsulta(String nome, Object valor)
    {
        this.nome = nome;
        this.valor = valor;
    }

    public String getName()
    {
        return nome;
    }

    public Object getValue()
    {
        return valor;
    }

}

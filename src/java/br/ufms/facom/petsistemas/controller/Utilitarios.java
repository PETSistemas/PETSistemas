/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe genérica contendo métodos de apoio que podem ser utilizados por todas
 * as classes. Por exemplos, métodos de conversão, etc.
 *
 * @author Rodrigo Kuninari
 */
public class Utilitarios
{

    public Utilitarios()
    {
    }

    /**
     * Método responsável por converter uma String para um Objeto do tipo Date.
     *
     * @param data String (no formato dd/MM/yyyy) da data a ser convertida.
     * @return Objeto Date com a data convertida.
     */
    public Date stringParaData(String data)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try
        {
            Date dt = sdf.parse(data);
            return dt;
        }
        catch (Exception e)
        {
            return null;
        }

    }

    /**
     * Método responsável por converter um Objeto do tipo Date para String.
     *
     * @param data Objeto do tipo Date a ser convertido.
     * @return String (no formato dd/MM/yyyy) contendo data convertida.
     */
    public String dataParaString(Date data)
    {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.petsistemas.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;


/**
 * Classe genérica contendo métodos de apoio que podem ser utilizados por todas
 * as classes. Por exemplos, métodos de conversão, etc.
 *
 * @author Rodrigo Kuninari
 */
public class Utilitarios {

    /**
     * Método responsável por converter uma String para um Objeto do tipo Date.
     *
     * @param data String (no formato dd/MM/yyyy) da data a ser convertida.
     * @return Objeto Date com a data convertida.
     */
    public static Date stringParaData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date dt = sdf.parse(data);
            return dt;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Método responsável por converter um Objeto do tipo Date para String.
     *
     * @param data Objeto do tipo Date a ser convertido.
     * @return String (no formato dd/MM/yyyy) contendo data convertida.
     */
    public static String dataParaString(Date data) {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    public static boolean sessaoEstaAtiva(final HttpServletRequest request, String session_var) {
        return request.getSession().getAttribute(session_var) != null;
    }

    public static void iniciarSinal(final HttpServletRequest request) {
        request.getSession().setAttribute("sinal", 1);
    }

    public static void apagarSinal(final HttpServletRequest request) {
        request.getSession().removeAttribute("sinal");
    }

    public static boolean sinalOK(final HttpServletRequest request) {
        return request.getSession().getAttribute("sinal") != null;
    }

    public static String encripta(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public static boolean isCPF(String CPF) {
// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0         
// (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
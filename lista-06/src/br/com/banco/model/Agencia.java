package br.com.banco.model;
public class Agencia {
    public static String NOME_BANCO = "JavaBank";
    public static double TAXA_SAQUE = 5;
    public static int totalContasAbertas;
    public static char[] getTotalContasAbertas;

    public static void registrarNovaConta(){
        totalContasAbertas++;
    }

    public static int getTotalContasAbertas(){
        return totalContasAbertas;
    }

}

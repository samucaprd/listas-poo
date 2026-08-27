package br.com.ecommerce.main;

import br.com.ecommerce.exception.TipoFreteInvalidoException;
import br.com.ecommerce.model.*;

public class MainTeste {
    public static void main(String[] args) {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        double valorPedido = 100.00;

        try {
            System.out.println("--- Testes com Fretes Válidos ---");
            double valorSedex = calculadora.processarFrete(valorPedido, new FreteSedex());
            System.out.println("Frete SEDEX: R$ " + valorSedex);

            double valorPac = calculadora.processarFrete(valorPedido, new FretePac());
            System.out.println("Frete PAC: R$ " + valorPac);

            double valorMotoboy = calculadora.processarFrete(valorPedido, new FreteMotoboy());
            System.out.println("Frete Motoboy: R$ " + valorMotoboy);

            System.out.println("\n--- Testando Resiliência (Frete Nulo) ---");
            calculadora.processarFrete(valorPedido, null);

        } catch (TipoFreteInvalidoException e) {
            System.out.println("Erro capturado com sucesso: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado sem crashes!");
    }
}
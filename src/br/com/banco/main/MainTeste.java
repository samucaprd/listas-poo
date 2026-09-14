package br.com.banco.main;
import br.com.banco.model.Agencia;
import br.com.banco.model.Cliente;
import br.com.banco.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) throws Exception {
        Cliente c1 = new Cliente("111", "Gustavo", "gustavo@gmail.com");
        Cliente c2 = new Cliente("111", "Mateus", "mateus@gmail.com");

        System.out.println(c1.equals(c2));

        ContaBancaria conta = new ContaBancaria("01", 50, c2);

        System.out.println(conta.sacar(50));

        System.out.println(Agencia.getTotalContasAbertas());
    }
}

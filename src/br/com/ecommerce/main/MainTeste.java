package br.com.ecommerce.main;

// 🚨 AVISO: Note os IMPORTS! A classe Main está em um pacote diferente dos Modelos.
import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.model.Produto;

public class MainTeste {
    public static void main(String[] args) {
        
        System.out.println("=== BEM VINDO AO " + Cliente.NOME_LOJA + " ===");

        // 1. Criando instâncias (Objetos)
        Cliente c1 = new Cliente("111.222.333-44", "João da Silva");
        Cliente c2 = new Cliente("111.222.333-44", "João Falso"); // Mesmo CPF!
        
        Produto p1 = new Produto("P01", "Notebook", 3500.00);
        Produto p2 = new Produto("P02", "Mouse Sem Fio", 150.00);

        // 2. Testando o equals() (Fase 2 da Aula 3)
        System.out.println("\nTestando a identidade dos clientes:");
        if (c1.equals(c2)) {
            System.out.println("O Sistema bloqueou! Clientes são iguais (Mesmo CPF).");
        }

        // 3. Montando as Associações e Listas
        Pedido pedido1 = new Pedido("REQ-1001", c1);
        pedido1.adicionarItem(p1, 1);
        pedido1.adicionarItem(p2, 2);

        // O Pedido agora pertence ao Cliente
        c1.getPedidos().add(pedido1);

        // 4. Testando o toString() (Fase 1 da Aula 3)
        System.out.println("\nResumo do Sistema:");
        System.out.println(c1);
        System.out.println(pedido1);
        
        System.out.println("\nItens comprados:");
        for(int i = 0; i < pedido1.getItens().size(); i++) {
            System.out.println("- " + pedido1.getItens().get(i));
        }

        System.out.println("\nTotal de Clientes no Servidor: " + Cliente.contadorClientes);
    }
}

package br.com.ecommerce.main;

// Importações corretas dos Modelos
import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

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

        // ==========================================
        // PARTE CORRIGIDA (Antiga classe AppEcommerce)
        // ==========================================
        System.out.println("\n=== TESTANDO O CARRINHO ===");
        
        // Aumentamos o tamanho para 4 para não estourar o limite
        
        List<Produto> carrinho = new ArrayList<>();//vazio a partir do Java 7

        carrinho.add(new Produto(null, "Filtro de Óleo Yamaha R3", 85.00));
        carrinho.add(new Produto(null, "Camisa do Corinthians", 299.90));
        carrinho.add(new Produto(null, "Bola de Basquete", 150.00));
        carrinho.add(new Produto(null, "Bolha Esportiva R3", 350.00)); 


    }
    
}

public class TestaSet {
public static void main(String[] args) {
Set<Produto> favoritos = new HashSet<>();
Produto bola = new Produto("Bola de Basquete", null, 150.00);

favoritos.add(bola);
favoritos.add(bola); // Será solenemente ignorado
System.out.println("Tamanho: " + favoritos.size()); // Imprime 1
}
}


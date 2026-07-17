package br.com.ecommerce.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    
    // 🎓 AULA 03: 'public static final' cria uma constante (Imutável e Global para toda a classe)
    public static final String NOME_LOJA = "JavaCommerce";
    
    // 🎓 AULA 03: 'static' compartilha a variável na RAM. Todas as instâncias olham para o mesmo número.
    public static int contadorClientes = 0;

    private String cpf;
    private String nome;
    
    // 🎓 AULA 05: Associação 1..* (Um cliente tem VÁRIOS pedidos)
    // Usamos a Interface List no atributo (Desacoplamento).
    private List<Pedido> pedidos;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        
        // 🚨 ARMADILHA EVITADA: Se não instanciar a lista no construtor com 'new ArrayList<>()', 
        // ao tentar adicionar um pedido lá na Main, ocorrerá um NullPointerException!
        this.pedidos = new ArrayList<>();
        
        contadorClientes++; // Conta +1 sempre que houver um 'new Cliente()'
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public List<Pedido> getPedidos() { return pedidos; }

    // 🎓 AULA 03: O Equals usa APENAS o CPF como Chave Primária de comparação.
    // Assim impedimos dois clientes com o mesmo CPF no sistema, mesmo que tenham nomes diferentes.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    // 🚨 AVISO: O Contrato do Java exige: Sobrescreveu o equals? Tem que sobrescrever o hashCode!
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    // 🎓 AULA 03: Transforma aquele "lixo de memória" em um texto legível para o System.out.println()
    @Override
    public String toString() {
        return "Cliente [CPF: " + cpf + ", Nome: " + nome + "]";
    }
}

package br.com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private String numero;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.itens = new ArrayList<>(); // Inicializando a lista na memória!
    }

    // 🎓 AULA 05: Método que encapsula a adição na lista. 
    // A classe Main não deve dar "pedido.getItens().add()". Quem adiciona o item é o próprio Pedido!
    public void adicionarItem(Produto p, int quantidade) {
        ItemPedido novoItem = new ItemPedido(p, quantidade);
        this.itens.add(novoItem);
    }

    public double calcularTotal() {
        double total = 0.0;
        // 🎓 AULA 05: Iterando sobre as Collections com For-Each
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public String getNumero() { return numero; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(numero, pedido.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Pedido Nº " + numero + " | Cliente: " + cliente.getNome() + " | Total: R$ " + calcularTotal();
    }
}

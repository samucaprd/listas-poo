package br.com.ecommerce.model;

public class ItemPedido {
    // 🎓 AULA 02: Associação 1:1. Um ItemPedido conhece exatamente 1 Produto.
    private Produto produto;
    private int quantidade;
    private double precoUnitario; 

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        // 🚨 ARMADILHA EVITADA: Gravamos o preço do produto no momento da compra. 
        // Se o preço do Produto mudar no banco de dados amanhã, o histórico deste pedido não será alterado!
        this.precoUnitario = produto.getPreco();
    }

    // 🎓 AULA 02: Método com lógica de negócio (Comportamento).
    public double calcularSubtotal() {
        return this.quantidade * this.precoUnitario;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return quantidade + "x " + produto.getNome() + " = R$ " + calcularSubtotal();
    }
}

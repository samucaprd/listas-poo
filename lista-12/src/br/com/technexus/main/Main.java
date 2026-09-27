package br.com.technexus.main;

import br.com.technexus.model.Produto;
import br.com.technexus.service.Loja;

public class Main {

    public static void main(String[] args) {

        Loja loja = new Loja();

        loja.cadastrar(
                new Produto("The Witcher", "GAMES", 150.00)
        );

        loja.cadastrar(
                new Produto("FIFA", "GAMES", 200.00)
        );

        loja.cadastrar(
                new Produto("Java for Dummies", "LIVROS", 100.00)
        );

        loja.cadastrar(
                new Produto("Clean Code", "LIVROS", 80.00)
        );

        loja.cadastrar(
                new Produto("Mouse", "HARDWARE", 50.00)
        );

        System.out.println("Produtos da categoria GAMES:");
        System.out.println(
                loja.buscarPorCategoria("GAMES")
        );

        System.out.println(
                "Patrimônio total: R$ " +
                loja.calcularPatrimonioTotal()
        );

        System.out.println(
                "Total da categoria LIVROS: R$ " +
                loja.calcularTotalPorCategoria("LIVROS")
        );
    }
}
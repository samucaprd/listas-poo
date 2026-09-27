package br.com.technexus.service;

import br.com.technexus.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Loja {

    private List<Produto> catalogo = new ArrayList<>();

    public void cadastrar(Produto p) {
        this.catalogo.add(p);
    }

    public List<Produto> buscarPorCategoria(String catDesejada) {

        return this.catalogo.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(catDesejada))
                .collect(Collectors.toList());
    }

    public double calcularPatrimonioTotal() {

        return this.catalogo.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }

    public double calcularTotalPorCategoria(String catDesejada) {

        return this.catalogo.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(catDesejada))
                .mapToDouble(Produto::getPreco)
                .sum();
    }
}
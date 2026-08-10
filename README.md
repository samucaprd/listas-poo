# 🛒 JavaCommerce - Versão Base (Referência)

Este repositório contém a implementação completa das funcionalidades fundamentais de um sistema de vendas. Ele serve como gabarito e guia de estudos para entender como objetos colaboram em um sistema real.

## 🚩 Starter vs. Base: Qual a diferença?

Para facilitar o aprendizado, dividimos nossos projetos em dois níveis:

*   **Versão Starter:** É o esqueleto do projeto. Contém apenas as definições das classes e comentários `// TODO`, desafiando o aluno a implementar a lógica, os métodos e as associações do zero.
*   **Versão Base (Esta):** É a versão funcional e "gabaritada". Aqui, as regras de negócio (como cálculos de total e validações de CPF) já estão codificadas, servindo como material de consulta e revisão.

---

## 📂 Menu de Arquivos e Conceitos

Cada arquivo neste projeto foi desenhado para ensinar um conceito específico de POO:

### 📦 `br.com.ecommerce.model`

*   **`Cliente.java`**
    *   **Membros Estáticos:** Demonstra o uso de `static` para contar quantos clientes foram criados na memória e definir constantes globais (`NOME_LOJA`).
    *   **Igualdade:** Implementa `equals()` e `hashCode()` para garantir que dois clientes não sejam tratados como diferentes se possuírem o mesmo CPF.
    *   **Associação 1..*:** Possui uma lista de pedidos vinculados ao cliente.

*   **`Produto.java`**
    *   **Entidade Simples:** Representa o catálogo. Foca em encapsulamento (private) e acesso via métodos getter.

*   **`ItemPedido.java`**
    *   **Regra de Histórico:** Note que ele armazena o `precoUnitario` no momento da criação. Isso ensina que, se o preço do produto mudar no futuro, o valor pago neste item específico deve ser preservado.
    *   **Lógica de Cálculo:** Possui o método `calcularSubtotal()`.

*   **`Pedido.java`**
    *   **Agregação:** Gerencia uma lista de `ItemPedido`.
    *   **Encapsulamento de Comportamento:** Em vez de apenas dar um "add" na lista lá na Main, o pedido tem o método `adicionarItem()`, que centraliza a responsabilidade de criar a relação.
    *   **Iteração:** Usa o laço *for-each* para percorrer os itens e somar o valor total da compra.

### 📦 `br.com.ecommerce.main`

*   **`MainTeste.java`**
    *   **Simulação Real:** Orquestra a criação de objetos, testa a regra de CPFs duplicados e imprime um resumo completo do pedido no console. Observe como os `imports` são necessários para conectar os pacotes.

---

## 🎓 O que observar neste código?

1.  **Proteção contra NullPointerException:** Note como as listas (`ArrayList`) são inicializadas dentro dos **construtores**. Isso evita que o programa quebre ao tentarmos adicionar itens.
2.  **Sobrescrita (@Override):** Veja como o método `toString()` foi personalizado em cada classe para que, ao imprimir um objeto, o Java mostre informações úteis em vez do endereço de memória.
3.  **Desacoplamento:** O uso da interface `List` (em vez de `ArrayList` diretamente nos atributos) é uma boa prática para tornar o código mais flexível.

---

## 🚀 Como utilizar
Este código é para leitura e execução de testes.
1. Execute a classe `MainTeste.java`.
2. Analise a saída no console.
3. Tente modificar o preço de um produto na Main após o pedido ser criado e veja se o `ItemPedido` mantém o valor original (Lógica de Preço Histórico).

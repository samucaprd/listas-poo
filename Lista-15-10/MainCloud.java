
public class MainCloud {
    public static void main(String[] args) {

        // instancia o gerenciador. ra: 25362604-2
        CloudManager manager = new CloudManager();

        // instancia o cliente. ra: 25362604-2
        Cliente cliente = new Cliente(
            "111.222.333-44",
            "Wayne Enterprises"
        );

        // instancia o servidor com 16 gb de ram. ra: 25362604-2
        Servidor servidor = new Servidor(
            "192.168.0.1",
            16.0,
            5.50
        );

        // registra o cliente no mapa. ra: 25362604-2
        manager.registrarCliente(cliente);

        // adiciona o servidor ao cliente. ra: 25362604-2
        manager.adicionarServidor(cliente, servidor);

        // cria dois containers com ram diferente. ra: 25362604-2
        Container container1 = new Container("C-01", 10.0);
        Container container2 = new Container("C-02", 8.0);

        // testa a falha com o servidor desligado. ra: 25362604-2
        //try {
           // servidor.alocarContainer(container1);
       // } catch (CapacidadeExcedidaException e) {
          //  System.out.println(e.getMessage());
        //}
    
        // liga o servidor. ra: 25362604-2
        servidor.ligar();

        // tenta alocar o primeiro container. ra: 25362604-2
        try {
            servidor.alocarContainer(container1);
            System.out.println("Container 1 alocado com sucesso.");
        } catch (CapacidadeExcedidaException e) {
            // mostra o erro. ra: 25362604-2
            System.out.println(e.getMessage());
        }

        // tenta alocar o segundo container. ra: 25362604-2
        try {
            servidor.alocarContainer(container2);
        } catch (CapacidadeExcedidaException e) {
            // mostra o erro de. ra: 25362604-2
            System.out.println(e.getMessage());
        }

        // calcula a fatura do cliente. ra: 25362604-2
        double fatura = manager.calcularFaturaAtiva(cliente);

        // mostra o valor da fatura. ra: 25362604-2
        System.out.printf("Fatura ativa: R$ %.2f%n", fatura);
    }
}

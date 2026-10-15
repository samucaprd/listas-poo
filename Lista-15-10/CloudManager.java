
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

public class CloudManager {
    // mapa que relaciona clientes e servidores ra: 25362604-2
    private Map<Cliente, Set<Servidor>> bancoDeDados;

    // inicializa o mapa com hashmap. ra: 25362604-2
    public CloudManager() {
        bancoDeDados = new HashMap<>();
    }

    // retorna o banco de dados ra: 25362604-2
    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados;
    }

    // registra o cliente se n exista ra: 25362604-2
    public void registrarCliente(Cliente cliente) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>());
    }

    // adiciona um servidor ao cliente ra: 25362604-2
    public void adicionarServidor(Cliente cliente, Servidor servidor) {
        bancoDeDados.computeIfAbsent(
            cliente, c -> new HashSet<>()
        ).add(servidor);
    }

    // soma o preço dos servidores ligados usando stream. ra: 25362604-2
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados
        .getOrDefault(c, Collections.emptySet())
        .stream()
        .filter(s -> s.isStatusLigado())
        .mapToDouble(s -> s.getPrecoPorHora())
        .sum();
    }
}


import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Servidor {
    // atributos do servidr. ra: 25362604-2
    String ip;
    double precoPorHora;
    double ramTotal;
    boolean statusLigado;
    List<Container> containers;

    // inicializa o servidor desligado e com lista vazia. ra: 25362604-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false;
        this.containers = new ArrayList<>();
    }

    // retorna o ip. ra: 25362604-2
    public String getIp() {
        return ip;
    }

    // altera o ip. ra: 25362604-2
    public void setIp(String ip) {
        this.ip = ip;
    }

    // retorna a ram total. ra: 25362604-2
    public double getRamTotal() {
        return ramTotal;
    }

    // altera a ram total. ra: 25362604-2
    public void setRamTotal(double ramTotal) {
        this.ramTotal = ramTotal;
    }

    // retorna o preço por hora. ra: 25362604-2
    public double getPrecoPorHora() {
        return precoPorHora;
    }

    // altera o preço por hora. ra: 25362604-2
    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    // verifica se está ligado. ra: 25362604-2
    public boolean isStatusLigado() {
        return statusLigado;
    }

    // altera o status do servidor. ra: 25362604-2
    public void setStatusLigado(boolean statusLigado) {
        this.statusLigado = statusLigado;
    }

    // retorna a lista de containers. ra: 25362604-2
    public List<Container> getContainers() {
        return containers;
    }

    // liga o servidor. ra: 25362604-2
    public void ligar() {
        statusLigado = true;
    }

    // soma a ram usada pelos containers com stream. ra: 25362604-2
    public double calcularRamEmUso() {
    return containers.stream()
            .mapToDouble(c -> c.getRamNecessaria())
            .sum();
    }

    // valida e aloca o container no servidor. ra: 25362604-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {

        // verifica se o servidor está desligado. ra: 25362604-2
        if (statusLigado == false){
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }

        // verifica se a ram ultrapassa o limite. ra: 25362604-2
        if (c.getRamNecessaria() + calcularRamEmUso() > ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip);
        }

        // adiciona o container na lista. ra: 25362604-2
        containers.add(c);
    }

    // compara os servidores pelo ip. ra: 25362604-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Servidor)) return false;

        Servidor outro = (Servidor) obj;
        return Objects.equals(ip, outro.ip);
    }

    // gera o hash usando o ip. ra: 25362604-2
    @Override
    public int hashCode() {
        return Objects.hashCode(ip);
    }
}

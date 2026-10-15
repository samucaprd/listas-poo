
import java.util.Objects;

public class Container {
    // atributos do container. ra: 25362604-2
    private String id;
    private double ramNecessaria;

    // construtor do container. ra: 25362604-2
    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    // retorna o id. ra: 25362604-2
    public String getId() {
        return id;
    }

    // altera o id. ra: 25362604-2
    public void setId(String id) {
        this.id = id;
    }

    // retorna a ram necessária. ra: 25362604-2
    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // altera a ram necessária. ra: 25362604-2
    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // compara os containers pelo id. ra: 25362604-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Container)) return false;

        Container outro = (Container) obj;
        return Objects.equals(id, outro.id);
    }

    // gera o hash pelo id. ra: 25362604-2
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

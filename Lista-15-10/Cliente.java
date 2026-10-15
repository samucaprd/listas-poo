
public class Cliente {
    // atributos do cliente. ra: 25362604-2
    private String cpf;
    private String nome;

    // construtor para inicializar os atributos. ra: 25362604-2
    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    // retorna o cpf do cliente. ra: 25362604-2
    public String getCpf() {
        return cpf;
    }

    // retorna o nome do cliente. ra: 25362604-2
    public String getNome() {
        return nome;
    }

    // gera o hash usando o cpf. ra: 25362604-2
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    // compara os clientes pelo cpf. ra: 25362604-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    
}

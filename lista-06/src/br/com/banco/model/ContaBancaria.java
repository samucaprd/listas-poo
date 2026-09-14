package br.com.banco.model;
public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private Cliente titular;
    
    
    public ContaBancaria(String numeroConta, double saldo, Cliente titular) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.titular = titular;
        Agencia.registrarNovaConta();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor){
        if(valor > 0){
            saldo = saldo + valor;
        }
    }

    public boolean sacar(double valor){
        if(valor > 0 && (valor + Agencia.TAXA_SAQUE) <= saldo){
            saldo = saldo - (valor + Agencia.TAXA_SAQUE);
            return true;
        }
        else{
            return false;
        }
    }


    
}

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Iconta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;
    protected double gasto;
    protected double ganho;
    protected List<String> logs = new ArrayList<>();

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    protected void imprimirInfos() {
        System.out.println("Cliente: " +  this.cliente.getNomeCompleto());
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Conta: %d%n", this.conta);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    protected void historicoConta(){
        logs.forEach(System.out::println);
        System.out.println("----------------------------");
        System.out.println("Ganho total:" + String.format("%.2f",ganho) + " R$");
        System.out.println("Gasto total:" + String.format("%.2f",gasto) + " R$");
        System.out.println("Saldo: " + String.format("%.2f",this.saldo) + " R$");
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo - valor >= 0){
            this.saldo -= valor;
            this.gasto += valor;
            this.logs.add("Saque de " + valor + "0 R$");
        } else {
            System.out.println("Saldo insuficiente");
        }

    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;

        this.ganho += valor;

        this.logs.add("Depósito de " + valor + "0 R$");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(this.saldo - valor >= 0){
            this.saldo -= valor;
            this.gasto += valor;

            contaDestino.depositar(valor);
            contaDestino.ganho += valor;

            this.logs.add("Transferência enviada de " + valor + "0 R$ para " + contaDestino.cliente.getNomeCompleto());
            contaDestino.logs.add("Transferência recebida de " + valor + "0 R$ de" + this.cliente.getNomeCompleto());
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
}

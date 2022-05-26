public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }
    @Override
    public void imprimirExtrato(){
        System.out.println("======= SALDO DA CONTA POUPANÇA =======");
        super.imprimirInfos();
    }
    public void historico(){
        System.out.println("======= HISTÓRICO DA CONTA POUPANÇA =======");
        super.historicoConta();
    }
}

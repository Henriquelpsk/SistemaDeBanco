public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("======= SALDO DA CONTA CORRENTE =======");
        super.imprimirInfos();
    }

    public void historico(){
        System.out.println("======= HISTORICO DA CONTA CORRENTE =======");
        super.historicoConta();
    }
}

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente c1 = new Cliente();
        c1.setNomeCompleto("Henrique Lima");
        c1.setCpf("849685827-81");

        Cliente c2 = new Cliente();
        c2.setNomeCompleto("João Pedro");
        c2.setCpf("850578266-62");

        Conta contaC1 = new ContaPoupanca(c1);
        Conta contaC2 = new ContaCorrente(c2);

        contaC1.depositar(500);
        contaC1.sacar(500);
        contaC1.depositar(20);
        contaC1.depositar(100);
        contaC1.transferir(200,contaC2);

        System.out.println("Bem vindo ao <Nome banco>");
        System.out.println();
        System.out.println("Insira seu nome completo");
        String nome = sc.next();
        System.out.println("Agora insira seu cpf (xxxxxxxxx-xx)");
        String cpf = sc.next();
        System.out.println();

        Cliente teste = new Cliente();
        teste.setNomeCompleto(nome);
        teste.setCpf(cpf);

        Conta contaTeste = new ContaPoupanca(teste);

        int escolha2 = 0;
        while(escolha2 != 6){
            System.out.println("Digite [1] para depósito");
            System.out.println("Digite [2] para saque");
            System.out.println("Digite [3] para transferência");
            System.out.println("Digite [4] para mostrar o saldo");
            System.out.println("Digite [5] para mostrar o histórico");
            System.out.println("Digite [6] para sair");
            System.out.println();
            escolha2 = sc.nextInt();

            if(escolha2 == 1){
                System.out.println("Digite o valor que deseja depositar: ");
                int valor = sc.nextInt();
                contaTeste.depositar(valor);
                System.out.println();

            }else if(escolha2 == 2){
                System.out.println("Digite o valor que deseja sacar: ");
                int valor = sc.nextInt();
                contaTeste.sacar(valor);
                System.out.println();

            }else if(escolha2 == 3){
                System.out.println("Digite o valor que deseja transferir: (contaC1 definido por padrão para testes)");
                int valor = sc.nextInt();
                contaTeste.transferir(valor,contaC1);
                System.out.println();

            }else if(escolha2 == 4){
                contaTeste.imprimirExtrato();
                System.out.println();

            }else if(escolha2 == 5){
                contaTeste.historico();
                System.out.println();

            }else if(escolha2 == 6){
                System.out.println("Saindo...");
            }else {
                System.out.println("Escolha um valor entre 1 e 6");
            }
        }

    }
}

package com.bancopoojava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("Banco Digital");
        
        System.out.println("Bem-vindo ao Banco Digital!");
        
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);
        
        banco.adicionarCliente(cliente);
        
        Conta conta = null;
        
        while (true) {
            System.out.println("\nEscolha o tipo de conta para criar:");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            System.out.print("Opção: ");
            int tipoConta = scanner.nextInt();
            
            if (tipoConta == 1) {
                conta = new ContaCorrente(cliente);
                break;
            } else if (tipoConta == 2) {
                conta = new ContaPoupanca(cliente);
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        banco.adicionarConta(conta);
        
        while (true) {
            System.out.println("\nEscolha a operação:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.print("Digite o número da conta destino: ");
                    int numeroContaDestino = scanner.nextInt();
                    Conta contaDestino = banco.getConta(numeroContaDestino);
                    if (contaDestino == null) {
                        System.out.println("Conta destino não encontrada!");
                        break;
                    }
                    System.out.print("Digite o valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    conta.transferir(valorTransferencia, contaDestino);
                    break;
                case 4:
                    System.out.println("Obrigado por usar o Banco Digital!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}

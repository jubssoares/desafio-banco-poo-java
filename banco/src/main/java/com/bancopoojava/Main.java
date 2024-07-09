package com.bancopoojava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Mostrar Contas");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    criarConta(scanner, banco, true);
                    break;
                case 2:
                    criarConta(scanner, banco, false);
                    break;
                case 3:
                    realizarDeposito(scanner, banco);
                    break;
                case 4:
                    realizarSaque(scanner, banco);
                    break;
                case 5:
                    realizarTransferencia(scanner, banco);
                    break;
                case 6:
                    mostrarContas(banco);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void criarConta(Scanner scanner, Banco banco, boolean isCorrente) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);
        Conta conta;

        if (isCorrente) {
            conta = new ContaCorrente(cliente, 0.0);
        } else {
            conta = new ContaPoupanca(cliente, 0.0);
        }

        banco.adicionarConta(conta);
        System.out.println("Conta criada: " + conta);
    }

    private static void realizarDeposito(Scanner scanner, Banco banco) {
        System.out.println("Digite o número da conta:");
        String numeroConta = scanner.nextLine();
        Conta conta = banco.buscarContaPorNumero(numeroConta);

        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.println("Digite o valor do depósito:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consome a nova linha

        conta.depositar(valor);
        System.out.println("Depósito realizado: " + conta);
    }

    private static void realizarSaque(Scanner scanner, Banco banco) {
        System.out.println("Digite o número da conta:");
        String numeroConta = scanner.nextLine();
        Conta conta = banco.buscarContaPorNumero(numeroConta);

        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.println("Digite o valor do saque:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consome a nova linha

        conta.sacar(valor);
        System.out.println("Saque realizado: " + conta);
    }

    private static void realizarTransferencia(Scanner scanner, Banco banco) {
        System.out.println("Digite o número da conta de origem:");
        String numeroContaOrigem = scanner.nextLine();
        Conta contaOrigem = banco.buscarContaPorNumero(numeroContaOrigem);

        if (contaOrigem == null) {
            System.out.println("Conta de origem não encontrada.");
            return;
        }

        System.out.println("Digite o número da conta de destino:");
        String numeroContaDestino = scanner.nextLine();
        Conta contaDestino = banco.buscarContaPorNumero(numeroContaDestino);

        if (contaDestino == null) {
            System.out.println("Conta de destino não encontrada.");
            return;
        }

        System.out.println("Digite o valor da transferência:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consome a nova linha

        contaOrigem.transferir(contaDestino, valor);
        System.out.println("Transferência realizada: ");
        System.out.println("Origem: " + contaOrigem);
        System.out.println("Destino: " + contaDestino);
    }

    private static void mostrarContas(Banco banco) {
        System.out.println("Contas no banco:");
        for (Conta conta : banco.getContas()) {
            System.out.println(conta);
        }
    }
}

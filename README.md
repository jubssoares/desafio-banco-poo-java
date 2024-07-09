# Criando um Banco Digital com Java e Orientação a Objetos

<img align="right" height="200" style="border-radius:50px;" src="https://hermes.dio.me/tracks/a039b34c-7aa8-4a3d-b765-07c8c837f67a.png">

### Repositório criado para o desafio do bootcamp Santander 2024 - Backend com Java

<p align="justify">
    <br>
   Este projeto implementa um sistema bancário digital utilizando Java, seguindo os princípios da Programação Orientada a Objetos (POO). O sistema oferece aos clientes funcionalidades básicas de operações bancárias, incluindo a criação de contas correntes e poupança, depósito, saque e transferência entre contas. O projeto foi desenvolvido usando o Apache Maven como ferramenta de gerenciamento de dependências e construção de projeto, e inclui a biblioteca Lombok para reduzir a verbosidade do código.
    <br>
</p>

### Funcionalidades Principais

* Banco: Gerencia clientes e contas.
* Cliente: Representa um cliente do banco.
* Conta: Classe abstrata representando uma conta bancária genérica, com métodos para depósito, saque e transferência.
* ContaCorrente: Subclasse de Conta específica para contas correntes.
* ContaPoupanca: Subclasse de Conta específica para contas poupança.
* Transacao: Representa uma transação bancária (não utilizada diretamente no fluxo principal do programa).

### Implementação

<p align="justify">
  <b>Banco.java:</b> Gerencia a lista de clientes e contas do banco, permitindo a adição de novos clientes e contas, além de buscar contas pelo número.
  <br><br>
  <b>Cliente.java:</b> Representa um cliente com um nome. Utiliza Lombok para geração automática de getters, setters e outros métodos utilitários.
  <br><br>
  <b>Conta.java:</b> Classe abstrata que define as operações comuns para todas as contas, como depósito, saque e transferência. Inclui um número de conta sequencial e saldo.
  <br><br>
  <b>ContaCorrente.java e ContaPoupanca.java:</b> Implementações específicas de Conta para contas correntes e poupança, respectivamente.
  <br><br>
  <b>Main.java:</b> Classe principal que fornece uma interface de linha de comando para o usuário interagir com o sistema bancário. Permite criar um cliente, escolher o tipo de conta, e realizar operações como depósito, saque e transferência.
</p>

### Execução do Projeto

Para compilar e executar o projeto, siga os comandos abaixo:

1. Compile o projeto:
```sh
mvn clean compile
```
2. Execute o projeto:
```sh
mvn exec:java -Dexec.mainClass="com.bancopoojava.Main"
```


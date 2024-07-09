package com.bancopoojava;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Conta {
    private String numero;
    private Cliente cliente;
    private double saldo;
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta(Cliente cliente, double saldoInicial) {
        this.numero = gerarNumeroConta();
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    private String gerarNumeroConta() {
        return "123456"; // Lógica para gerar número de conta
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao("Depósito", valor));
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao("Saque", valor));
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && valor <= saldo) {
            sacar(valor);
            contaDestino.depositar(valor);
            transacoes.add(new Transacao("Transferência", valor));
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", cliente=" + cliente.getNome() +
                ", saldo=" + saldo +
                '}';
    }
}

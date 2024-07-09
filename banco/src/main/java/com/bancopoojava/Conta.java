package com.bancopoojava;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta {
    private static int SEQUENCIAL = 1;
    
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    int getNumero() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

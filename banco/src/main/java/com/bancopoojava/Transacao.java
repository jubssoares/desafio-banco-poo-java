package com.bancopoojava;

import lombok.Data;

@Data
public class Transacao {
    private String tipo;
    private double valor;
    private Conta contaOrigem;
    private Conta contaDestino;

    public Transacao(String tipo, double valor, Conta contaOrigem, Conta contaDestino) {
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }
}

package com.bancopoojava;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaPorNumero(String numeroConta) {
        return contas.stream()
            .filter(conta -> conta.getNumero().equals(numeroConta))
            .findFirst()
            .orElse(null);
    }
}


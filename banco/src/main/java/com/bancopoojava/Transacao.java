package com.bancopoojava;

package com.seu.projeto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transacao {
    private String tipo;
    private double valor;
}
